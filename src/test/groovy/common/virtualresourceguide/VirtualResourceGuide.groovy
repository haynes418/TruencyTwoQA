package common.virtualresourceguide


import static com.codeborne.selenide.Condition.*

/**
 * Common class for Virtual Resource Guide
 * Page URL: https://truancy2.dranspo.se/
 * @author lhaynes
 */
class VirtualResourceGuide {
    final static String localURL = "http://localhost:3000"
    final static String dockerURL = "https://truancy2-osu.nrp-nautilus.io"
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

    boolean loginToPage(String username = "admin", String password = "password") {
        if(header.logoutNavBtn.isDisplayed()){
            System.out.println("Already logged into page.")
            return true
        }

        header.loginNavBtn.click()

        if(!(header.loginModal.userNameInput.setValue(username).value == username)) {
            System.out.println("ERROR: Could not set input text.")
            return false
        }

        if(!(header.loginModal.passwordInpt.setValue(password).value == password)) {
            System.out.println("ERROR: Could not set input text.")
            return false
        }

        header.loginModal.submitBtn.click()
        if(!header.loginModal.modal.shouldNotBe(visible)){
            System.out.println("ERROR: Could not login.")
            return false
        }

        return true
    }
}
