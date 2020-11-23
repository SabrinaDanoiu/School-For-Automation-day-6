package tests.mainAppPages;

import base.AppBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.pages.HomePage;
import selenium.pages.SelectPage;

public class SelectTest extends AppBaseTest {

    @Test
    public void selectTest() {

        logger.info("Create HomePage object");
        HomePage homePage = new HomePage(getWebDriver());

        logger.info("Navigate to SelectPage and create SelectPage object");
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        js.executeScript("window.scrollBy(0,1000)");
        homePage.goToSelectPage();
        SelectPage selectPage = new SelectPage(getWebDriver());

        logger.info("Select option");
        selectPage.chooseOption(2);

        logger.info("Check selected option is correct");
        Assert.assertEquals(getWebDriver().findElement(By.id("selected-value")).getText(), selectPage.getOptionText(2));

    }
}
