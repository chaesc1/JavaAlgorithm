package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P15686 {
    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] board;
    static int n, m;
    static boolean[] visited;
    static ArrayList<Node> chickenList = new ArrayList<>();
    static ArrayList<Node> homeList = new ArrayList<>();
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken()); // 최대 M 개의 치킨집을 뽑아야해

        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2) {
                    chickenList.add(new Node(i, j));
                } else if (board[i][j] == 1) {
                    homeList.add(new Node(i, j));
                }
            }
        }
        visited = new boolean[chickenList.size()];
        backTracking(0, 0);
        System.out.println(min); //치킨 거리의 최솟값을 출력
    }

    private static void backTracking(int count, int index) {
        if (count == m) {
            int distance = 0;// 치킨거리
            for (int j = 0; j < homeList.size(); j++) {
                int sum = Integer.MAX_VALUE;
                for (int k = 0; k < chickenList.size(); k++) {
                    if (visited[k]) {
                        int calculate = Math.abs(homeList.get(j).x - chickenList.get(k).x) + Math.abs(
                                homeList.get(j).y - chickenList.get(k).y);
                        sum = Math.min(sum, calculate);
                    }
                }
                distance += sum;
            }
            min = Math.min(distance, min);
            return;
        }

        for (int i = index; i < chickenList.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                backTracking(count + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}
