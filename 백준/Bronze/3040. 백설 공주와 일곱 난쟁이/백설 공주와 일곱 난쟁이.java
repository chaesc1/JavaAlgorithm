import java.io.BufferedReader;

public class Main {
    static int[] arr;
    static int[] isSelected;
    static int sum = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        arr = new int[9];
        isSelected = new int[7];

        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        backTracking(0, 0);
        System.out.println(sb.toString());
    }

    private static void backTracking(int depth, int start) {
        if (depth == 7) {
            if (sum == 100) {
                for (int i = 0; i < 7; i++) {
                    sb.append(isSelected[i]).append("\n");
                }
            }
            return;
        }

        for (int i = start; i < 9; i++) {
            isSelected[depth] = arr[i];
            sum += arr[i];
            backTracking(depth+1, i+1);
            sum -= arr[i];
        }
    }
}