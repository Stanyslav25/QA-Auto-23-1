package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FunctionsPage {
    WebDriver driver;

    By textBox = By.cssSelector("li[class = 'btn btn-light '][id='item-0']");
    public FunctionsPage(WebDriver driver) {
        this.driver = driver;
    }

    public FunctionsPage clickTextBox() {

        driver.findElement(textBox).click();
        return this;
    }

    public void clickNameField(){

    }

}
