import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DecimalConvertor {

    public static int binaryToDecimal(String binaryValue) {
        int binaryLength = binaryValue.length();

        int sum = 0;
        int index = 0;
        for (int i = binaryLength - 1; i >= 0; i--) {
            int digit = binaryValue.charAt(i)-48;
            sum += (int) (digit*Math.pow(2,index++));
        }
//        return sum;
        return sum;
    }

    public static String decimalToBinary(int decimal) {

        String result = "";

        for (int i = decimal; i > 0; i /= 2) {
            result = String.valueOf(i % 2) + result;
        }

        return result;
    }
    //10 진수를 15비트 2진수로 바꾸는 메서드
    public static String decimalFractionToBinary(int decimal) {
        String result = "";

        for (int i = decimal; i > 0; i /= 2) {
            result = String.valueOf(i % 2) + result;
        }
        String zero = "";
        if (result.length() == 15) {
            return result;
        }
        else {
            for (int i = 0; i < 15-result.length(); i++) {
                zero += '0';
            }
        }
        return zero+result;
    }

    //2진수 소수를 10진수로 변환하는 메서드
    public static double binaryFractionToDecimal(String binaryValue) {
        int binaryLength = binaryValue.length();
        int[] arr = new int[16];
        String result = "";
        double sum = 0;
        int index = 4;
        int reverseIndex = -1;
        for (int i = 0; i < binaryLength; i++) {
            int digit = binaryValue.charAt(i)-48;
//            System.out.println(digit);
            sum += (digit*Math.pow(2,reverseIndex--));
        }
        
        return sum;
    }
}

class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a binary value: ");
        String binary = br.readLine(); //2진수 String 입력 받고
        int toDecimal = DecimalConvertor.binaryToDecimal(binary);

        System.out.println(toDecimal); // 2진수를 10진수로
        System.out.println(DecimalConvertor.decimalToBinary(toDecimal)); //10진수를 2진수로
//       10진수를 2진수 소수로 변환하는 방법
        System.out.println("10진수(9) 를 2진수 소수로 변환하는 방법" + DecimalConvertor.decimalFractionToBinary(9));
//       2진수 소수를 10진수로 변환하는 방법
        String fractionAnswer = "";
        String fractionStr = String.valueOf(DecimalConvertor.binaryFractionToDecimal("1011000000000000"));
        for (int i = 0; i < fractionStr.length(); i++) {
            if (fractionStr.charAt(i) == '0' || fractionStr.charAt(i) == '.') {
                continue;
            }
            fractionAnswer+=fractionStr.charAt(i);
        }
        System.out.println("2진수 소수(1011000000000000) 를 10진수로 변환하는 방법 : "+fractionAnswer);
//        System.out.println(Math.pow(2,-2));
    }
}
