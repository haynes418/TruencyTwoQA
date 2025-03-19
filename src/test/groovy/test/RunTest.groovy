package test

import com.codeborne.selenide.Configuration
import org.junit.jupiter.api.BeforeAll
import org.openqa.selenium.chrome.ChromeOptions

abstract class RunTest {

    @BeforeAll
    static void setUpAll() {
        Configuration.browserSize = "1920x1080"
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*")
    }
}
