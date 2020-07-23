package example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberGuessTest {

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
}
