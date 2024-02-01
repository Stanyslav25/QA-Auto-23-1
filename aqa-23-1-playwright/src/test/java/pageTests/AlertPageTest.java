package pageTests;

import base.BaseTestRunner;
import org.junit.jupiter.api.Test;

public class AlertPageTest extends BaseTestRunner {

    @Test
    public void alertsGetTextTest() {
        homePage.clickAlertsTab();
        alertPage.triggerAlert();
        alertPage.alertSubmit();
    }

    @Test
    public void alertWIthPrompt() {
        homePage.clickAlertsTab();
        alertPage.triggerAlert();
        alertPage.clickPromptButton("Stas test");
        alertPage.verifyPrompt();
    }
}
