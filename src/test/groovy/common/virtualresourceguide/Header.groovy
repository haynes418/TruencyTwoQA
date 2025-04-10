package common.virtualresourceguide

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.selector.ByTextCaseInsensitive
import com.codeborne.selenide.selector.WithTextCaseInsensitive
import org.openqa.selenium.By

import static com.codeborne.selenide.Selenide.*

class Header {

    /**Nav Buttons**/
    public SelenideElement faqNavBtn = $x("//a[@href='/faq']")

    public SelenideElement welcomeNavBtn = $x("//a[@href='/']")

    public SelenideElement resourceNavBtn = $x("//a[@href='/resources']")

    public SelenideElement decisionTreeNavBtn = $x("//a[@href='/chat']")

    public SelenideElement fileUploadNavBtn = $x("//a[@href='/fileupload']")

    public SelenideElement loginNavBtn = $x("//nav//button[contains(.,'Login')]")

    public SelenideElement logoutNavBtn = $x("//nav//button[contains(.,'Logout')]")


    /**Login Modal**/
    String modalXpath = "//div[@class='ant-modal-content' and contains(.,'Login')]"
    public def loginModal =
            [
                    modal : $x(modalXpath),
                    title : $x(modalXpath + "//div[@class='ant-modal-header']"),
                    xBtn  : $x(modalXpath + "//button[@aria-label='Close']"),
                    userNameInput : $x(modalXpath + "//div[@class='ant-modal-body']//div[contains(.,'Username')]//input"),
                    passwordInpt  : $x(modalXpath + "//div[@class='ant-modal-body']//div[contains(.,'Password')]//input"),
                    submitBtn  : $x(modalXpath + "//button[contains(@class, 'ant-btn')]")
            ]
}
