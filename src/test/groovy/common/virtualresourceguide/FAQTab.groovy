package common.virtualresourceguide

import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.SelenideElement

import static com.codeborne.selenide.Selenide.$$x
import static com.codeborne.selenide.Selenide.$x

class FAQTab {

    /**Title**/
    SelenideElement faqTitle = $x("//h2[@class='faq-title']")

    /**Body**/
    ElementsCollection faqBodyItems = $$x("//div[@class='faq-container']//div[@class='faq-item']")

}
