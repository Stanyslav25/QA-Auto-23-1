package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends BasePage {
    protected WebDriverWait wait;
    private By element = By.cssSelector("div[class='card mt-4 top-card']");

    @FindBy(how=How.CSS, using = "div[class='card mt-4 top-card']")
    WebElement elementsTab;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void clickOnElements(){
//        waitForElementToAppear(element);
//        wait.until(ExpectedConditions.visibilityOf(elementsTab));
        driver.findElement(element).click();
    }

    public void waitForElementsTab() {
        waitForElementToAppear(element);
    }


}
