package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private static final Duration TIMEOUT = Duration.ofMillis(5000);
    private static final Duration POLLING = Duration.ofMillis(1000);
    protected static WebDriver driver;
    protected WebDriverWait wait;
    protected WebDriverWait waiter(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        return wait;
    }
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    protected void waitForElementToAppear(By locator){
        waiter().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitForElementVisibility(WebElement myItem){
        waiter().until(ExpectedConditions.visibilityOf(myItem));
    }


}
