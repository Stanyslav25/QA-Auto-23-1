package webuitests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import org.pages.myPages.FunctionsPage;
import org.pages.myPages.HomePage;

import static org.junit.jupiter.api.Assertions.assertTrue;
public class HomePageNavigationTest extends BaseTest {
    HomePage homePage = new HomePage(driver);
    FunctionsPage functionsPage = new FunctionsPage(driver);

    @Test
    public void navigationTest() {
        homePage.clickOnElementsFindBy();
        functionsPage.clickTextBox();
    }
    @Test
    public void getTilesNames() {
        homePage.getListNames();
    }
    @Test
    public void clickTileForms() {
        homePage.clickOnTileForms();
        functionsPage.getAcordeonOptionPracticeForm().click();
        assertTrue(functionsPage.wrapperPracticeFormVisibility());
    }
}
