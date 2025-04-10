package test.virtualresourceguide.WelcomePage

import common.virtualresourceguide.VirtualResourceGuide
import test.RunTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import static com.codeborne.selenide.Selenide.*
import static com.codeborne.selenide.Condition.*
import static com.codeborne.selenide.CollectionCondition.*


class TcWelcomePageUI extends RunTest {
    VirtualResourceGuide vrg = new VirtualResourceGuide()

    @BeforeEach
    void setUp() {
        open(vrg.hostURL)
    }

    /**
     * Test to open page
     * @AC - Page must open, expected titles are displayed
     * @author lhaynes
     */
    @Test
    void welcomePageTitleTests() {
        def welcomeTab = vrg.welcomeTab

        //Check the title of each section
        def expectedPageTitle = "Welcome to the Virtual Resource Guide for Urbana!"
        welcomeTab.welcomeTitle.shouldBe(visible).shouldHave(text(expectedPageTitle))

        def expectedAttendanceTitle = "Attendance Matters"
        welcomeTab.attendanceTitle.shouldBe(visible).shouldHave(text(expectedAttendanceTitle))

        def expectedTutorialTitle = "How to Use This Website"
        welcomeTab.tutorialTitle.shouldBe(visible).shouldHave(text(expectedTutorialTitle))
    }

    /**
     * Test to open page
     * @AC - Page must open, expected bodies are displayed with correct texts
     * @author lhaynes
     */
    @Test
    void welcomePageBodyTests() {
        def welcomeTab = vrg.welcomeTab

        //Check the title of each section
        def expectedPageBody = "This website serves as a Virtual Resource Guide for children facing truancy, offering tailored support for challenges. Users navigate through a decision tree to find relevant resources quickly based on their specific needs."
        welcomeTab.welcomeBody.shouldBe(visible).shouldHave(text(expectedPageBody))

        def expectedAttendanceBody = "Regular school attendance is crucial for academic success. Students who attend school consistently are more likely to achieve higher grades, develop strong social skills, and create a foundation for future career opportunities. Use our website to ensure students have access to the resources they need to stay in school and succeed."
        welcomeTab.attendanceBody.shouldBe(visible).shouldHave(text(expectedAttendanceBody))

        def expectedTutorialBody =
                [
                        "1. Go to the \"Chat\" Button on the navigation bar.",
                        "2. Follow the prompts to answer questions about the challenges or needs your child may be facing.",
                        "3. Based on your responses, the website will provide links to relevant resources.",
                        "4. If you would like more information, visit the \"Resources\" or \"FAQ\" pages from the navigation bar.",
                        "5. If you still have questions, you can always visit the \"FAQ\" page for commonly asked questions or contact Urbana City Schools."
                ]
        welcomeTab.tutorialBody.shouldHave(exactTextsCaseSensitive(expectedTutorialBody))
    }

    /**
     * Test to open page
     * @AC - Page must open, expected bodies are displayed with correct texts
     * @author lhaynes
     */
    @Test
    void welcomeImageTests() {
        def welcomeTab = vrg.welcomeTab

        //Check the image is present
        welcomeTab.schoolLogoImage.isDisplayed()
    }


}
