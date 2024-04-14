package Book;

import java.util.Arrays;
import java.util.Collections;

public class prob02 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 3, 2, 1, 5, 6, 4};

        int[] answer = solution(arr);

        System.out.println(Arrays.toString(answer));
    }

    private static int[] solution(int[] arr) {
        Integer[] result = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new);
        Arrays.sort(result, Collections.reverseOrder());

        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }
}
