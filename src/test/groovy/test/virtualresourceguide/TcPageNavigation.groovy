package test.virtualresourceguide

import common.virtualresourceguide.VirtualResourceGuide
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import test.RunTest

import static com.codeborne.selenide.Condition.text
import static com.codeborne.selenide.Condition.visible
import static com.codeborne.selenide.Selenide.open

class TcPageNavigation extends RunTest{
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
    void navigateToTabs() {
        //Resource page navigation
        vrg.navigateToTab("resources")

        //Decision tree navigation
        vrg.navigateToTab("decisionTree")

        //Landing page navigation
        vrg.navigateToTab("welcome")
    }
}
