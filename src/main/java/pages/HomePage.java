package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By element = By.cssSelector("div[class='card mt-4 top-card']");
//    List<WebElement> elements = (List<WebElement>) By.cssSelector("div[class='card mt-4 top-card']");

    public FunctionsPage clickOnElements(){
        driver.findElement(element).click();
        return new FunctionsPage(driver);
    }



}
