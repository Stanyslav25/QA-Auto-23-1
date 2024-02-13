package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlertPage {
    private final Page alertsPage;
    private final Locator tabAlerts;
    private final Locator buttonTriggerAlert;
    private final Locator buttonTriggerPrompt;
    private final Locator promptResult;

    public AlertPage(Page alertsPage) {
        this.alertsPage = alertsPage;
        this.tabAlerts = alertsPage.locator("//*[text()='Alerts']");
        this.buttonTriggerAlert = alertsPage.locator("//*[@id='alertButton']");
        this.buttonTriggerPrompt = alertsPage.locator("//*[@id='promtButton']");
        this.promptResult = alertsPage.locator("//*[@id='promptResult']");
    }

    public void triggerAlert(){
        tabAlerts.click();
    }

    public void alertSubmit() {
        alertsPage.onceDialog(dialog -> {
            assertEquals("alert", dialog.type());
            assertEquals("You clicked a button", dialog.message());
            System.out.println("Alert was accepted");
            dialog.accept();
        });
        buttonTriggerAlert.click();
    }

    public void clickPromptButton(String promptText) {
        alertsPage.onDialog(dialog -> {
            assertEquals("prompt", dialog.type());
            alertsPage.onceDialog(alert -> alert.accept());
            dialog.accept(promptText);
            System.out.println("Alert with prompt was accepted");
        });
        buttonTriggerPrompt.click();
    }

    public void verifyPrompt() {
        promptResult.textContent().contains("Stas test");
        alertsPage.frameLocator("");
    }


}
