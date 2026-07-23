package Inflearn.tree;

import java.util.ArrayList;
import java.util.List;

// 트리 표현 방법 3가지 예시: 인접 리스트(그래프 스타일) / 이진 트리 Node / N진 트리 NNode
public class Tree {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {
                {0,1},
                {0,2},
                {2,3},
                {2,4}
        };

        List<List<Integer>> tree = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]); // 단방향
            tree.get(edge[1]).add(edge[0]); // 양방향
        }

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        // N 진 트리
        NNode nRoot = new NNode(1);
        nRoot.children.add(new NNode(2));
        nRoot.children.add(new NNode(3));
        nRoot.children.add(new NNode(4));
        nRoot.children.get(1).children.add(new NNode(5));
    }

    // 클래스 구현
    // 2진 노드
    static class Node {
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    static class NNode {
        int value;
        List<NNode> children;
        public NNode(int value) {
            this.value = value;
            this.children = new ArrayList<>();
        }
    }
}
