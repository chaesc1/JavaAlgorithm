package Inflearn.tree;

// 이진 트리에서 최소 공통 조상(LCA)
// 핵심: 왼쪽/오른쪽 서브트리에서 각각 재귀 호출한 결과를 보고
//  - 둘 다 노드를 찾았다면(양쪽에서 발견) 현재 노드가 LCA
//  - 한쪽만 찾았다면 그 결과를 그대로 위로 전달
public class lca {
    static class Node {
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    public Node solution(Node root, Node p, Node q) {
        if (root == null || root == p || root == q) return root;

        Node left = solution(root.left, p, q);
        Node right = solution(root.right, p, q);

        if (left != null && right != null) return root; // p, q가 각각 다른 쪽에서 발견됨
        return left != null ? left : right; // 한쪽에서만 발견 -> 그 결과가 곧 후보 LCA
    }

    public static void main(String[] args) {
        //        1
        //      /   \
        //     2     3
        //    / \     \
        //   4   5     6
        Node root = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        root.left = n2;
        root.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;

        lca p = new lca();
        System.out.println(p.solution(root, n4, n5).value); // 기대 출력: 2 (같은 서브트리)
        System.out.println(p.solution(root, n4, n6).value); // 기대 출력: 1 (서로 다른 서브트리)
        System.out.println(p.solution(root, n4, n2).value); // 기대 출력: 2 (조상-자손 관계)
    }
}
