package BOJ.Implement;
public class NHN {
    public static void main(String[] args) {
        
        int num = 24;
        
        String binaryString = Integer.toBinaryString(24);
        System.out.println("binaryString = " + binaryString);

        String answer = toBinary(num);

        System.out.println("answer = " + answer);

        int decimal = toDecimal(answer);
        System.out.println("decimal = " + decimal);

        int decimalResult = binaryToDecimal(answer);
        System.out.println(answer + "의 10진수 표현: " + decimalResult);
    }

    public static int binaryToDecimal(String binaryStr) {
        int decimalNum = 0;
        int binaryLength = binaryStr.length();

//        for (int i = 0; i < binaryLength; i++) {
//            System.out.println(binaryStr.charAt(i));
//            // 문자열의 왼쪽(높은 자릿수)에서 오른쪽(낮은 자릿수)으로 이동하면서 각 자릿수에 2의 거듭제곱을 곱하여 더합니다.
//            int digit = Integer.parseInt(String.valueOf(binaryStr.charAt(i)));
//            System.out.println("digit = " + digit);
//            decimalNum = decimalNum * 2 + digit;
//            System.out.println("decimalNum = " + decimalNum);
//        }

        int sum = 0;
        int index = 0;
        for (int i = binaryLength-1; i >= 0; i--) {
            int digit = Integer.parseInt(String.valueOf(binaryStr.charAt(i)));

            sum += (int) (digit*Math.pow(2,index++));
        }
        return sum;
    }
    private static String toBinary(int num) {
        
        String result = "";
        
        for(int i=num; i>0; i/=2){
            result = String.valueOf(i%2) + result;
        }
        
        return result;
    }

    private static int toDecimal(String string) {
        return Integer.parseInt(string,2);
    }
}
