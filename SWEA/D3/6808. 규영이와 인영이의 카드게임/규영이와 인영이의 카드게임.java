import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {
    static int[] kCards;
    static int[] iCards;
    static boolean[] cardUsed;
    static int winCount;
    static int loseCount;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCases = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= testCases; tc++) {
            kCards = new int[9];
            boolean[] card = new boolean[19]; // cards from 1 to 18
            cardUsed = new boolean[9];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                kCards[j] = Integer.parseInt(st.nextToken());
                card[kCards[j]] = true;
            }

            iCards = new int[9];
            int idx = 0;
            for (int j = 1; j <= 18; j++) {
                if (!card[j]) {
                    iCards[idx++] = j;
                }
            }

            winCount = 0;
            loseCount = 0;

            permute(iCards, 0, new int[9], new boolean[9]);

            sb.append("#").append(tc).append(" ").append(winCount).append(" ").append(loseCount).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void permute(int[] array, int depth, int[] result, boolean[] visited) {
        if (depth == 9) {
            compareScores(result);
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = array[i];
                permute(array, depth + 1, result, visited);
                visited[i] = false;
            }
        }
    }

    private static void compareScores(int[] iResult) {
        int kScore = 0;
        int iScore = 0;
        for (int i = 0; i < 9; i++) {
            if (kCards[i] > iResult[i]) {
                kScore += kCards[i] + iResult[i];
            } else {
                iScore += kCards[i] + iResult[i];
            }
        }

        if (kScore > iScore) {
            winCount++;
        } else if (kScore < iScore) {
            loseCount++;
        }
    }
}