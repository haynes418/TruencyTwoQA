package common.virtualresourceguide

import com.codeborne.selenide.SelenideElement

import static com.codeborne.selenide.Selenide.$x

class VRGHeader {

    /**Header Info**/
    public SelenideElement pageTitle = $x("//h1")

    /**Nav Buttons**/
    public SelenideElement welcomeNavBtn = $x("//a[@href='/']")

    public SelenideElement resourceNavBtn = $x("//a[@href='/resources']")

    public SelenideElement decisionTreeNavBtn = $x("//a[@href='/chat']")
}
