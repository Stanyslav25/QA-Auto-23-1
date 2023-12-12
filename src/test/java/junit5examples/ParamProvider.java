package junit5examples;

import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ParamProvider {
    static List<Arguments> sourceListStringDouble(){
        return Arrays.asList(arguments("tomato",2.0),
                arguments("carrot",2.5),arguments("cabbage",3.2));
    }
}
