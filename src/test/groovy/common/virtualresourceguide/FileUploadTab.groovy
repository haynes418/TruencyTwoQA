package common.virtualresourceguide

import com.codeborne.selenide.SelenideElement

import static com.codeborne.selenide.Selenide.*

class FileUploadTab {

    /**Upload File**/
    SelenideElement uploadBtn = $x("//span[contains(.,'Upload Excel File')]/..")

    SelenideElement uploadInput = $x("//input[@type='file']")
}
