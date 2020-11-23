package selenium.pages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;

@Getter
@Setter
@AllArgsConstructor
public class BasePage {

    private WebDriver webDriver;
}
