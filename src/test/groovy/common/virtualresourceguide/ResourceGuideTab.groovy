package common.virtualresourceguide

import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.SelenideElement

import static com.codeborne.selenide.Selenide.$$x
import static com.codeborne.selenide.Selenide.$x

/**
 * Welcome page class for the Homepage
 *
 * @author lhaynes
 */
class ResourceGuideTab {

    /**Title**/
    public SelenideElement resourceGuideTitleElement = $x("//h3")

    /**Buttons**/
    public SelenideElement backBtn = $x("//button[@class='Recall-button']")
    public ElementsCollection allButtons = $$x("//div[@class='button-container']//button[not(@class='Recall-button')]")
    public ElementsCollection allButtonPictures = $$x("//div[@class='button-container']//button//img")

    SelenideElement btnByName(String btnName) {
        return allButtons.find {it.text.equalsIgnoreCase(btnName)} as SelenideElement
    }

    SelenideElement getRandomOption() {
        def buttons = $$x("//div[@class='button-container']//button[not(@class='Recall-button')]")
        if(buttons.asList().size() == 0){
            println("ERROR: No options available")
            return null
        }

        return buttons.asList().shuffled().first() as SelenideElement
    }
}
