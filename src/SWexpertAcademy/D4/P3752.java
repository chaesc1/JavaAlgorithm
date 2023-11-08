package SWexpertAcademy.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P3752 {
    static int[] arr;
    static boolean[][] isFlag;
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            int sum = 0;
            arr = new int[N];
            //dfs , dp ? hashset?
            StringTokenizer st =  new StringTokenizer(br.readLine());;
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
            }

            isFlag = new boolean[N+1][sum+1]; //dp table init
            int answer = 0;
            dfs(0,0);
            for (int i = 0; i <= sum; i++) {
                if(isFlag[N][i]){
                    answer++;
                }
            }
            System.out.println("#"+tc+" "+answer);
        }
    }

    private static void dfs(int index, int sum) {
        if(isFlag[index][sum]) return;
        isFlag[index][sum] = true;

        if(index == N) return;
        dfs(index+1,sum + arr[index]);
        dfs(index+1,sum);

    }
}
