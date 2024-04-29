import java.util.*;

class Solution {
    private static int[] parent;
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs,(o1,o2) -> Integer.compare(o1[2],o2[2])); // cost 오름차순 정렬
        
        parent = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
        //연결된 다리의 수
        int edges = 0;
        int answer = 0;
        
        for(int[] cost : costs) {
            // System.out.println(cost[0] + " " + cost[1]);
            if(edges == n-1) {
                break;        
            }
            
            if(find(cost[0]) != find(cost[1])) {
                union(cost[0],cost[1]);
                
                answer += cost[2];
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