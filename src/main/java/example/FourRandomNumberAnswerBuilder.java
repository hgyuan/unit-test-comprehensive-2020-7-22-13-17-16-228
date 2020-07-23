package example;

public class FourRandomNumberAnswerBuilder implements AnswerBuilder {
    @Override
    public int[] createAnswer() {
        int[] arr = new int[4];
        for(int i=0;i<4;i++){
            arr[i] = (int) Math.random()*10;
        }
        return arr;
    }
}
