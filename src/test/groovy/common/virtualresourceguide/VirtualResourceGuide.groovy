package common.virtualresourceguide

import com.codeborne.selenide.SelenideElement
import static org.junit.jupiter.api.Assertions.*
import static com.codeborne.selenide.Condition.*

/**
 * Common class for Virtual Resource Guide
 * Page URL: https://truancy2.dranspo.se/
 * @author lhaynes
 */
class VirtualResourceGuide {
    /**HOST URL**/
    static final String hostURL = "https://truancy2.dranspo.se"

    /**HEADER**/
    VRGHeader header = new VRGHeader()

    /**Welcome Tab**/
    VRGWelcomeTab welcomeTab = new VRGWelcomeTab()

    /**Resource Tab**/
    VRGResourceTab resourceTab = new VRGResourceTab()

    /**Decision Tree Tab**/
    VRGDecisionTreeTab decisionTreeTab = new VRGDecisionTreeTab()

    boolean navigateToTab(String tabName) {
        def tabs =
                [
                        welcome     : [header.welcomeNavBtn, welcomeTab.welcomeTitleElement],
                        resources   : [header.resourceNavBtn, resourceTab.resourceTitle],
                        decisionTree: [header.decisionTreeNavBtn, decisionTreeTab.decisionTreeTitleElement]
                ]
        def tab = tabs.find {it.key.equalsIgnoreCase(tabName)}

        tab.value[0].click()
        tab.value[1].shouldBe(visible)
    }
}
