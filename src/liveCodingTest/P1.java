package liveCodingTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
//
public class P1 {
    public static void main(String[] args) throws Exception {
        try {
            File file = new File("/Users/chaejunghun/Desktop/input");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(isPalindrome(line));
            }


        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            e.printStackTrace();
        }

    }

    private static boolean isPalindrome(String line) {
        int start = 0;
        int end = line.length() - 1;

        while (start < end) {
            if (line.charAt(start) != line.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
