package base;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import utils.Listener;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    public WebDriver driver = new EventFiringDecorator<>(new Listener()).decorate(new ChromeDriver());
    @BeforeAll
    public void setup(){
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }
    @BeforeEach
    public void start() {
        driver.get("https://demoqa.com/");
    }

    @AfterEach
    public void clear() {
        driver.manage().deleteAllCookies();
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }

}
