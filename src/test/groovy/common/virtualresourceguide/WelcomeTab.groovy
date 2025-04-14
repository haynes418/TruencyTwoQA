package common.virtualresourceguide

import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.impl.CollectionElement

import static com.codeborne.selenide.Selenide.$x
import static com.codeborne.selenide.Selenide.$$x

/**
 * Welcome page class for the Homepage
 *
 * @author lhaynes
 */
class WelcomeTab {

    /**Title**/
    SelenideElement welcomeTitle = $x("//h2[contains(.,'Welcome')]")
    SelenideElement welcomeBody = $x("//div[@class='welcome-container']//p")
    SelenideElement schoolLogoImage = $x("//img[contains(@class, 'welcome-image')]")

    /**Attendance Matters**/
    SelenideElement attendanceTitle = $x("//h3[@class='attendance-title' and contains(.,'Matters')]")
    SelenideElement attendanceBody = $x("//p[@class='attendance-text']")

    /**Why Attendance Is Important**/
    SelenideElement whyAttendanceTitle = $x("//h3[@class='attendance-title' and contains(.,'Important')]")
    ElementsCollection whyAttendanceFacts = $$x("//ul[@class='attendance-facts']//li")
    SelenideElement whyAttendanceImage = $x("//img[@class='attendance-image']")
    
    /**Tutorial**/
    SelenideElement tutorialTitle = $x("//h4")
    ElementsCollection tutorialBody = $$x("//ul[@class='tutorial-list']//li")
}
