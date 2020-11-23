package tests.mainAppPages;

import base.AppBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.pages.HomePage;
import selenium.pages.RadioPage;

public class RadioButtonsTest extends AppBaseTest {

    @Test
    public void radioButtonsTest(){

        logger.info("Create HomePage object");
        HomePage homePage = new HomePage(getWebDriver());

        logger.info("Navigate to RadioPage and create RadioPage object");
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        js.executeScript("window.scrollBy(0,1000)");
        homePage.goToRadioPage();
        RadioPage radioPage = new RadioPage(getWebDriver());

        logger.info("Choose Radio Button");
        radioPage.choosePriority(1);

        logger.info("Verify correct chosen priority");
        Assert.assertEquals(getWebDriver().findElement(By.id("priority-value")).getText(), radioPage.getRadioButtonText(1));
    }
}
