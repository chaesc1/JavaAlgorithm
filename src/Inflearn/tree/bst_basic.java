package Inflearn.tree;

// 이진 탐색 트리(BST) 삽입/탐색/삭제
// BST 불변식: 모든 왼쪽 자손 < 노드값 < 모든 오른쪽 자손
public class bst_basic {
    static class Node {
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    public Node insert(Node root, int value) {
        if (root == null) return new Node(value);

        if (value < root.value) {
            root.left = insert(root.left, value);
        } else if (value > root.value) {
            root.right = insert(root.right, value);
        }
        // value == root.value 이면 중복이므로 무시
        return root;
    }

    public boolean search(Node root, int value) {
        if (root == null) return false;
        if (root.value == value) return true;
        return value < root.value ? search(root.left, value) : search(root.right, value);
    }

    // 삭제 케이스 3가지: 리프 / 자식 1개 / 자식 2개(오른쪽 서브트리의 최솟값 = 중위 후속자로 대체)
    public Node delete(Node root, int value) {
        if (root == null) return null;

        if (value < root.value) {
            root.left = delete(root.left, value);
        } else if (value > root.value) {
            root.right = delete(root.right, value);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // 자식이 둘인 경우: 오른쪽 서브트리에서 가장 작은 값(후속자)을 찾아 값만 옮기고,
            // 그 후속자 노드는 오른쪽 서브트리에서 삭제
            Node successor = findMin(root.right);
            root.value = successor.value;
            root.right = delete(root.right, successor.value);
        }
        return root;
    }

    private Node findMin(Node root) {
        while (root.left != null) root = root.left;
        return root;
    }

    void inOrder(Node cur, StringBuilder sb) {
        if (cur == null) return;
        inOrder(cur.left, sb);
        sb.append(cur.value).append(" ");
        inOrder(cur.right, sb);
    }

    public static void main(String[] args) {
        bst_basic p = new bst_basic();
        Node root = null;
        for (int v : new int[]{5, 3, 8, 1, 4, 7, 9}) {
            root = p.insert(root, v);
        }

        StringBuilder sb = new StringBuilder();
        p.inOrder(root, sb);
        System.out.println(sb.toString().trim()); // 기대 출력: 1 3 4 5 7 8 9

        System.out.println(p.search(root, 7)); // 기대 출력: true
        System.out.println(p.search(root, 6)); // 기대 출력: false

        root = p.delete(root, 3); // 자식 1개(4) 케이스
        sb = new StringBuilder();
        p.inOrder(root, sb);
        System.out.println(sb.toString().trim()); // 기대 출력: 1 4 5 7 8 9

        root = p.delete(root, 5); // 자식 2개 케이스 (후속자 7로 대체)
        sb = new StringBuilder();
        p.inOrder(root, sb);
        System.out.println(sb.toString().trim()); // 기대 출력: 1 4 7 8 9
    }
}
