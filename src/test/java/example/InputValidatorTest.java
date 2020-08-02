package example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class InputValidatorTest {

    private final ByteArrayOutputStream byteArrayInputStream = new ByteArrayOutputStream();

    private String systemOut(){
        return byteArrayInputStream.toString();
    }

    @BeforeEach
    public void setPrint(){
        System.setOut(new PrintStream(byteArrayInputStream));
    }

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

    @Test
    void should_return_true_when_is_integer_number_given_12() {
        String[] str = new String[]{"0", "2"};
        InputValidator inputValidator = new InputValidator();

        boolean result = inputValidator.isIntegerNumber(str);

        assertTrue(result);
    }

    @Test
    void should_return_false_when_is_integer_number_given_a2() {
        String[] str = new String[]{"a", "2"};
        InputValidator inputValidator = new InputValidator();

        boolean result = inputValidator.isIntegerNumber(str);

        assertFalse(result);
        assertEquals("Wrong Input,Input again",systemOut());
    }

    @Test
    void should_return_true_when_is_not_contain_same_number_given_123() {
        String[] str = new String[]{"1", "2", "3"};
        InputValidator inputValidator = new InputValidator();

        boolean result = inputValidator.isNotContainSameNumber(str);

        assertTrue(result);
    }
}
