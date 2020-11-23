package selenium.pages;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

@Getter
@Setter
public class SelectPage extends BasePage {

    @FindBy( id = "category" )
    private WebElement selectOptions;

    @FindBy( xpath = "//*[@id=\"main\"]/div/section/input" )
    private WebElement submitChoice;

    public SelectPage(WebDriver webdriver) {
        super(webdriver);
        PageFactory.initElements(getWebDriver(), this);
    }

    public void chooseOption(int index) {
        new Select(getSelectOptions()).selectByIndex(index);
        getSubmitChoice().click();
    }

    public String getOptionText(int index) {
        return new Select(getSelectOptions()).getFirstSelectedOption().getText();
    }

}
