package test.WelcomePage

import common.virtualresourceguide.VRGDecisionTreeTab
import common.virtualresourceguide.VRGResourceTab
import common.virtualresourceguide.VRGWelcomeTab
import common.virtualresourceguide.VirtualResourceGuide
import test.RunTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import static com.codeborne.selenide.Condition.*

import static com.codeborne.selenide.Selenide.open

class TcWelcomePageUI extends RunTest{
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

        for(def btnPair : buttonListWithExpectedTitle){
            def btn = btnPair.value
            def expectedTitle = btnPair.key

            //Button should be present
            btn.shouldBe(visible)

            //Button should have expected text
            btn.shouldBe(text(expectedTitle))
        }

    }

    /**
     * Test concerning the displayed text on the welcome page
     * @AC - Welcome title and description are present with expected text
     * @author lhaynes
     */
    @Test
    void bodyTextTests() {
        def elementListWithExpectedTitle =
                [
                        "Welcome to the Virtual Resource Guide"  : vrg.welcomeTab.welcomeTitleElement,
                        "Explore helpful resources to improve your skills and knowledge.": vrg.welcomeTab.welcomeBodyElement,
                ]

        for(def elementPair : elementListWithExpectedTitle){
            def e = elementPair.value
            def expectedText = elementPair.key

            //Element should be present
            e.shouldBe(visible)

            //Element should have expected text
            e.shouldBe(text(expectedText))
        }
    }


    @Test
    void navigateToTabs() {
        //Resource page navigation
        vrg.navigateToTab("resources")

        //Decision tree navigation
        vrg.navigateToTab("decisionTree")

        //Landing page navigation
        vrg.navigateToTab("welcome")
    }

}
