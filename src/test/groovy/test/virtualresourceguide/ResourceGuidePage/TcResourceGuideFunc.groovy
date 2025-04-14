package test.virtualresourceguide.ResourceGuidePage

import common.virtualresourceguide.VirtualResourceGuide
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import test.RunTest

class TcResourceGuideFunc extends RunTest {
    VirtualResourceGuide vrg = new VirtualResourceGuide(true)
    def resourceGuideTab = vrg.resourceGuideTab

    @BeforeEach
    void setUp() {
        open(vrg.hostURL)
        vrg.navigateToTab("resource guide")
    }

    /**
     * @AC - Navigate random pages until a table of resources are displayed. At least one row is displayed
     * @author lhaynes
     */
    @Test
    void expectedBodies() {
        //Click through two beginning questions, random questions after
        resourceGuideTab.btnByName("Yes").click()
        resourceGuideTab.btnByName("Yes").click()

        resourceGuideTab.allButtons.shouldBe(sizeGreaterThan(0))
        while (resourceGuideTab.allButtons.size() > 0) {

            def button = null
            for (int idx = 0; idx < 5; idx++) {
                if (resourceGuideTab.allButtons.size() > 0) {
                    sleep(1000)
                    button = resourceGuideTab.getRandomOption()
                    break
                }

            }
            button == null ?: button.click()
        }

        sleep(1000) //wait for page
        assertEquals(true, url.contains("/resources"))
        vrg.resourceTab.collapseRowElements.shouldBe(sizeGreaterThan(0))
    }

}
