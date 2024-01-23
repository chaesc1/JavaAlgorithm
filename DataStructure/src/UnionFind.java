//그래프 트리 대표적인 알고리즘
// 서로소인 부분집합의 표현

import static java.nio.file.Files.find;

public class UnionFind {
    static int[] parent;
    public static void main(String[] args) {
        int n = 5;
        parent = new int[n+1];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        union(1,2);
        parentPrint();
        union(3,4);
        parentPrint();
        union(3,5);
        parentPrint();

        System.out.println("find(2) = " + find(2));
        System.out.println("find(4) = " + find(4));
        union(2,4);
        parentPrint();
    }
    public static void parentPrint() {
        System.out.print("[ ");
        for (int i = 1; i < parent.length; i++) {
            System.out.print(parent[i] + " ");
        }
        System.out.println("]");
    }
    public static boolean union(int x,int y) {
        x = find(x); //x's parent
        y = find(y);//y's parent

        //이미 같은 그래프에 속해있을 때 false 반환
        if(x == y) return false;

        if (x <= y) parent[y] = x;
        else parent[x] = y;

        return true;
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return find(parent[x]);
    }

}

