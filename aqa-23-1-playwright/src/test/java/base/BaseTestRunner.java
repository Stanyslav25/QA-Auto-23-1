package base;

import annotations.TestPage;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import pages.AlertPage;
import pages.HomePagePlay;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class BaseTestRunner {
    static Playwright playwright;
    static Browser browser;
    static BrowserContext browserContext;
    public Page page;
    @TestPage
    public HomePagePlay homePage;
    @TestPage
    public AlertPage alertPage;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
    }

    @BeforeEach
    void createContextAndPage() {
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        browserContext = browser.newContext();
        page = browserContext.newPage();
        initPage(this, page);
    }

    public void initPage(Object object, Page page) {
        Class<?> pageClass = object.getClass().getSuperclass();
        for(Field field : pageClass.getDeclaredFields()){
            if(field.isAnnotationPresent(TestPage.class)) {
                Class<?>[] type = {Page.class};
                try{
                field.set(this, field.getType().getConstructor(type).newInstance(page));
                } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException exception) {
                    System.out.println("Cant find constructor for called page " + field.getName());
                }
            }
        }
    }

    @AfterEach
    void closeContext() {
        browserContext.close();
    }

    @AfterAll
    static void closeBrowser(){
        browser.close();
        playwright.close();
    }
}
