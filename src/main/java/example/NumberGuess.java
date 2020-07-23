package example;

import java.util.Scanner;

public class NumberGuess {

    private int[] answer;
    private int time = 6;

    public NumberGuess(AnswerBuilder answerBuilder) {
        answer = answerBuilder.createAnswer();
    }

    public NumberGuess(){}

    public int getTime() {
        return time;
    }

    public String guess(int[] guessInput, int[] answer) {
        int isCorrectPosition = 0;
        int isCorrectNumber = 0;
        for(int index =0;index<guessInput.length;index++){
            for(int answerIndex=0;answerIndex<answer.length;answerIndex++){
                if(guessInput[index]==answer[index]&&index==answerIndex){
                    isCorrectPosition++;
                }
                if(guessInput[index]==answer[answerIndex]){
                    isCorrectNumber++;
                }
            }
        }
        return String.format("%sA%sB",isCorrectPosition,isCorrectNumber-isCorrectPosition);
    }

    public void guessStart(int[] guessInput, int[] answer) {
        for(;time>0;time--){
            if(guess(guessInput, answer).equals("4A0B"))
                break;
        }
    }

    public boolean isInputValid() {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String[] arr = str.split(" ");
        int arrInt[] = new int[arr.length];
        return false;
    }

    public String isInputValid(String str) {
        String[] strArr = str.split(" ");
        if(strArr.length!=4){
            System.out.print("Wrong Input,Input again");
            return "Wrong Input,Input again";
        }
        int[] flag = {0,0,0,0,0,0,0,0,0,0,0};
        for (String s : strArr) {
            if (Integer.parseInt(s) < 0 || Integer.parseInt(s) > 9) {
                System.out.print("Wrong Input,Input again");
                return "Wrong Input，Input again";
            }
            if(flag[Integer.parseInt(s)]!=1){
                flag[Integer.parseInt(s)]=1;
            }else {
                System.out.print("Wrong Input,Input again");
                return "Wrong Input,Input again";
            }

        }
        return "";
    }
}
