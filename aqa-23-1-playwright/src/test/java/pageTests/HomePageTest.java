package pageTests;

import base.BaseTestRunner;
import com.microsoft.playwright.assertions.PageAssertions;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomePageTest extends BaseTestRunner {
    Pattern pattern = Pattern.compile(".*/bookStore");
    Pattern patternAlertsTab = Pattern.compile("/alertsWindows");
    @Test
    public void homePageTest() {
        homePage.openUrl();
        homePage.clickTileBookStore();
        assertThat(page).hasTitle("DEMOQA");
    }

    @Test
    public void clickAlertsTab() {
        homePage.openUrl();
        homePage.clickAlertsTab();
        assertThat(page).hasTitle("DEMOQA");
    }

    //Check page assertions, all possible methods
    @Test
    public void pageAssertionUrlByPattern() {
        homePage.openUrl();
        homePage.clickAlertsTab();
        homePage.verifyURLForAlertsTab(patternAlertsTab);
    }
    @Test
    public void pageAssertionNot() {
        homePage.openUrl();
        homePage.clickAlertsTab();
        assertThat(page).not().hasURL(pattern);
        PlaywrightAssertions.setDefaultAssertionTimeout(30);
        assertThat(page).hasTitle("DEMOQA");
    }
}
