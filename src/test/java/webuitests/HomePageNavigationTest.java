package webuitests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.HomePage;

public class HomePageNavigationTest extends BaseTest {
    HomePage homePage = new HomePage(super.driver);

    @Test
    public void navigationTest(){
        homePage.clickOnElements();

    }
}
