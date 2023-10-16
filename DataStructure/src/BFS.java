import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        // 그래프를 2차원 배열로 표현해줍니다.
        // 배열의 인덱스를 노드와 매칭시켜서 사용하기 위해 인덱스 0은 아무것도 저장하지 않습니다.
        // 1번인덱스는 1번노드를 뜻하고 노드의 배열의 값은 연결된 노드들입니다.
        // 1번 노드는 2,3,8 과 연결되어있고 2번 노드는 1,6,8과 연결되어있다.
        int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};

        // 방문처리를 위한 boolean배열 선언
        boolean[] visited = new boolean[9];

        System.out.println(bfs(1, graph, visited));
        //출력 내용 : 1 -> 2 -> 3 -> 8 -> 6 -> 5 -> 4 -> 7 -> 
    }

    static String bfs(int start, int[][] graph, boolean[] visited) {
        //탐색 순서를 출력하기 위한 용도
        StringBuilder sb = new StringBuilder();
        //BFS 에 사용할 큐를 선언
        Queue<Integer> q = new LinkedList<Integer>();

        q.offer(start); // 큐에 BFS 를 시작할 노드 번호를 넣어준다
        visited[start] = true; // 시작 노드를 방문표시

        //큐가 빌때까지 반복
        while (!q.isEmpty()){
            int nodeIndex = q.poll();
            sb.append(nodeIndex+ "->");
            //큐에서 꺼낸 노드와 연결된 노드들 체크
            for (int i = 0; i < graph[nodeIndex].length; i++) {
                int temp = graph[nodeIndex][i];
                //방문하지 않았다면 방문처리후 큐에 넣기
                if (!visited[temp]) {
                    visited[temp] = true;
                    q.offer(temp);
                }
            }
        }
        return sb.toString();
    }
}
