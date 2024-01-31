package pageTests;

import base.BaseTestRunner;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomePageTest extends BaseTestRunner {
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
}
