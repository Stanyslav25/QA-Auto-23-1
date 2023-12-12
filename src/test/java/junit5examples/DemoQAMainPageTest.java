package junit5examples;

import base.BaseTest;
import org.junit.jupiter.api.Test;

public class DemoQAMainPageTest extends BaseTest {


    @Test
    public void navigateToElements(){
        homePage
                .clickOnElements()
                .clickTextBox()
                .clickNameField();


    }

}
