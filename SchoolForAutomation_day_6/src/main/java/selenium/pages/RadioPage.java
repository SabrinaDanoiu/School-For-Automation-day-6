package selenium.pages;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
@Setter
public class RadioPage extends BasePage {

    @FindBy( name = "priority" )
    private List<WebElement> radioButtons;

    @FindBy( className = "radio-container" )
    private List<WebElement> radioButtonsText;

    @FindBy( xpath = "//*[@id=\"main\"]/div/section/input" )
    private WebElement submitChoice;

    public RadioPage(WebDriver webdriver) {
        super(webdriver);
        PageFactory.initElements(getWebDriver(), this);
    }

    public void choosePriority(int index){
        getRadioButtons().get(index).click();
        getSubmitChoice().click();
    }

    public String getRadioButtonText(int index) {
        return getRadioButtonsText().get(index).getText();
    }

}
