import java.io.BufferedReader;
import java.util.StringTokenizer;

//합집합은 0 a b의 형태로 입력이 주어
//두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산은 1 a b의 형태
public class Solution {
    static int[] parent;
    static int[] rank;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            parent = new int[n + 1];
            rank = new int[n + 1];
            // 집합 초기화
            for (int i = 1; i < n + 1; i++) {
                parent[i] = i;
                rank[i] = 0;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append(" ");
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int command = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (command == 0) {
                    union(a, b);
                }
                if (command == 1) {
                    if (find(a) == find(b)) {
                        sb.append("1");
                    } else {
                        sb.append("0");
                    }
                }
            }
            sb.append("\n");
            // 1로 시작하는 입력에 대해서 같은 집합에 속해있다면 1을, 아니면 0을 순서대로 한줄에 연속하여 출력
            System.out.println(sb.toString().trim());
        }

    }

    private static int find(int num) {
        if (parent[num] != num) {
            parent[num] = find(parent[num]); // 경로 압축
        }
        return parent[num];
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
            } else if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
            } else {
                parent[rootB] = rootA;
                rank[rootA]++;
            }
        }
    }
}