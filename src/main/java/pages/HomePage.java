package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class HomePage{
    private WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private By element = By.cssSelector("div[class='card mt-4 top-card']");
    @FindBy(css = "div[class='card mt-4 top-card']")
    WebElement elementsTab;

    public void clickOnElements() {
        driver.findElement(element).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void clickOnElementsFindBy() {
        elementsTab.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}
