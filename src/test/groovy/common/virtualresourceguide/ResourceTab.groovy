package common.virtualresourceguide

import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.SelenideElement

import static com.codeborne.selenide.Selenide.$$x
import static com.codeborne.selenide.Selenide.$x

/**
 * Page URL: https://truancy2.dranspo.se/resources
 * Welcome page class for the Homepage
 *
 * @author lhaynes
 */
class ResourceTab {

    /**Title**/
    public SelenideElement resourceTitle = $x("//h1[contains(.,'Resources')]")

    /**Collapse Elements**/
    public SelenideElement collapseContainer = $x("//div[@role='tablist']")

    public ElementsCollection collapseRowElements = $$x("//div[@role='tablist']/div")

    /**Table Elements**/
    public SelenideElement displayedTable = $x("//div[contains(@class, 'ant-collapse-item-active')]//table")

    public ElementsCollection displayedTableHeaders = $$x("//div[contains(@class, 'ant-collapse-item-active')]//th")

}
