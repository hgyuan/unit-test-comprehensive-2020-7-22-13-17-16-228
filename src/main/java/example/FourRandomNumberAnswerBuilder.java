package example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FourRandomNumberAnswerBuilder implements AnswerBuilder {

    List<Integer> numberList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0));

    @Override
    public int[] createAnswer() {
        Collections.shuffle(numberList);
        int[] arr = new int[4];
        for (int i = 0; i < 4; i++) {
            arr[i] = numberList.get(i);
        }
        return arr;
    }
}
