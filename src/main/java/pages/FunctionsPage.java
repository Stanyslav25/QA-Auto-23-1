package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FunctionsPage extends BasePage{
    WebDriver driver;

    By textBox = By.cssSelector("li[class = 'btn btn-light '][id='item-0']");
    public FunctionsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public FunctionsPage clickTextBox() {

        driver.findElement(textBox).click();
        return this;
    }

    public void clickNameField(){
    }

}
