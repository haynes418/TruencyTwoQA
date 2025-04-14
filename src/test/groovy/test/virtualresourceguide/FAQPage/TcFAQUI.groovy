package test.virtualresourceguide.FAQPage

import common.virtualresourceguide.VirtualResourceGuide
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import test.RunTest


class TcFAQUI extends RunTest {
    VirtualResourceGuide vrg = new VirtualResourceGuide(true)
    def faqTab = vrg.faqTab

    @BeforeEach
    void setUp() {
        open(vrg.hostURL)
        vrg.navigateToTab("faq")
    }

    /**
     * @AC - There are 7 faq items present on the page with 7 titles and bodies
     * @author lhaynes
     */
    @Test
    void presentFAQItems() {
        faqTab.faqCardItems.shouldHave(size(7))
        faqTab.faqCardTitles.shouldHave(size(7))
        faqTab.faqCardBodies.shouldHave(size(7))
    }

    /**
     * @AC - There are 7 faq items present on the page with 7 titles and bodies all displayed
     * @author lhaynes
     */
    @Test
    void displayedFAQItems() {
        def collections =
                [
                        faqTab.faqCardItems,
                        faqTab.faqCardTitles,
                        faqTab.faqCardBodies
                ]
        //For each collection
        for(def c : collections) {

            //Verify each item in collection is displayed
            for(def e : c) {
                e.shouldBe(visible)
            }
        }
    }

    /**
     * @AC - All Titles on the page match expected texts
     * @author lhaynes
     */
    @Test
    void expectedTitles() {
        def expectedTitles =
                [
                       "1. What is the purpose of this Virtual Resource Guide?",
                        "2. How do I get started using the guide?",
                        "3. Is the information I provide kept confidential?",
                        "4. Can I access resources without going through the chat?",
                        "5. How accurate and up-to-date are the resources?",
                        "6. Who can I contact if I need more assistance?",
                        "7. What is mediation?"
                ]
        //Verify texts
        faqTab.faqCardTitles.shouldHave(exactTextsCaseSensitive(expectedTitles))
    }

    /**
     * @AC - All bodies match the expected texts
     * @author lhaynes
     */
    @Test
    void expectedBodies() {
        def expectedTitles =
                [
                        "This website is designed to support children facing truancy and their families by providing access to resources that address challenges such as childcare, transportation, attendance motivation, food insecurity, housing, and mental health. It also helps guide users to services that can assist with specific needs.",
                        "To start using the guide, click on the \"Chat\" button on the navigation bar. You will be guided through a series of questions to help identify your needs, and the website will suggest relevant resources.",
                        "Yes, all responses and information provided through the chat are completely anonymous. Your privacy is important to us.",
                        "Yes, you can directly visit the \"Resources\" page from the navigation bar to see a list of available support services without interacting with the chat.",
                        "We regularly review and update our resources to ensure they are accurate and relevant. However, we recommend checking the official websites of the services listed for the most current information.",
                        "If you need further assistance or cannot find the support you're looking for, we recommend contacting your child's school.",
                        "Truancy mediation is a process where a neutral mediator facilitates a discussion between a student, their parents, and school staff to address attendance issues and collaboratively develop solutions to improve school attendance."
                ]
        //Verify texts
        faqTab.faqCardBodies.shouldHave(exactTextsCaseSensitive(expectedTitles))
    }
}
