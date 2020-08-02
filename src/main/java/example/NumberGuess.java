package example;

import static example.InputValidator.*;

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
        int correctPosition = countCorrentPositionNumber(guessInput, answer);
        int correctNumber = countCorrectSameNumber(guessInput, answer);
        return formatString(correctPosition, correctNumber);
    }

    private Integer countCorrentPositionNumber(int[] guessInput, int[] answer) {
        int correctPosition = 0;
        for (int index = 0; index < guessInput.length; index++) {
            if (guessInput[index] == answer[index]) {
                correctPosition++;
            }
        }
        return correctPosition;
    }

    private Integer countCorrectSameNumber(int[] guessInput, int[] answer) {
        int correctNumber = 0;
        for (int guessIndex = 0; guessIndex < guessInput.length; guessIndex++) {
            for (int answerIndex = 0; answerIndex < answer.length; answerIndex++) {
                if (guessInput[guessIndex] == answer[answerIndex]) {
                    correctNumber++;
                }
            }
        }
        return correctNumber;
    }

    private String formatString(int correctPosition, int correctNumber) {
        return String.format("%sA%sB", correctPosition, correctNumber - correctPosition);
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
        InputValidator inputValidator = new InputValidator();
        return inputValidator.isLengthValid(strArr) && inputValidator.isIntegerNumber(strArr)
                && inputValidator.isNotContainSameNumber(strArr) && inputValidator.isInputBetween0To9(strArr);
    }
}
