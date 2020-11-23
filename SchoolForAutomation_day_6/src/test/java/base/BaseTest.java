package base;

import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

@Getter
public class BaseTest {

    private WebDriver webDriver;

    protected static Logger logger = LogManager.getLogger(LoginBaseTest.class);

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Webdriver\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    public void goToLogInPage() {
        webDriver.get("http://school-for-automation.tech/");
    }

    @AfterTest
    public void tearDown() {
        webDriver.close();
    }
}
