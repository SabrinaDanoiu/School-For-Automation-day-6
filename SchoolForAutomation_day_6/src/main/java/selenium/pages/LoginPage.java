package selenium.pages;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
@Setter
public class LoginPage extends BasePage {

    @FindBy( id = "email" )
    private WebElement emailInput;

    @FindBy( id = "password" )
    private WebElement passwordInput;

    @FindBy( xpath = "//*[@id=\"login-form\"]/input[3]" )
    private WebElement loginButton;

    @FindBy( xpath = "//*[@id=\"banner\"]/div[2]/a" )
    private WebElement createAccountButton;


    public LoginPage(WebDriver webdriver) {
        super(webdriver);

        PageFactory.initElements(getWebDriver(), this);
    }

    public HomePage login(String email, String password) {
        getEmailInput().sendKeys(email);
        getPasswordInput().sendKeys(password);
        getLoginButton().click();

        return new HomePage(getWebDriver());
    }

    public SignUpPage goToSignUpPage() {
        getCreateAccountButton().click();

        return new SignUpPage(getWebDriver());
    }

}
