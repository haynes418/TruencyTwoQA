package test.virtualresourceguide

import common.virtualresourceguide.VirtualResourceGuide
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import test.RunTest

import static com.codeborne.selenide.Condition.text
import static com.codeborne.selenide.Condition.visible
import static com.codeborne.selenide.Selenide.open

class TcPageNavigation extends RunTest {
    VirtualResourceGuide vrg = new VirtualResourceGuide(true)

    @BeforeEach
    void setUp() {
        open(vrg.hostURL)
    }

    /**
     * Test to ensure all navigation buttons are present with the correct titles
     * @AC - Welcome, Resource, and Chat button are present
     * @author lhaynes
     */
    @Test
    void navigationButtonsTests() {
        //Pre-login
        def buttonListWithExpectedTitle =
                [
                        "Welcome Page"  : vrg.header.welcomeNavBtn,
                        "FAQ"           : vrg.header.faqNavBtn,
                        "Resources"     : vrg.header.resourceNavBtn,
                        "Resource Guide": vrg.header.resourceGuideNavBtn,
                        "Faculty Login" : vrg.header.facultyLoginNavBtn,
                ]

        for (def btnPair : buttonListWithExpectedTitle) {
            def btn = btnPair.value
            def expectedTitle = btnPair.key

            //Button should be present
            btn.shouldBe(visible)

            //Button should have expected text
            btn.shouldHave(text(expectedTitle))
        }

        //Post login
        def buttonListWithExpectedTitlePostLogin =
                [
                        "Welcome Page"  : vrg.header.welcomeNavBtn,
                        "FAQ"           : vrg.header.faqNavBtn,
                        "Resources"     : vrg.header.resourceNavBtn,
                        "Resource Guide": vrg.header.resourceGuideNavBtn,
                        "File Upload"   : vrg.header.fileUploadNavBtn,
                        "Logout"        : vrg.header.logoutNavBtn,
                ]

        vrg.loginToPage()
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
     * Test to open page
     * @AC - Page must open, expected title is displayed
     * @author lhaynes
     */
    @Test
    void navigateToTabsFunc() {
        //Resource page navigation
        vrg.navigateToTab("resources")

        //Decision tree navigation
        vrg.loginToPage()
        vrg.navigateToTab("decisionTree")

        //Landing page navigation
        vrg.navigateToTab("welcome")

        //FAQ Navigation
        vrg.navigateToTab("faq")
    }
}
