package selenium.pages;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
@Setter
public class HomePage extends BasePage {

    @FindBy( xpath = "//*[@id=\"one\"]/div/div/section[3]/a/i" )
    private WebElement selectPageButton;

    @FindBy( xpath = "//*[@id=\"one\"]/div/div/section[2]/a/i" )
    private WebElement radioPageButton;

    @FindBy( xpath = "//*[@id=\"one\"]/div/div/section[1]/a/i" )
    private WebElement tablePageButton;

    @FindBy ( xpath = "//*[@id=\"banner\"]/h2/span" )
    private WebElement homepageTitle;

    public HomePage(WebDriver webdriver) {
        super(webdriver);

        PageFactory.initElements(getWebDriver(), this);
    }


    public void goToSelectPage() {
        getSelectPageButton().click();
    }

    public void goToRadioPage() {
        getRadioPageButton().click();
    }

    public void goToTablePage() {
        getTablePageButton().click();
    }

}
