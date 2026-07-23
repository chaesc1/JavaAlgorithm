package Inflearn.tree;

// 트리의 높이와 지름: 자식의 결과를 조합해서 전역 답(diameter)을 갱신하는 후위 순회 패턴
public class height_diameter {
    static class Node {
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    private int diameter = 0;

    public int height(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // 지름 = 임의의 두 노드 사이의 최장 경로(간선 수) = 어떤 노드에서 "왼쪽 높이 + 오른쪽 높이"의 최댓값
    public int solution(Node root) {
        diameter = 0;
        heightAndUpdateDiameter(root);
        return diameter;
    }

    private int heightAndUpdateDiameter(Node cur) {
        if (cur == null) return 0;

        int leftHeight = heightAndUpdateDiameter(cur.left);
        int rightHeight = heightAndUpdateDiameter(cur.right);

        // 이 노드를 "정점"으로 지나는 경로 길이 = 왼쪽 높이 + 오른쪽 높이
        diameter = Math.max(diameter, leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        //        1
        //      /   \
        //     2     3
        //    / \     \
        //   4   5     6
        //  /
        // 7
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.left.left.left = new Node(7);

        height_diameter p = new height_diameter();
        System.out.println(p.height(root));   // 기대 출력: 4  (1-2-4-7)
        System.out.println(p.solution(root)); // 기대 출력: 5  (7-4-2-1-3-6, 간선 5개)
    }
}
