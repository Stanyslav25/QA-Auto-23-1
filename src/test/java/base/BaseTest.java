package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BasePage;
import pages.HomePage;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    public static final String URL = "https://demoqa.com/";
    public WebDriver driver;

    BasePage basePage;

    @BeforeAll
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        basePage = new HomePage(driver);
    }

    @BeforeEach
    public void start(){
        driver.get("https://demoqa.com/");
//        driver.navigate().to(URL + "elements");
    }

    @AfterEach
    public void shutDown(){
        driver.quit();
    }
}
