package example;

public class NumberGuess {


    public String guess(int[] guess, int[] answer) {
        int isCorrectPosition = 0;
        int isCorrectNumber = 0;
        for (int index = 0; index < guess.length; index++) {
            if (guess[index] == answer[index]) {
                isCorrectPosition++;
            }
        }
        for(int index =0;index<guess.length;index++){
            for(int answerIndex=0;answerIndex<answer.length;answerIndex++){
                if(guess[index]==answer[answerIndex]){
                    isCorrectNumber++;
                }
            }
        }
        return String.format("%sA%sB",isCorrectPosition,isCorrectNumber-isCorrectPosition);
    }

}
