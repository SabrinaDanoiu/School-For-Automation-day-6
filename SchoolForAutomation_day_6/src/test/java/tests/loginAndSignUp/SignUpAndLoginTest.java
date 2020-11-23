package tests.loginAndSignUp;


import base.LoginBaseTest;
import model.SignUpData;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.pages.HomePage;
import selenium.pages.LoginPage;
import selenium.pages.SignUpPage;


public class SignUpAndLoginTest extends LoginBaseTest {

    @Test
    public void signUpAndLoginTest() throws InterruptedException {
        logger.info("Go to LogIn Page");
        goToLogInPage();

        logger.info("Create LoginPage object");
        LoginPage loginPage = new LoginPage(getWebDriver());

        logger.info("Navigate to Sign Up page and create a SignUp object");
        SignUpPage signUpPage = loginPage.goToSignUpPage();

        logger.info("Verify the redirect to the SignUp Page");
        Assert.assertTrue(getWebDriver().getCurrentUrl().startsWith("http://school-for-automation.tech/signup.html"));

        logger.info("Create the data for the Sign Up and fill the Sign Up form");
        SignUpData signUpData = new SignUpData( RandomStringUtils.randomAlphanumeric(10),
                RandomStringUtils.randomAlphanumeric(10), RandomStringUtils.randomAlphanumeric(10),
                RandomStringUtils.randomAlphanumeric(8) + "@gmail.com", RandomStringUtils.randomNumeric(10),
                RandomStringUtils.randomAlphanumeric(10) );
        signUpPage.fillSignUpForm(signUpData);

        logger.info("Wait until the Login Page loads");
        WebElement loginSubmitButton = new WebDriverWait(getWebDriver(), 2)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-form\"]/input[3]")));

        logger.info("Login using the newly generated account");
        HomePage homePage = loginPage.login(signUpData.getEmail(), signUpData.getPassword());

        logger.info("Verify the login was successful by checking the Home Page title");
        Assert.assertEquals(homePage.getHomepageTitle().getText(),"School for Automation");
    }
}
