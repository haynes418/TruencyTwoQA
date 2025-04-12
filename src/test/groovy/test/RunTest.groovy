package test

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import org.junit.jupiter.api.BeforeAll
import org.openqa.selenium.chrome.ChromeOptions

import static com.codeborne.selenide.Selenide.dismiss
import static com.codeborne.selenide.Selenide.open
import static com.codeborne.selenide.Selenide.switchTo
import static com.codeborne.selenide.Selenide.switchTo

abstract class RunTest {


    @BeforeAll
    static void setUpAll() {
        Configuration.browserSize = "1920x1080"
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*")
    }

    void open(String url) {
        Selenide.open(url)
    }

    /**Handle alert notifications**/
    String clearLoginAlert() {
        return dismiss()
    }

    String getAlertText() {
        return switchTo().alert().text
    }

    static def r() {
        return new RunClass()
    }
}
