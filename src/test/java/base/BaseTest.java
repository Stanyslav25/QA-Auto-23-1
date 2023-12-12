package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.FunctionsPage;
import pages.HomePage;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    public WebDriver driver;
    public HomePage homePage;
    public FunctionsPage funkPage;

    @BeforeAll
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        funkPage = new FunctionsPage(driver);
    }

    @BeforeEach
    public void start(){
        driver.get("https://demoqa.com/");
    }

    @AfterEach
    public void shutDown(){
        driver.quit();
    }
}
