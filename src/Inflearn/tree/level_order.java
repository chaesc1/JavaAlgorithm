package Inflearn.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// 레벨 순서 탐색: 큐 크기를 스냅샷 떠서 레벨 단위로 묶어 반환
public class level_order {
    static class Node {
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    public List<List<Integer>> solution(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int levelSize = q.size(); // 지금 큐에 쌓여있는 만큼이 "현재 레벨" 전체
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                Node cur = q.poll();
                level.add(cur.value);
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            result.add(level);
        }
        return result;
    }

    // 응용: 각 레벨의 가장 오른쪽 노드만 모으면 "트리의 오른쪽 뷰"
    public List<Integer> rightSideView(Node root) {
        List<Integer> result = new ArrayList<>();
        for (List<Integer> level : solution(root)) {
            result.add(level.get(level.size() - 1));
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

        level_order p = new level_order();
        System.out.println(p.solution(root));       // 기대 출력: [[1], [2, 3], [4, 5, 6]]
        System.out.println(p.rightSideView(root));   // 기대 출력: [1, 3, 6]
    }
}
