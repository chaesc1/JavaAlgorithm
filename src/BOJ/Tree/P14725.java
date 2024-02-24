package BOJ.Tree;

import com.sun.source.tree.Tree;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;


public class P14725 {
    static class Node{
        HashMap<String, Node> childs = new HashMap<>();
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node root = new Node();
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            //루트노드끼리 묶어서 트리
            Node now = root;

            for (int j = 0; j < K; j++) {
                String s = st.nextToken();

                if (!now.childs.containsKey(s)) {
                    now.childs.put(s,new Node());
                }

                now = now.childs.get(s);
            }
        }

        printTree(root, "");
    }

    private static void printTree(Node root, String s) {
        Object[] array = root.childs.keySet().toArray();
        Arrays.sort(array);
        for (Object o : array) {
            System.out.println(s+o.toString());
            printTree(root.childs.get(o),s+"--");
        }

    }
}
