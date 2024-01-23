package utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class Listener implements WebDriverListener {

    @Override
    public void beforeClick(WebElement element) {
        System.out.println("Clicking on " + element.getText());
    }

    @Override
    public void beforeAccept(Alert alert) {
        System.out.println("Try to accept alert ");
    }
}
