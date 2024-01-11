package junit5examples;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;

import static junit5examples.FirstTestClass.commonStep;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParametrizedTest {

    @DisplayName("name")
    @ParameterizedTest(name = "Run: {index}, value: {argumentsWithNames}")
    @ValueSource(ints = {1, 5, 6})
    void intValues(int theParam) {
        commonStep("Params " + theParam);
    }

    @DisplayName("name")
    @ParameterizedTest(name = "Run: {index}, values : {arguments}")
    @EmptySource
    @ValueSource(strings = {"first", "second"})
    void stringValues(String stringParam) {
        commonStep("Params " + stringParam);
    }

    @ParameterizedTest(name = "Run: {index}, value: {argumentsWithNames}")
    @CsvSource(value = {"steve?rogers?3", "captain?marvel?5"},  delimiter = '?')
    void csv_PairString(String param1, String param2, int param3){
        System.out.println("Value1 = " + param1 + ", Value2 = " + param2 + "Int value: " + param3);
    }

    @ParameterizedTest(name = "Run: {index}, value: {argumentsWithNames}")
    @CsvFileSource(files = { "src/test/resources/somegoods.csv", "src/test/resources/paramFiles/somegoods.csv"}, numLinesToSkip = 1)
    void csv_fileSource(String name, Double price, int qty, String uom, String provider){
        System.out.println("name = " + name + ", price = " + price + ", qty = " + qty + ", uom = " + uom + ", provider = " + provider);
    }

    @ParameterizedTest
    @MethodSource(value = "junit5examples.ParamProvider#sourceListStringDouble")
    void paramProvider(String param1, double param2) {
        System.out.println("param1: " +param1+ ", param2: " +param2);
    }

    static List<Arguments> sourceListStringDouble(){
        return Arrays.asList(arguments("tomato",2.0),
                arguments("carrot",2.5),arguments("cabbage",3.2));
    }

}
