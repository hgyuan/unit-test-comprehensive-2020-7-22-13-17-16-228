package example;

import java.util.Scanner;

import static example.InputValid.*;

public class NumberGuess {

    private int[] answer;
    private int time = 6;

    public NumberGuess(AnswerBuilder answerBuilder) {
        answer = answerBuilder.createAnswer();
    }

    public NumberGuess() {
    }

    public int getTime() {
        return time;
    }

    public String guess(int[] guessInput, int[] answer) {
        int CorrectPosition = 0;
        int CorrectNumber = 0;
        for (int index = 0; index < guessInput.length; index++) {
            for (int answerIndex = 0; answerIndex < answer.length; answerIndex++) {
                if (guessInput[index] == answer[index] && index == answerIndex) {
                    CorrectPosition++;
                }
                if (guessInput[index] == answer[answerIndex]) {
                    CorrectNumber++;
                }
            }
        }
        return String.format("%sA%sB", CorrectPosition, CorrectNumber - CorrectPosition);
    }

    public void guessStart(int[] guessInput, int[] answer) {
        for (; time > 0; time--) {
            if (guess(guessInput, answer).equals("4A0B")) {
                break;
            }
        }
    }

    public boolean guessStart(String inputGuess) {
        if (time <= 0) {
            return true;
        }
        time--;
        String[] inputGuessArr = inputGuess.split(" ");
        if (isInputValid(inputGuessArr)) {
            int[] intArr = parseToIntegerArray(inputGuessArr);
            if (guess(intArr, answer).equals("4A0B")) {
                return true;
            }
        }
        return false;
    }

    private int[] parseToIntegerArray(String[] strArr) {
        int[] intArr = new int[4];
        for (int i = 0; i < 4; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }


    public boolean isInputValid(String[] strArr) {
        return isLengthValid(strArr) && isIntegerNumber(strArr)
                && isNotContainSameNumber(strArr) && isInputBetween0To9(strArr);
    }
}
