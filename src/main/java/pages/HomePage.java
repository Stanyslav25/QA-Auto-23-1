package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By element = By.cssSelector("div[class='card mt-4 top-card']");
//    List<WebElement> elements = (List<WebElement>) By.cssSelector("div[class='card mt-4 top-card']");

    public FunctionsPage clickOnElements(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
        driver.findElement(element).click();
        return new FunctionsPage(driver);
    }



}
