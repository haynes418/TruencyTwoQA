package common.virtualresourceguide

import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.SelenideElement

import static com.codeborne.selenide.Selenide.*

class FAQTab {

    /**Title**/
    SelenideElement faqTitle = $x("//h2[@class='faq-title']")

    /**Body**/
    ElementsCollection faqCardItems = $$x("//div[@class='faq-container']//div[@class='faq-item']")
    ElementsCollection faqCardTitles = $$x("//h3[@class='faq-question']")
    ElementsCollection faqCardBodies = $$x("//p[@class='faq-answer']")
}
