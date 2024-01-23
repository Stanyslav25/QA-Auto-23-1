package webuitests;

import base.BaseTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.pages.myPages.AlertsAndFrames;
import org.pages.myPages.HomePage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class AlertsTest extends BaseTest {
    AlertsAndFrames alertsAndFrames = new AlertsAndFrames(driver);
    HomePage homePage = new HomePage(driver);
    @Test
    @Disabled("Wait for bug fix 2543")
    //TODO: update after fix 2543
    public void getAlertTextAndAccept() {
        homePage.clickAlertTab();
        alertsAndFrames.chooseAlertsTab();
        alertsAndFrames.triggerAlert();
        assertEquals("You clicked a button alert", alertsAndFrames.getText(), "Text are not equal to expected");
        alertsAndFrames.acceptAlert();
    }
}
