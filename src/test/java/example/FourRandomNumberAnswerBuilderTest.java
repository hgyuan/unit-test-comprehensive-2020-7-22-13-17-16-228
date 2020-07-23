package example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FourRandomNumberAnswerBuilderTest {

    @Test
    void should_return_array_size_is_4_when_create_answer() {
        //given
        FourRandomNumberAnswerBuilder fourRandomNumberAnswerBuilder = new FourRandomNumberAnswerBuilder();

        //when
        int[] arr = fourRandomNumberAnswerBuilder.createAnswer();

        //then
        assertEquals(4,arr.length);
    }
}
