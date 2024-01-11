package junit5examples;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.DayOfWeek;
import java.time.LocalDate;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FirstTestClass {

    @BeforeAll
    void setupBeforeAllTests() {
        commonStep("-- before All setup method--");
    }

    @BeforeEach
    void setupBeforeEachTestMethod() {
        commonStep("---- before Each setup method----");
    }

    @AfterAll
    void cleanAfterAll() {
        commonStep("-- after All cleanup method --");
    }

    @AfterEach
    void cleanAfterEach() {
       commonStep("---- after Each cleanup method ---------");
    }

    @Test
    @Order(3)
    @DisplayName("My first test")
    void firstMethod(){
        commonStep("This is first test method");
    }

    @Test
    @Order(5)
    @DisplayName("My second test")
    void secondTest(){
        commonStep("This is a second test method");
    }

    @Disabled("disabled for demo")
    @Test
    //TODO: fix after demo bug reported MP-2374
    void thirdTest(){
        commonStep("This is a third test method");
    }

    @EnabledOnOs(value = OS.MAC, disabledReason = "Specific MAC case")
    @Test
    void enabledOnOsTest(){
        commonStep("This is enabled on MAC");
    }

    @DisabledOnOs(value = OS.MAC, disabledReason = "Specific windows case")
    @Test
    void disabledOnOsTest(){
        commonStep("This is disabled on MAC");
    }

    @Test
    @Order(1)
    @DisabledIf(value = "provider", disabledReason = "if function is not ready yet")
    void testValueProvider() {
        commonStep("Value provider test");
    }

    @Test
    @Order(2)
    @EnabledIf(value = "provider", disabledReason = "if function is not ready yet")
    void testValueProviderEnabled() {
        commonStep("Value provider test Enabled");
    }

    public static void commonStep(String param) {
        System.out.println(param);
    }

    boolean provider() {
        return LocalDate.now().getDayOfWeek().equals(DayOfWeek.TUESDAY);
    }

}
