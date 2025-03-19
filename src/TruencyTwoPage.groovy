import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import java.util.List

// page_url = https://truancy2.dranspo.se
class TruencyTwoPage {
    TruencyTwoPage(WebDriver driver) {
        PageFactory.initElements(driver, this)
    }
}