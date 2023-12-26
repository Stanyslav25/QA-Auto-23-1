package pages.myPages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;

import java.time.Duration;

public class AlertsAndFrames extends BasePage {
    public AlertsAndFrames(WebDriver driver) {
        super(driver);
    }
    ;
    @FindBy(xpath = "//*[text()='Alerts']")
    WebElement tabAlerts;

    @FindBy(id = "alertButton")
    WebElement buttonTriggerAlert;

    public void chooseAlertsTab() {
        tabAlerts.click();
    }

    public void triggerAlert(){
        buttonTriggerAlert.click();
    }

    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        System.out.println("ALERT MESSAGE TEXT: " + alert.getText());
        alert.accept();
    }


}
