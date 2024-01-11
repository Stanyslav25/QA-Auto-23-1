package junit5examples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionTestClass {

    @Test
    Executable assertionEquals() {
        assertEquals("first", "first", "The string values" +
                " are not equals");
        return null;
    }

    @Test
    void assertList() {
        List<String> expected = Arrays.asList("first", "second", "third");
        List<String> actual = Arrays.asList("first", "second");
        assertEquals(expected, actual, "Lists are not equals");
    }

    @Test
    void assertTrueTest() {
        boolean result = true;
        assertTrue(result);
        assertFalse(result);
    }

    @Test
    void assertThrowTest() {
        assertThrows(TypeNotPresentException.class, null);
    }

    @Test
    void assertAllTest() {
        assertAll(
                () -> assertTrue(false, "First condition failed"),
                () -> assertEquals("first", "first", "The string values" +
                        " are not equals"),
                () -> assertTrue(false, "Third condition failed")
        );
    }
}
