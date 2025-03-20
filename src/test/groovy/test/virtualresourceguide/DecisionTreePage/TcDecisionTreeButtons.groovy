package test.virtualresourceguide.DecisionTreePage

import common.virtualresourceguide.VirtualResourceGuide
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import test.RunTest

import static com.codeborne.selenide.Condition.text
import static com.codeborne.selenide.Condition.visible
import static com.codeborne.selenide.Selenide.open

class TcDecisionTreeButtons extends RunTest{
    VirtualResourceGuide vrg = new VirtualResourceGuide(true)

    @BeforeEach
    void setUp() {
        open(vrg.hostURL)
        open(vrg.hostURL)
        vrg.navigateToTab("Resources")
    }

}
