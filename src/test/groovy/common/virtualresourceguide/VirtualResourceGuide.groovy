package common.virtualresourceguide

import test.RunClass
import test.RunTest

import static com.codeborne.selenide.Condition.*

/**
 * Common class for Virtual Resource Guide
 * Page URL: https://truancy2-osu.nrp-nautilus.io
 * @author lhaynes
 */
class VirtualResourceGuide {
    final static String localURL = "http://localhost:3000"
    final static String dockerURL = "https://truancy2-osu.nrp-nautilus.io"
    protected RunClass r
    String hostURL

    VirtualResourceGuide(boolean isLocal = false) {
        hostURL = isLocal ? localURL : dockerURL
        r = RunTest.r()
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
    ResourceGuideTab resourceGuideTab = new ResourceGuideTab()

    boolean navigateToTab(String tabName) {
        def tabs =
                [
                        faq             : [header.faqNavBtn, faqTab.faqTitle],
                        welcome         : [header.welcomeNavBtn, welcomeTab.welcomeTitle],
                        resources       : [header.resourceNavBtn, resourceTab.resourceTitle],
                        "resource guide": [header.resourceGuideNavBtn, resourceGuideTab.resourceGuideTitleElement]
                ]
        def tab = tabs.find { it.key.equalsIgnoreCase(tabName) }

        tab.value[0].click()
        tab.value[1].shouldBe(visible)
    }

    boolean loginToPage(String username = "admin", String password = "password") {
        if (header.logoutNavBtn.isDisplayed()) {
            System.out.println("Already logged into page.")
            return true
        }

        header.facultyLoginNavBtn.click()

        if (!(header.loginModal.userNameInput.setValue(username).value == username)) {
            System.out.println("ERROR: Could not set input text.")
            return false
        }

        if (!(header.loginModal.passwordInpt.setValue(password).value == password)) {
            System.out.println("ERROR: Could not set input text.")
            return false
        }

        header.loginModal.submitBtn.click()
        if (r.isAlertPresent()) {
            System.out.println("ERROR: Could not login.")
            return false
        }

        return true
    }
}
