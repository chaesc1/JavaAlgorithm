package Softeer.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P1 {
    private static final List<Integer> digits = new ArrayList<>();
    private static long minNum = 0;
    private static long maxNum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] numbers = input.split(" ");

        for (String number : numbers) {
            for (char c : number.toCharArray()) {
                digits.add(Character.getNumericValue(c));
            }
        }

        minNum = createMinNum();
        maxNum = createMaxNum();
        System.out.println(maxNum + minNum);
    }

    private static long createMaxNum() {
        Collections.sort(digits, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (int digit : digits) {
            sb.append(digit);
        }
        return Long.parseLong(sb.toString());
    }

    private static long createMinNum() {
        Collections.sort(digits);
        StringBuilder sb = new StringBuilder();
        for (int digit : digits) {
            sb.append(digit);
        }
        return Long.parseLong(sb.toString());
    }
}