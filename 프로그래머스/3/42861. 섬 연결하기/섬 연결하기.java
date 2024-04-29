import java.util.*;

class Solution {
    private static int[] parent;
    public int solution(int n, int[][] costs) {
        //cost 오름차순 정렬
        Arrays.sort(costs, (o1,o2) -> Integer.compare(o1[2],o2[2]));
        
        parent = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
        
        int answer = 0; //최소 신장 트리의 총 비용
        int edges = 0; // 연결된 다리의 수
        
        for(int[] edge : costs) {
            // 간선이 n-1 개면 모든 섬이 이어진 것이다.
            if(edges == n-1) {
                break;
            }
            // 현재 다리가 연결하는 두 섬이 이미 연결 되었는지 확인 
            if(find(edge[0]) != find(edge[1])) {
                union(edge[0],edge[1]);
                
                answer += edge[2];
                edges++;
            }
        }
        
        return answer;
    }
    private static int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        
        return parent[x] = find(parent[x]); // 경로 압축
    }
    
    private static void union(int x,int y) {
        int root1 = find(x);
        int root2 = find(y);
        
        parent[root2] = root1; 
    }
}