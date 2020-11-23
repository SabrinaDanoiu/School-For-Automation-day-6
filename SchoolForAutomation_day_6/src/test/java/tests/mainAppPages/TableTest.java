package tests.mainAppPages;

import base.AppBaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.pages.HomePage;
import selenium.pages.TablePage;

public class TableTest extends AppBaseTest {

    @Test
    public void tableTest() {

        logger.info("Create HomePage object");
        HomePage homePage = new HomePage(getWebDriver());

        logger.info("Navigate to TablePage and create TablePage object");
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        js.executeScript("window.scrollBy(0,1000)");
        homePage.goToTablePage();
        TablePage tablePage = new TablePage(getWebDriver());

        logger.info("Verify the total amount of the column 'Price' is correct");
        Assert.assertEquals(tablePage.getSumOfPriceColumn(), Integer.parseInt(tablePage.getTotalPrice().getText()));
    }
}
