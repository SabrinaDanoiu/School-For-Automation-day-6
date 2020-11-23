package base;

import lombok.Getter;
import org.testng.annotations.BeforeTest;
import selenium.pages.LoginPage;
import selenium.pages.SignUpPage;

@Getter
public class AppBaseTest extends BaseTest{

    @BeforeTest
    public void logIntoApp() {
        goToLogInPage();
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.login("sabrinadanoiu97@gmail.com", "sabrinaelena");
    }
}
