package example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


public class NumberGuessTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    private String systemOut() {
        return outContent.toString();
    }

    @Test
    void should_return_4A0B_when_guess_given_guess_number_1234_answer_1234() {
        //given
        NumberGuess numberGuess = new NumberGuess();
        int[] guess = {1, 2, 3, 4};
        int[] answer = {1, 2, 3, 4};

        //when
        String result = numberGuess.guess(guess, answer);

        //then
        assertEquals("4A0B", result);

    }

    @Test
    void should_return_0A0B_when_guess_given_guess_number_6789_answer_1234() {
        //given
        NumberGuess numberGuess = new NumberGuess();
        int[] guess = {6, 7, 8, 9};
        int[] answer = {1, 2, 3, 4};

        //when
        String result = numberGuess.guess(guess, answer);

        //then
        assertEquals("0A0B", result);

    }

    @Test
    void should_return_2A0B_when_guess_given_number_1234_answer_1256() {
        //given
        NumberGuess numberGuess = new NumberGuess();
        int[] guess = {1, 2, 3, 4};
        int[] answer = {1, 2, 5, 6};

        //when
        String result = numberGuess.guess(guess, answer);

        //then
        assertEquals("2A0B", result);

    }

    @Test
    void should_return_0A2B_when_guess_given_number_7834_answer_3456() {
        //given
        NumberGuess numberGuess = new NumberGuess();
        int[] guess = {7, 8, 3, 4};
        int[] answer = {3, 4, 5, 6};

        //when
        String result = numberGuess.guess(guess, answer);

        //then
        assertEquals("0A2B", result);
    }

    @Test
    void should_return_0A4B_when_guess_given_number_6543_answer_3456() {
        //given
        NumberGuess numberGuess = new NumberGuess();
        int[] guess = {6,5,4,3};
        int[] answer = {3, 4, 5, 6};

        //when
        String result = numberGuess.guess(guess, answer);

        //then
        assertEquals("0A4B", result);
    }

    @Test
    void should_return_2A2B_when_guess_given_number_1234_answer_1243() {
        //given
        NumberGuess numberGuess = new NumberGuess();
        int[] guess = {1, 2, 3, 4};
        int[] answer = {1, 2, 4, 3};

        //when
        String result = numberGuess.guess(guess, answer);

        //then
        assertEquals("2A2B", result);

    }

    @Test
    void should_return_5_when_guess_start_when_first_is_correct() {
        //given
        NumberGuess numberGuess = new NumberGuess();
        int[] guess = {1, 2, 3, 4};
        int[] answer = {1, 2, 3, 4};

        //when
        numberGuess.guessStart(guess,answer);

        //then
        assertEquals(5, numberGuess.getTime()-1);

    }

    @Test
    void should_return_true_when_is_input_valid_given_12345() {
        //given
        System.setOut(new PrintStream(outContent));
        NumberGuess numberGuess = new NumberGuess();
        String[] strs = "1 2 3 4 5".split(" ");

        //when
        numberGuess.isInputValid(strs);


        //then
        assertEquals("Wrong Input,Input again",systemOut());
    }

    @Test
    void should_return_true_when_is_input_valid_given_1145() {
        //given
        System.setOut(new PrintStream(outContent));
        NumberGuess numberGuess = new NumberGuess();
        String[] strs = "1 1 4 5".split(" ");

        //when
        numberGuess.isInputValid(strs);

        //then
        assertEquals("Wrong Input,Input again",systemOut());
    }

    @Test
    void should_return_true_when_is_input_valid_given_90_145() {
        //given
        System.setOut(new PrintStream(outContent));
        NumberGuess numberGuess = new NumberGuess();
        String[] strs = "90 1 4 5".split(" ");

        //when
        numberGuess.isInputValid(strs);

        //then
        assertEquals("Wrong Input,Input again",systemOut());
    }

    @Test
    void should_return_true_when_is_input_valid_given_a145() {
        //given
        System.setOut(new PrintStream(outContent));
        NumberGuess numberGuess = new NumberGuess();
        String[] strs = "a 1 4 5".split(" ");

        //when
        numberGuess.isInputValid(strs);

        //then
        assertEquals("Wrong Input,Input again",systemOut());
    }

    @Test
    void should_return_true_when_guessStart_given_input_1234_answer_1234() {
        //given
        AnswerBuilder answerBuilder = Mockito.mock(AnswerBuilder.class);
        when(answerBuilder.createAnswer()).thenReturn(new int[]{1, 2, 3, 4});
        NumberGuess numberGuess = new NumberGuess(answerBuilder);
        //when
        boolean result = numberGuess.guessStart("1 2 3 4");

        //then
        assertTrue(result);
    }
}
