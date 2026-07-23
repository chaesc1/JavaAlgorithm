package Inflearn.tree;

// 주어진 이진 트리가 유효한 BST인지 판별
// 흔한 실수: 바로 아래 자식과만 비교하면 안 됨 (예: 왼쪽의 오른쪽 자식이 루트보다 커도 되는 것처럼 보임)
// -> 재귀 호출마다 "허용 가능한 값의 범위(min, max)"를 넘겨서 모든 조상 기준으로 검증해야 함
public class bst_validate {
    static class Node {
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    public boolean solution(Node root) {
        return isValid(root, null, null);
    }

    private boolean isValid(Node cur, Integer min, Integer max) {
        if (cur == null) return true;

        if (min != null && cur.value <= min) return false;
        if (max != null && cur.value >= max) return false;

        return isValid(cur.left, min, cur.value) && isValid(cur.right, cur.value, max);
    }

    public static void main(String[] args) {
        // 유효한 BST
        //     5
        //    / \
        //   3   8
        Node valid = new Node(5);
        valid.left = new Node(3);
        valid.right = new Node(8);

        // 유효하지 않은 BST: 3의 오른쪽 자식(6)이 루트(5)보다 큼 -> 왼쪽 서브트리에 있으면 안 됨
        //     5
        //    / \
        //   3   8
        //    \
        //     6
        Node invalid = new Node(5);
        invalid.left = new Node(3);
        invalid.right = new Node(8);
        invalid.left.right = new Node(6);

        bst_validate p = new bst_validate();
        System.out.println(p.solution(valid));   // 기대 출력: true
        System.out.println(p.solution(invalid)); // 기대 출력: false
    }
}
