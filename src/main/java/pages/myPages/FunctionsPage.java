package pages.myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.base.BasePage;

public class FunctionsPage extends BasePage {
    public FunctionsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "li[class = 'btn btn-light '][id='item-0']")
    WebElement textBox;
    @FindBy (xpath = "//span[text() = 'Practice Form']")
    WebElement acordeonOptionPracticeForm;
    @FindBy (xpath = "//div[@class='practice-form-wrapper']")
    WebElement wrapperPracticeForm;

    public FunctionsPage clickTextBox() {
        waitForVisible(textBox);
        driver.findElement(By.cssSelector("li[class = 'btn btn-light '][id='item-0']")).click();
        return this;
    }
    public WebElement getAcordeonOptionPracticeForm() {
        return acordeonOptionPracticeForm;
    }

    public boolean accordeonOptionVisibility() {
        return acordeonOptionPracticeForm.isDisplayed();
    }

    public boolean wrapperPracticeFormVisibility() {
        return wrapperPracticeForm.isDisplayed();
    }
}
