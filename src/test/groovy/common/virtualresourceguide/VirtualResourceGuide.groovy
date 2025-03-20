package common.virtualresourceguide


import static com.codeborne.selenide.Condition.*

/**
 * Common class for Virtual Resource Guide
 * Page URL: https://truancy2.dranspo.se/
 * @author lhaynes
 */
class VirtualResourceGuide {
    final static String localURL = "http://localhost:3000"
    final static String dockerURL = "https://truancy2.dranspo.se"
    String hostURL

    VirtualResourceGuide(boolean isLocal = false) {
        hostURL = isLocal ? localURL : dockerURL
    }

    /**HEADER**/
    Header header = new Header()

    /**FAQ Tab**/
    FAQTab faqTab = new FAQTab()

    /**Welcome Tab**/
    WelcomeTab welcomeTab = new WelcomeTab()

    /**Resource Tab**/
    ResourceTab resourceTab = new ResourceTab()

    /**Decision Tree Tab**/
    DecisionTreeTab decisionTreeTab = new DecisionTreeTab()

    boolean navigateToTab(String tabName) {
        def tabs =
                [
                        faq         : [header.faqNavBtn, faqTab.faqTitle],
                        welcome     : [header.welcomeNavBtn, welcomeTab.welcomeTitle],
                        resources   : [header.resourceNavBtn, resourceTab.resourceTitle],
                        decisionTree: [header.decisionTreeNavBtn, decisionTreeTab.decisionTreeTitleElement]
                ]
        def tab = tabs.find { it.key.equalsIgnoreCase(tabName) }

        tab.value[0].click()
        tab.value[1].shouldBe(visible)
    }
}
