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
public class TablePage extends BasePage {

    @FindBy( xpath = "//*[@id=\"main\"]/div/section/div/table/tbody/tr/td[3]")
    private List<WebElement> priceColumn;

    @FindBy( xpath = "//*[@id=\"main\"]/div/section/div/table/tfoot/tr/td[2]" )
    private WebElement totalPrice;

    public TablePage(WebDriver webdriver) {
        super(webdriver);
        PageFactory.initElements(getWebDriver(), this);
    }

    public int getSumOfPriceColumn(){
        int sum = 0;
        for (WebElement price: priceColumn) {
            sum += Integer.parseInt(price.getText());
        }

        return sum;
    }

}
