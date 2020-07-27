package example;

import java.util.Arrays;

public class InputValid {

    static boolean isLengthValid(String[] strArr) {
        if (strArr.length != 4) {
            System.out.print("Wrong Input,Input again");
            return false;
        }
        return true;
    }

    static boolean isInputBetween0To9(String[] strArr) {
        for (String s : strArr) {
            if (Integer.parseInt(s) < 0 || Integer.parseInt(s) > 9) {
                System.out.print("Wrong Input,Input again");
                return false;
            }
        }
        return true;
    }

    static boolean isIntegerNumber(String[] strArr){
        try {
            Arrays.stream(strArr).forEach(Integer::parseInt);
        }catch (Exception e){
            System.out.print("Wrong Input,Input again");
            return false;
        }
        return true;
    }

    static boolean isNotContainSameNumber(String[] strArr) {
        boolean isContainSameNumber = Arrays.stream(strArr)
                .distinct().toArray().length == strArr.length;
        if(!isContainSameNumber){
            System.out.print("Wrong Input,Input again");
        }
        return isContainSameNumber;
    }

}
