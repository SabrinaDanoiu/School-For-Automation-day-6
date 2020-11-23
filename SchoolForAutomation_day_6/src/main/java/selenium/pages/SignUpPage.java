package selenium.pages;

import lombok.Getter;
import lombok.Setter;
import model.SignUpData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
@Setter
public class SignUpPage extends BasePage {

    @FindBy( id = "firstname" )
    private WebElement firstNameInput;

    @FindBy( id = "lastname" )
    private WebElement lastNameInput;

    @FindBy( id = "password" )
    private WebElement passwordInput;

    @FindBy( id = "email" )
    private WebElement emailInput;

    @FindBy( id = "phone" )
    private WebElement phoneInput;

    @FindBy( id = "address" )
    private WebElement addressInput;

    @FindBy( xpath = "//*[@id=\"signup-form\"]/input[7]" )
    private WebElement submitButton;


    public SignUpPage(WebDriver webdriver) {
        super(webdriver);
        PageFactory.initElements(getWebDriver(), this);
    }

    public void fillSignUpForm(SignUpData signUpData) {
        insertFirstName(signUpData.getFirstName());
        insertLastName(signUpData.getLastName());
        insertPassword(signUpData.getPassword());
        insertEmail(signUpData.getEmail());
        insertPhone(signUpData.getPhone());
        insertAddress(signUpData.getAddress());

        clickSignUpButton();
    }

    public void insertFirstName(String firstName) {
        getFirstNameInput().sendKeys(firstName);
    }

    public void insertLastName(String lastName) {
        getLastNameInput().sendKeys(lastName);
    }

    public void insertPassword(String password) {
        getPasswordInput().sendKeys(password);
    }

    public void insertEmail(String email) {
        getEmailInput().sendKeys(email);
    }

    public void insertPhone(String phone) {
        getPhoneInput().sendKeys(phone);
    }

    public void insertAddress(String address) {
        getAddressInput().sendKeys(address);
    }

    public void clickSignUpButton(){
        getSubmitButton().click();
    }
}
