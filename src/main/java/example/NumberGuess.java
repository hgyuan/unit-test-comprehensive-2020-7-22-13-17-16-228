package example;

public class NumberGuess {


    public String guess(int[] guess, int[] answer) {
        int isCorrect = 0;
        for (int index = 0; index < guess.length; index++) {
            if (guess[index] == answer[index]) {
                isCorrect++;
            }
        }
        if(isCorrect==0){
            return "0A0B";
        }
        return String.format("%sA0B",isCorrect);
    }

}
