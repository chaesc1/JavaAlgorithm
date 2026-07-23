package Inflearn.tree;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    private void solution(int n, List<List<Integer>> tree) {
        boolean[] visited = new boolean[n];
        dfs(0, tree, visited);
    }
    // 양방향 , 일방향 일 경우 visited 없어야 함.
    // basecase 어디? -> 필요 없음
    // child 가 없으면 알아서 빠져 나오기 때문.
    private void dfs(int cur, List<List<Integer>> tree, boolean[] visited) {
        visited[cur] = true;

        // 다음 노드
        for (int child : tree.get(cur)) {
            if (!visited[child]) {
                dfs(child, tree, visited);
            }
        }
    }

    // 탐색하는 과정에 있어서 언제 방문처리를 하냐에 따라 전위 , 중위 , 후위 순회 로 나뉨
    // pre order
    // 루트 노드를 가장 먼저 방문 후 자식 노드들을 정해진 순서에 따라 순차적으로 탐색
    void preOrder(int cur, List<List<Integer>> tree) {
        // visited[cur] = true; // 양방향 일 경우
        System.out.println(cur);

        for (int child : tree.get(cur)) {
            preOrder(child, tree);

            // 양방향 일 경우
            /*if (!visited[child]) {
                preOrder(child,tree);
            }*/
        }


    }

    // 이진 트리 기준 전위/중위/후위 순회 비교
    // 언제 방문 처리(출력)를 하느냐만 다르고 재귀 구조는 동일함
    static class Node {
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    // 전위: 루트 -> 왼쪽 -> 오른쪽 (복사/직렬화에 사용)
    void preOrder(Node cur, List<Integer> result) {
        if (cur == null) return;
        result.add(cur.value);
        preOrder(cur.left, result);
        preOrder(cur.right, result);
    }

    // 중위: 왼쪽 -> 루트 -> 오른쪽 (BST에서 정렬된 순서로 출력됨)
    void inOrder(Node cur, List<Integer> result) {
        if (cur == null) return;
        inOrder(cur.left, result);
        result.add(cur.value);
        inOrder(cur.right, result);
    }

    // 후위: 왼쪽 -> 오른쪽 -> 루트 (자식 결과를 다 취합한 뒤 처리해야 할 때, 삭제 등에 사용)
    void postOrder(Node cur, List<Integer> result) {
        if (cur == null) return;
        postOrder(cur.left, result);
        postOrder(cur.right, result);
        result.add(cur.value);
    }

    public static void main(String[] args) {
        //        1
        //      /   \
        //     2     3
        //    / \     \
        //   4   5     6
        DFS d = new DFS();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        List<Integer> pre = new ArrayList<>();
        d.preOrder(root, pre);
        System.out.println("preOrder: " + pre); // 기대 출력: [1, 2, 4, 5, 3, 6]

        List<Integer> in = new ArrayList<>();
        d.inOrder(root, in);
        System.out.println("inOrder: " + in); // 기대 출력: [4, 2, 5, 1, 3, 6]

        List<Integer> post = new ArrayList<>();
        d.postOrder(root, post);
        System.out.println("postOrder: " + post); // 기대 출력: [4, 5, 2, 6, 3, 1]
    }
}
