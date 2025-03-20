package common.virtualresourceguide

import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.SelenideElement

import static com.codeborne.selenide.Selenide.$$x
import static com.codeborne.selenide.Selenide.$x

/**
 * Page URL: https://truancy2.dranspo.se/chat
 * Welcome page class for the Homepage
 *
 * @author lhaynes
 */
class DecisionTreeTab {

    /**Title**/
    public SelenideElement decisionTreeTitleElement = $x("//h3")

    /**Buttons**/
    public ElementsCollection allButtons = $$x("//button")

    SelenideElement btnByName(String btnName) {
        return $x("//button[contains(.,$btnName)]")
    }

}
