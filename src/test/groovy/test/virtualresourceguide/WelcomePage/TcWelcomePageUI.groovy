package test.virtualresourceguide.WelcomePage

import common.virtualresourceguide.VirtualResourceGuide
import test.RunTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import static com.codeborne.selenide.Condition.*

import static com.codeborne.selenide.Selenide.open

class TcWelcomePageUI extends RunTest {
    VirtualResourceGuide vrg = new VirtualResourceGuide()

    @BeforeEach
    void setUp() {
        open(vrg.hostURL)
    }

    /**
     * Test to open page
     * @AC - Page must open, expected title is displayed
     * @author lhaynes
     */
    @Test
    void welcomePageTitleTests() {
        def expectedPageTitle = "Virtual Resource Guide"

        //Wait for the page to load and check the expected page title
        vrg.header.pageTitle.shouldBe(visible).shouldHave(text(expectedPageTitle))
    }

    /**
     * Test to ensure all navigation buttons are present with the correct titles
     * @AC - Welcome, Resource, and Chat button are present
     * @author lhaynes
     */
    @Test
    void navigationButtonsTests() {
        def buttonListWithExpectedTitle =
                [
                        "Welcome"  : vrg.header.welcomeNavBtn,
                        "Resources": vrg.header.resourceNavBtn,
                        "Chat"     : vrg.header.decisionTreeNavBtn
                ]

        for (def btnPair : buttonListWithExpectedTitle) {
            def btn = btnPair.value
            def expectedTitle = btnPair.key

            //Button should be present
            btn.shouldBe(visible)

            //Button should have expected text
            btn.shouldBe(text(expectedTitle))
        }

    }



}
