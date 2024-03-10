package BOJ.Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2042 {
    /**
     * M은 수의 변경이 일어나는 횟수이고, K는 구간의 합을 구하는 횟수이다
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] arr = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        //Define Segment Tree
        // n - Size Of Tree
        SegmentTree segmentTree = new SegmentTree(n);
        segmentTree.init(arr, 1, 1, n);

        //a가 1인 경우 b(1 ≤ b ≤ N)번째 수를 c로 바꾸고
        //a가 2인 경우에는 b(1 ≤ b ≤ N)번째 수부터 c(b ≤ c ≤ N)번째 수까지의 합
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            if (command == 1) {
                segmentTree.update(1, 1, n, a, b - arr[a]);
                arr[a] = b;
            } else {
                System.out.println(segmentTree.sum(1, 1, n, a, (int) b));
            }
        }
    }

    static class SegmentTree {
        long[] tree;
        int treeSize;

        public SegmentTree(int size) {
            int h = (int) Math.ceil(Math.log(size) / Math.log(2));

            treeSize = (int) Math.pow(2, h + 1);
            tree = new long[treeSize];
        }

        public long init(long[] arr, int node, int start, int end) {
            if (start == end) {
                return tree[node] = arr[start];
            }

            return tree[node] = init(arr, node * 2, start, (start + end) / 2)
                    + init(arr, node * 2 + 1, (start + end) / 2 + 1, end);
        }

        public void update(int node, int start, int end, int index, long diff) {
            if (index < start || end < index) {
                return;
            }
            tree[node] += diff;

            if (start != end) {
                update(node * 2, start, (start + end) / 2, index, diff);
                update(node * 2 + 1, (start + end) / 2, end, index, diff);
            }
        }

        public long sum(int node, int start, int end, int left, int right) {
            if (left > end || right < start) {
                return 0;
            }

            if (left <= start && end <= right) {
                return tree[node];
            }

            return sum(node * 2, start, (start + end) / 2, left, right) +
                    sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        }

    }

}
