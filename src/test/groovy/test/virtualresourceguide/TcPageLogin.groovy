package test.virtualresourceguide

import common.virtualresourceguide.VirtualResourceGuide
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import test.RunTest

class TcPageLogin extends RunTest{
    VirtualResourceGuide vrg = new VirtualResourceGuide(true)

    @BeforeEach
    void setUp() {
        open(vrg.hostURL)
    }

    /**
     * Test to ensure functionality of login to page
     * @AC - Login to page works
     * @author lhaynes
     */
    @Test
    void correctLoginTest() {
        vrg.loginToPage()

        def buttonListWithExpectedTitlePostLogin =
                [
                        "Welcome Page"  : vrg.header.welcomeNavBtn,
                        "FAQ"           : vrg.header.faqNavBtn,
                        "Resources"     : vrg.header.resourceNavBtn,
                        "Resource Guide": vrg.header.resourceGuideNavBtn,
                        "File Upload"   : vrg.header.fileUploadNavBtn,
                        "Logout"        : vrg.header.logoutNavBtn,
                ]
        for (def btnPair : buttonListWithExpectedTitlePostLogin) {
            def btn = btnPair.value
            def expectedTitle = btnPair.key

            //Button should be present
            btn.shouldBe(visible)

            //Button should have expected text
            btn.shouldHave(text(expectedTitle))
        }
    }

    /**
     * Test to ensure failed login displays failed login modal.
     * @AC - Login to page works
     * @author lhaynes
     */
    @Test
    void failedLogin() {
        assertEquals(false, vrg.loginToPage("Automation Test", "Automation Test"))

        def alertText = switchTo().alert().text
        def expectedText = "Invalid login credentials!"
        assertEquals(alertText, expectedText)
    }
}
