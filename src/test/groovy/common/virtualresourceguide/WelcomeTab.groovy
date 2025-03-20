package common.virtualresourceguide

import com.codeborne.selenide.SelenideElement

import static com.codeborne.selenide.Selenide.$x

/**
 * Page URL: https://truancy2.dranspo.se/
 * Welcome page class for the Homepage
 *
 * @author lhaynes
 */
class WelcomeTab {

    /**Title**/
    SelenideElement welcomeTitle = $x("//h2[contains(.,'Welcome')]")
    SelenideElement schoolLogoImage = $x("//img[contains(@class, 'welcome-image')]")

    /**Attendance Section**/
    SelenideElement attendanceTitle = $x("//h3[@class='attendance-title']")
    SelenideElement attendanceBody = $x("//p[@class='attendance-text']")

    /**Tutorial**/
    SelenideElement tutorialTitle = $x("//h4")

}
