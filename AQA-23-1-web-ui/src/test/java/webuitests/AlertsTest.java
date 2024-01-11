package webuitests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import org.pages.myPages.AlertsAndFrames;
import org.pages.myPages.HomePage;


public class AlertsTest extends BaseTest {
    AlertsAndFrames alertsAndFrames = new AlertsAndFrames(driver);
    HomePage homePage = new HomePage(driver);
    @Test
    public void getAlertTextAndAccept() {
        homePage.clickAlertTab();
        alertsAndFrames.chooseAlertsTab();
        alertsAndFrames.triggerAlert();
        alertsAndFrames.acceptAlert();
    }
}
