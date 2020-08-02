package example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputValidatorTest {
    @Test
    void should_return_true_when_is_length_valid_given_array_length_4() {
        String[] str = new String[4];
        InputValidator inputValidator = new InputValidator();

        boolean result = inputValidator.isLengthValid(str);

        assertTrue(result);
    }

    @Test
    void should_return_false_when_is_length_valid_given_array_length_1() {
        String[] str = new String[1];
        InputValidator inputValidator = new InputValidator();

        boolean result = inputValidator.isLengthValid(str);

        assertFalse(result);
    }

    @Test
    void should_return_true_when_is_input_between_0_to_9_given_012() {
        String[] str = new String[]{"0", "1", "2"};
        InputValidator inputValidator = new InputValidator();

        boolean result = inputValidator.isInputBetween0To9(str);

        assertTrue(result);
    }

    @Test
    void should_return_false_when_is_input_between_0_to_9_given_01_11() {
        String[] str = new String[]{"0", "1", "11"};
        InputValidator inputValidator = new InputValidator();

        boolean result = inputValidator.isInputBetween0To9(str);

        assertFalse(result);
    }
}
