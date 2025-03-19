package common.virtualresourceguide

import com.codeborne.selenide.SelenideElement

import static com.codeborne.selenide.Selenide.$x

/**
 * Page URL: https://truancy2.dranspo.se/
 * Welcome page class for the Homepage
 *
 * @author lhaynes
 */
class VRGWelcomeTab {

    /**Main Page Elements**/
    public SelenideElement welcomeTitleElement = $x("//h2")

    public SelenideElement welcomeBodyElement = $x("//p")
}
