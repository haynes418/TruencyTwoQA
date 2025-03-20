package test.virtualresourceguide.ResourcePage

import common.virtualresourceguide.VirtualResourceGuide
import test.RunTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import static com.codeborne.selenide.Condition.*
import static com.codeborne.selenide.CollectionCondition.*
import static com.codeborne.selenide.Selenide.open

class TcResourcePageUI extends RunTest {
    VirtualResourceGuide vrg = new VirtualResourceGuide(true)

    @BeforeEach
    void setUp() {
        open(vrg.hostURL)
        vrg.navigateToTab("Resources")
    }

    /**
     * Test that the collapsable table is present and contains the correct amount of entries
     * @AC - Collapsable table is present. Expected number of columns are displayed
     * @author lhaynes
     */
    @Test
    void collapsableTableTests() {
        def resourceTab = vrg.resourceTab

        //Collapsable Container is present
        def collapseContainer = resourceTab.collapseContainer
        collapseContainer.shouldBe(visible)

        //Expected number of rows is met
        def expectedCollapseRows = 16
        def collapseRows = resourceTab.collapseRowElements
        collapseRows.shouldHave(size(expectedCollapseRows))
    }

    @Test
    /**
     * Test that each collapsable tab has a table in it
     * @AC - Collapsable table is present. Expected number of columns are displayed for each table
     * @author lhaynes
     */
    void viewTableTest() {
        def resourceTab = vrg.resourceTab

        //Table should not be open before click
        def displayedTable = resourceTab.displayedTable
        displayedTable.shouldNotBe(visible)

        //Open random row, table should be visible
        def collapseRows = resourceTab.collapseRowElements
        for(def row : collapseRows){
            row.click()
            displayedTable.shouldBe(visible)

            //Table has correct header text and number of columns
            def displayedTableHeaders = resourceTab.displayedTableHeaders
            displayedTableHeaders
                    .shouldBe(size(4))
                    .shouldHave(texts(
                            "Name",
                            "Phone Number",
                            "Address",
                            "Description"
                    ))
        }
    }
}
