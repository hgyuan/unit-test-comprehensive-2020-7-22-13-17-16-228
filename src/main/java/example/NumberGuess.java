package example;

public class NumberGuess {


    public String guess(int[] guess, int[] answer) {
        int isCorrect = 0;
        for (int index = 0; index < guess.length; index++) {
            if (guess[index] != answer[index]) {
                isCorrect++;
            }
        }
        if(isCorrect==4){
            return "0A0B";
        }
        return "4A0B";
    }

}
