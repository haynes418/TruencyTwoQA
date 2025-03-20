package common.virtualresourceguide

import com.codeborne.selenide.SelenideElement

import static com.codeborne.selenide.Selenide.$x

class Header {

    /**Header Info**/
    public SelenideElement pageTitle = $x("//h1")

    public SelenideElement pageDescription = $x("//header/p")

    /**Nav Buttons**/
    public SelenideElement faqNavBtn = $x("//a[@href='/faq']")

    public SelenideElement welcomeNavBtn = $x("//a[@href='/']")

    public SelenideElement resourceNavBtn = $x("//a[@href='/resources']")

    public SelenideElement decisionTreeNavBtn = $x("//a[@href='/chat']")
}
