package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    protected WebDriverWait wait;
    private By element = By.cssSelector("div[class='card mt-4 top-card']");
    @FindBy(how=How.CSS, using = "div[class='card mt-4 top-card']")
    WebElement elementsTab;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnElements(){
        waitForElementToAppear(element);
        driver.findElement(element).click();
    }

    @Override
    protected void waitForElementToAppear(By locator) {
        super.waitForElementToAppear(locator);
    }

    public void waitForElementsTab() {
        waitForElementToAppear(element);
    }


}
