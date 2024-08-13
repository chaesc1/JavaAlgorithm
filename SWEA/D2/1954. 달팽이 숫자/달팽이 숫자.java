import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    private static final int[] DX = {0, 1, 0, -1};
    private static final int[] DY = {1, 0, -1, 0};

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int tc = Integer.parseInt(br.readLine());
            StringBuilder output = new StringBuilder();

            for (int i = 0; i < tc; i++) {
                int size = Integer.parseInt(br.readLine());
                int[] map = new int[size * size];
                fillSnailMap(map, size);
                appendMap(output, map, size, i + 1);
            }

            System.out.print(output.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fillSnailMap(int[] map, int size) {
        int count = 1;
        int x = 0, y = 0, d = 0;

        while (count <= size * size) {
            map[x * size + y] = count++;
            int nx = x + DX[d];
            int ny = y + DY[d];

            if (nx < 0 || nx >= size || ny < 0 || ny >= size || map[nx * size + ny] != 0) {
                d = (d + 1) % 4;
                nx = x + DX[d];
                ny = y + DY[d];
            }
            x = nx;
            y = ny;
        }
    }

    private static void appendMap(StringBuilder output, int[] map, int size, int caseNumber) {
        output.append("#").append(caseNumber).append("\n");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                output.append(map[i * size + j]).append(" ");
            }
            output.append("\n");
        }
    }
}