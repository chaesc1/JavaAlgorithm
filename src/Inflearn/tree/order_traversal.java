package Inflearn.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// 이진 트리 전위/중위/후위 순회를 재귀 + 반복(스택) 양쪽으로 구현하고 결과 비교
public class order_traversal {
    static class Node {
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    List<Integer> preOrderRecursive(Node root) {
        List<Integer> result = new ArrayList<>();
        preOrderRecursive(root, result);
        return result;
    }

    private void preOrderRecursive(Node cur, List<Integer> result) {
        if (cur == null) return;
        result.add(cur.value);
        preOrderRecursive(cur.left, result);
        preOrderRecursive(cur.right, result);
    }

    // 반복 전위: 스택에 오른쪽 먼저 넣고 왼쪽 나중에 넣어야 왼쪽이 먼저 꺼내짐
    List<Integer> preOrderIterative(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            result.add(cur.value);
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
        }
        return result;
    }

    List<Integer> inOrderRecursive(Node root) {
        List<Integer> result = new ArrayList<>();
        inOrderRecursive(root, result);
        return result;
    }

    private void inOrderRecursive(Node cur, List<Integer> result) {
        if (cur == null) return;
        inOrderRecursive(cur.left, result);
        result.add(cur.value);
        inOrderRecursive(cur.right, result);
    }

    // 반복 중위: 왼쪽 끝까지 내려가며 스택에 쌓고, 더 못 내려가면 꺼내서 방문 후 오른쪽으로 이동
    List<Integer> inOrderIterative(Node root) {
        List<Integer> result = new ArrayList<>();
        Deque<Node> stack = new ArrayDeque<>();
        Node cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.value);
            cur = cur.right;
        }
        return result;
    }

    List<Integer> postOrderRecursive(Node root) {
        List<Integer> result = new ArrayList<>();
        postOrderRecursive(root, result);
        return result;
    }

    private void postOrderRecursive(Node cur, List<Integer> result) {
        if (cur == null) return;
        postOrderRecursive(cur.left, result);
        postOrderRecursive(cur.right, result);
        result.add(cur.value);
    }

    // 반복 후위: "역방향 전위(루트-오른쪽-왼쪽)"를 구한 뒤 뒤집으면 후위 순서가 됨
    List<Integer> postOrderIterative(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            result.add(0, cur.value); // 앞에 삽입 -> 최종적으로 뒤집힌 순서가 됨
            if (cur.left != null) stack.push(cur.left);
            if (cur.right != null) stack.push(cur.right);
        }
        return result;
    }

    public static void main(String[] args) {
        //        1
        //      /   \
        //     2     3
        //    / \     \
        //   4   5     6
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        order_traversal p = new order_traversal();
        System.out.println(p.preOrderRecursive(root)); // 기대 출력: [1, 2, 4, 5, 3, 6]
        System.out.println(p.preOrderIterative(root));  // 기대 출력: [1, 2, 4, 5, 3, 6]
        System.out.println(p.inOrderRecursive(root));    // 기대 출력: [4, 2, 5, 1, 3, 6]
        System.out.println(p.inOrderIterative(root));    // 기대 출력: [4, 2, 5, 1, 3, 6]
        System.out.println(p.postOrderRecursive(root));  // 기대 출력: [4, 5, 2, 6, 3, 1]
        System.out.println(p.postOrderIterative(root));  // 기대 출력: [4, 5, 2, 6, 3, 1]
    }
}
