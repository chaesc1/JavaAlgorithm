public class Nhn {
    public static void main(String[] args) {
        String bin = "1111";

        System.out.println(binaryToDecimal(bin));
        int decimal = 24;
        System.out.println(decimalToBinary(decimal));
    }

    private static int binaryToDecimal(String binaryValue) {
        int decimalNum = 0;
        int binaryLength = binaryValue.length();

        int sum = 0;
        int index = 0;
        for (int i = binaryLength-1; i >= 0; i--) {
            int digit = binaryValue.charAt(i)-48;
            System.out.println("digit = " + digit);
            sum += (int) (digit*Math.pow(2,index++));
        }
        return sum;
    }

    private static String decimalToBinary(int decimal) {

        String result = "";

        for(int i=decimal; i>0; i/=2){
            result = String.valueOf(i%2) + result;
        }

        return result;
    }
}
