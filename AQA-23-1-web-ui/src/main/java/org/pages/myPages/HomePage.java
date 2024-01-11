package org.pages.myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.time.Duration;
import java.util.List;
import org.pages.base.BasePage;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By element = By.cssSelector("div[class='card mt-4 top-card']");
    @FindBy(css = "div[class='card mt-4 top-card']")
    WebElement elementsTab;
    @FindBy(xpath = "//*[text()='Forms']/ancestor::div[@class='card mt-4 top-card']")
    WebElement tileForms;
    @FindBy(xpath = "//div[@class='card mt-4 top-card'][2]")
    WebElement tileFormsByIndex;
    @FindBy(css = "div[class='card mt-4 top-card']")
    List<WebElement> elements;
    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']/ancestor::div[@class='card mt-4 top-card']")
    WebElement tileAlertsAndFrame;
    @FindBy(xpath = "//*[text()='Book Store Application']/ancestor::div[@class='card mt-4 top-card']")
    WebElement tileBookStore;

    public void clickOnElements() {
        driver.findElement(element).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void clickOnElementsFindBy() {
        elementsTab.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void getListNames() {
        elements.size();
        for(WebElement el : elements){
            System.out.println(el.getText() + " is displayed:" + el.isDisplayed());
        }
    }

    public void clickBookStoreTile() {
        waitForVisible(tileBookStore);
        tileBookStore.click();
    }

    public FunctionsPage clickOnTileForms() {
        waitForASomeTime(elements.get(1), 30);
        elements.get(1).click();
        return new FunctionsPage(driver);
    }
        public void clickAlertTab() {
        tileAlertsAndFrame.click();
    }
}
