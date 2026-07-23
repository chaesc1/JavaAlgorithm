package Inflearn.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// 루트 노드에서 시작하여 같은 레벨에 있는 노드들을 순회하는 알고리즘
public class BFS {
    public void solution(int n, List<List<Integer>> tree) {
        boolean[] visited = new boolean[n];
        bfs(0, tree);
        bfs2(0, tree, visited);
    }
    // 단방향
    private void bfs(int start, List<List<Integer>> tree) {
        // 루트 노드 예약
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        // visited 없다 -> 트리 이면서 , 일방향 리스트 면 방문 표시 필요 X ,

        // 방문 , 예약
        while (!q.isEmpty()) {
            int cur = q.poll();
            for(int next : tree.get(cur)) {
                q.offer(next);
            }
        }

    }
    // 양방향
    private void bfs2(int start, List<List<Integer>> tree, boolean[] visited) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : tree.get(cur)) {
                if (!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
    // 클래스로 구현
    class Node {
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    void soulution2(Node root) {
         bfs3(root);
        // bfs4(root);
    }

    private void bfs3(Node root) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            Node cur = q.poll();
            System.out.print(cur.value + " ");
            if (cur.left != null) q.offer(cur.left);
            if (cur.right != null) q.offer(cur.right);
        }
        System.out.println();
    }

    // N진 트리 클래스
    class Node2 {
        int value;
        List<Node2> children;
        public Node2(int value) {
            this.value = value;
            this.children = new ArrayList<>();
        }
    }

    private void bfs4(Node2 root) {
        Queue<Node2> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            Node2 cur = q.poll();
            System.out.print(cur.value + " ");
            for (Node2 child : cur.children) {
                q.offer(child);
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        // 0 -- 1, 0 -- 2, 2 -- 3, 2 -- 4  (양방향 인접 리스트)
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < 5; i++) tree.add(new ArrayList<>());
        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {2, 4}};
        for (int[] e : edges) {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }
        new BFS().solution(5, tree); // 예외 없이 종료되면 정상 (내부적으로 0→1,2→3,4 순서로 방문)

        // 이진 트리:      1
        //              /   \
        //             2     3
        //            / \     \
        //           4   5     6
        Node root = new BFS().new Node(1);
        root.left = new BFS().new Node(2);
        root.right = new BFS().new Node(3);
        root.left.left = new BFS().new Node(4);
        root.left.right = new BFS().new Node(5);
        root.right.right = new BFS().new Node(6);
        new BFS().soulution2(root); // 기대 출력: 1 2 3 4 5 6

        // N진 트리: 1 - (2, 3, 4), 3 - (5)
        Node2 nRoot = new BFS().new Node2(1);
        nRoot.children.add(new BFS().new Node2(2));
        nRoot.children.add(new BFS().new Node2(3));
        nRoot.children.add(new BFS().new Node2(4));
        nRoot.children.get(1).children.add(new BFS().new Node2(5));
        new BFS().bfs4(nRoot); // 기대 출력: 1 2 3 4 5
    }
}
