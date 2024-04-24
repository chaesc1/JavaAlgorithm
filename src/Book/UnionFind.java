package Book;

import java.util.ArrayList;
import java.util.Arrays;

public class UnionFind {
    private static int[] parent;

    //루트 노드를 찾는 메서드
    private static int find(int x) {
        // 만약 x의 부모가 자기 자신이라면, 즉 x는 루트노드다.
        if (parent[x] == x) {
            return  x;
        }

        //그렇지 않다면 x의 부모를 찾아서 parent[x]에 지정한다.
        parent[x] = find(parent[x]);
        return parent[x]; //찾은 노드를 반환
    }

    private static void union(int x,int y) {
        int root1 = find(x);
        int root2 = find(y);
        parent[root2] = root1;
    }

    private static Boolean[] solution(int k,int[][] operation) {
        parent = new int[k]; // 노드의 수 만큼 배열 생성
        for (int i = 0; i < k; i++) {
            parent[i] = i;
        }

        ArrayList<Boolean> answer = new ArrayList<>();

        for (int[] op : operation) {
            if (op[0] == 0) {
                union(op[1], op[2]);
            } else {
                 answer.add(find(op[1]) == find(op[2]));
            }
        }

        return answer.toArray(new Boolean[0]);
    }

    public static void main(String[] args) {
        Boolean[] solution = solution(3, new int[][]{{0, 0, 1}, {0, 1, 2}, {1, 1, 2}});

        System.out.println(Arrays.toString(Arrays.stream(solution).toArray()));
    }
}

