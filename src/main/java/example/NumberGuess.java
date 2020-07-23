package example;

public class NumberGuess {


    public String guess(int[] guess,int[] answer) {
        for(int index =0 ;index<guess.length;index++){
            if(guess[index]!=answer[index]){
                return "";
            }
        }
        return "4A0B";
    }

}
