import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] cards = new long[n];
        for (int i = 0; i < n; i++) {
            cards[i] = Long.parseLong(br.readLine());
        }

        int max = 0;
        long num = 0;
        HashMap<Long, Integer> map = new HashMap<>();
        for (long card : cards) {
            map.put(card, map.getOrDefault(card, 0) + 1);

            if (map.get(card) > max) {
                max = map.get(card);
                num = card;
            } else if (map.get(card) == max) {
                num = Math.min(num, card);
            }
        }

        System.out.println(num);
    }
}
