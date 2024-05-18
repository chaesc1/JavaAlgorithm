import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int length1 = str1.length();
        int length2 = str2.length();

        str1 = str1.replace(str2,"");

        System.out.println((length1 - str1.length()) / length2);
    }
}
