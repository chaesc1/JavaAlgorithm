package BOJ.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1991 {
    static int N;
    static int[][] tree;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        tree = new int[26][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = st.nextToken().charAt(0) - 'A';
            int left = st.nextToken().charAt(0) - 'A';
            int right = st.nextToken().charAt(0) - 'A';
            //트리를 구성해야해
            makeTree(parent, left, right);
        }

//        //순회 메서드 호출
        preOrder(0);
        sb.append("\n");
        inOrder(0);
        sb.append("\n");
        postOrder(0);

        System.out.println(sb);
    }

    //후위순회
    private static void postOrder(int i) {
        if (i == -1) {
            return;
        }
        //왼쪽 자식노드 재귀
        postOrder(tree[i][0]);
        //오른쪽 자식노드 재귀
        postOrder(tree[i][1]);
        //현재 노드 값 출력
        sb.append((char)(i + 'A'));
    }

    //중위순회
    private static void inOrder(int i) {
        if (i == -1) {
            return;
        }
        //왼쪽 자식노드 재귀
        inOrder(tree[i][0]);
        //현재 노드 값 출력
        sb.append((char)(i + 'A'));
        //오른쪽 자식노드 재귀
        inOrder(tree[i][1]);
    }

    //전위순회
    private static void preOrder(int i) {
        if (i == -1) {
            return;
        }
        //현재 노드 값 출력
        sb.append((char)(i + 'A'));
        //왼쪽 자식노드 재귀
        preOrder(tree[i][0]);
        //오른쪽 자식노드 재귀
        preOrder(tree[i][1]);
    }

    private static void makeTree(int parent, int left, int right) {
        if (left == '.' - 'A') {
            tree[parent][0] = -1;// . 이면 -1 로 표시
        } else {
            tree[parent][0] = left;
        }

        if (right == '.' - 'A') {
            tree[parent][1] = -1;
        } else {
            tree[parent][1] = right;
        }
    }
}
