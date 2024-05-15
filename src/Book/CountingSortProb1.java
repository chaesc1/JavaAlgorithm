package Book;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CountingSortProb1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        // 문자의 카운트를 담을 배열 -> 알파벳 개수 만큼 생성
        int[] count = new int[26];
        // hello 를 ->
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            count[c-'a']++;
        }
        //계수정렬로 알파벳순으로 정렬
        StringBuilder sortedWord = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < count[i]; j++) {
                sortedWord.append((char) (i+'a'));
            }
        }
        System.out.println(sortedWord.toString());
    }
}
