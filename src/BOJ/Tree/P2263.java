package BOJ.Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2263 {
    static int n;
    static int[] inOrder;
    static int[] postOrder;
    static int[] preOrder;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        inOrder = new int[n];
        postOrder = new int[n];
        preOrder = new int[n];

        // 중위, 후위 순회에 대한 정보를 입력받아
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }
        // 후위 순회에서 루트 노드에 대한 정보를 얻고
        // 중위 순회에서는 왼쪽 자식노드와 오른쪽 자식 노드의 값을 얻음
        // 루트 노드의 값을 계속해서 저장
        getPreOrder(0, n - 1, 0, n - 1);
        StringBuilder sb = new StringBuilder();
        for (int i : preOrder) {
            sb.append(i + " ");
        }
        System.out.println(sb);
    }

    static int index;

    private static void getPreOrder(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart <= inEnd && postStart <= postEnd) {
            preOrder[index++] = postOrder[postEnd];

            int pos = inStart;
            // 중위 순회에서 루트노드 위치를 찾아
            for (int i = inStart; i <= inEnd; i++) {
                if (inOrder[i] == postOrder[postEnd]) {
                    pos = i;
                    break;
                }
            }

            getPreOrder(inStart, pos - 1, postStart, postStart + pos - inStart - 1);
            getPreOrder(pos + 1, inEnd, postStart + pos - inStart, postEnd - 1);
        }
    }
}
