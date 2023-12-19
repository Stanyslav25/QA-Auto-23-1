package webuitests;

import base.BaseTest;
import org.junit.jupiter.api.Test;

public class HomePageNavigationTest extends BaseTest {

    @Test
    public void navigationTest() throws InterruptedException {
        getHomePage().clickOnElementsFindBy();
        getFunctionalPage().clickTextBox();
        Thread.sleep(5000);
    }
}
