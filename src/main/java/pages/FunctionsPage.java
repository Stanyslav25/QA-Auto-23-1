package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FunctionsPage {
    WebDriver driver = null;
    By textBox = By.cssSelector("li[class = 'btn btn-light '][id='item-0']");
    public FunctionsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public FunctionsPage clickTextBox() {
        driver.findElement(textBox);
        return this;
    }
    public void clickNameField(){
    }
}
