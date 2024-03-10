/**
 * Segment Tree 시간복잡도 연산 : log N 데이터 변경 : Log N 데이터 변경시 M 번 연산 -> M Log N
 */
public class DS_segmentTree {

    long[] tree;
    int treeSize;

    public DS_segmentTree(int size) {
        int h = (int) Math.ceil(Math.log(size) / Math.log(2));

        this.treeSize = (int) Math.pow(2, h + 1);
        tree = new long[treeSize];
    }

    public long init(long[] arr, int node, int start, int end) {
        //배열의 시작과 끝이 같으면 leaf 노드
        //원소 배열 값 그대로 받음
        if (start == end) {
            return tree[node] = arr[start];
        }

        return tree[node] = init(arr, node * 2, start, (start + end) / 2)
                + init(arr, node * 2 + 1, (start + end) / 2 + 1, end);
    }

    //Data 변경 Logic
    public void update(int node, int start, int end, int index, long diff) {
        if (index < start || index > end) {
            return;
        }

        //차이를 저장
        tree[node] += diff;

        //리프노드가 아니면 아래 자식들도 확인
        if (start != end) {
            update(node * 2, start, (start + end) / 2, index, diff);
            update(node * 2 + 1, (start + end) / 2 + 1, end, index, diff);


        }
    }

    //구간 합 구하기
    public long sum(int node, int start, int end, int left, int right) {
        if (left < start || right > end) {
            return 0;
        }

        if (left <= start && right >= end) {
            return tree[node];
        }

        //아닌 경우 좌우 트리 탐색
        return sum(node * 2, start, (start + end) / 2, left, right)
                + sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
    }

}
