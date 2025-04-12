package test.virtualresourceguide.ResourcePage

import common.virtualresourceguide.VirtualResourceGuide
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import test.RunTest

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan
import static com.codeborne.selenide.Condition.*
import static com.codeborne.selenide.Selenide.open
import static org.junit.jupiter.api.Assertions.assertEquals

class TcResourcePageFunc extends RunTest {
    VirtualResourceGuide vrg = new VirtualResourceGuide(true)

    @BeforeEach
    void setUp() {
        open(vrg.hostURL)
        vrg.navigateToTab("Resources")
    }

    @Test
    /**
     * Test that each link is reachable. If a link is not found reachable, the page will open and check for a broken
     * URL element
     * @AC - Each link is reachable
     * @author lhaynes
     */
    void linkTest() {
        def resourceTab = vrg.resourceTab

        //Table should not be open before click
        def displayedTable = resourceTab.displayedTable
        displayedTable.shouldNotBe(visible)

        //Open row, table should be visible
        def collapseRows = resourceTab.collapseRowElements
        collapseRows.shouldHave(sizeGreaterThan(0))
        def displayedLinks = resourceTab.displayedURLs
        for (def row : collapseRows) {
            row.scrollTo()
            row.shouldBe(visible)
            row.click()
            displayedTable.shouldBe(visible)

            row.scrollTo()
            row.shouldBe(visible)
            row.click()
            displayedTable.shouldNot(exist)
        }

        //Table has correct header text and number of columns
        def urlList = displayedLinks.collect {it.getAttribute("href")}
        int workingURLCount = 0
        List<String> brokenURLs = []
        for (def url : urlList) {
            if(!verifyLink(url)) {
                brokenURLs.add(url)
            }else {
                workingURLCount++
            }
        }

        //Test broken links for website response
        List<String> confirmedBroken = []
        for(String url : brokenURLs){
            open(url)
            if(!resourceTab.errorURLDisplay.isDisplayed()){
                workingURLCount++
            }else{
                confirmedBroken.add(url)
            }
        }

        //Verify all links are valid
        System.out.println("Total URL Size: " + urlList.size())
        System.out.println("Working URL Count: " + workingURLCount)
        System.out.println("Failed URLs:\n" + confirmedBroken.toString())
        assertEquals(urlList.size(), workingURLCount)
    }

    static boolean verifyLink(String url) {
        try {
            URL link = new URI(url).toURL()
            HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection()
            httpURLConnection.setConnectTimeout(3000) // Set connection timeout to 3 seconds
            httpURLConnection.connect()


            if (httpURLConnection.getResponseCode() == 200) {
                System.out.println(url + " - " + httpURLConnection.getResponseMessage())
                return true
            } else {
                System.out.println(url + " - " + httpURLConnection.getResponseMessage() + " - " + "is a broken link")
                return false
            }
        } catch (Exception e) {
            System.out.println(url + " - " + "is a broken link")
            return false
        }
    }
}
