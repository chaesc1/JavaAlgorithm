# 그래프 (graph) — 명시적 그래프 BFS/DFS

## 1. 개념 요약
정점(node)과 간선(edge)이 인접 리스트/행렬로 명시적으로 주어지는 문제를 그래프 탐색으로 푸는 기법이다. DFS는 한쪽 경로를 끝까지 파고든 뒤 되돌아오고, BFS는 가까운 노드부터 층층이 넓게 탐색한다. "모든 노드를 도달 가능한지", "최단 거리/단계 수", "이분 그래프 판별" 같은 문제에 쓰인다.

## 2. 언제 쓰는가
- "A를 열면 B의 열쇠를 얻는다"처럼 연결관계로 도달 가능성을 묻는 문제 → DFS/BFS 아무거나 (전체 탐색이므로 순서 무관)
- "최소 단계/거리"를 구해야 한다 → **BFS** (모든 간선 가중치가 1일 때 최단 경로 보장)
- "두 그룹으로 나눌 수 있는가(친구는 다른 편)" → 이분 그래프 판별(2-coloring), BFS/DFS 둘 다 가능
- 재귀 깊이가 매우 깊어질 수 있는 경우(노드 수가 아주 많음) → 스택 오버플로우 방지를 위해 DFS보다 BFS 선호

## 3. 핵심 템플릿 코드

이미 폴더 안에 템플릿 파일이 있다: `bfs_template.java`, `dfs_template.java`

**BFS 템플릿**
```java
void bfs(int start, List<List<Integer>> graph, boolean[] visited) {
    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(start);
    visited[start] = true;

    while (!queue.isEmpty()) {
        int curr = queue.poll();
        for (int next : graph.get(curr)) {
            if (!visited[next]) {
                queue.offer(next);
                visited[next] = true;
            }
        }
    }
}
```

**DFS 템플릿**
```java
void dfs(int curr, List<List<Integer>> graph, boolean[] visited) {
    visited[curr] = true;
    for (int next : graph.get(curr)) {
        if (!visited[next]) {
            dfs(next, graph, visited);
        }
    }
}
```

**이분 그래프 판별 (2-coloring, BFS)**
```java
int[] color = new int[n]; // 0: 미방문, 1/2: 팀
for (int i = 0; i < n; i++) {
    if (color[i] != 0) continue;
    color[i] = 1;
    Queue<Integer> q = new ArrayDeque<>();
    q.offer(i);
    while (!q.isEmpty()) {
        int cur = q.poll();
        for (int next : graph[cur]) {
            if (color[next] == 0) {
                color[next] = (color[cur] == 1) ? 2 : 1;
                q.offer(next);
            } else if (color[next] == color[cur]) {
                return false; // 충돌 = 이분 그래프 아님
            }
        }
    }
}
return true;
```

**다익스트라용 Node (실전 idiom, `src/BOJ/Graph/P1753.java`)**
```java
class Node implements Comparable<Node> {
    int idx, cost;
    Node(int idx, int cost) { this.idx = idx; this.cost = cost; }
    public int compareTo(Node o) { return this.cost - o.cost; }
}
// dist[]는 Integer.MAX_VALUE로 초기화, PriorityQueue<Node>로 최소 비용 노드부터 꺼내며 갱신
```

**위상 정렬 (진입차수 기반)**
```java
int[] indegree = new int[n + 1];
// 간선 입력받으며 indegree[to]++
Queue<Integer> q = new LinkedList<>();
for (int i = 1; i <= n; i++) if (indegree[i] == 0) q.offer(i);
while (!q.isEmpty()) {
    int cur = q.poll();
    for (int next : graph.get(cur)) {
        if (--indegree[next] == 0) q.offer(next);
    }
}
```

## 4. 시간복잡도
정점 수 V, 간선 수 E일 때 BFS/DFS 모두 **O(V + E)** — 각 정점과 간선을 한 번씩만 방문/순회하기 때문.

## 5. 자주 하는 실수
- `visited` 체크를 큐/스택에 넣을 때 하지 않고 꺼낼 때 하면, 같은 노드가 중복으로 큐에 쌓여 비효율적이거나 틀릴 수 있음
- 사이클이 있는 그래프에서 `visited` 체크를 빼먹으면 무한 루프
- 이분 그래프 판별에서 "이미 방문한 노드인데 색이 같다"를 체크하지 않으면 홀수 사이클(삼각형 등)을 걸러내지 못함
- 그래프가 여러 컴포넌트(친구가 아예 없는 학생 등)로 나뉠 수 있으므로, 모든 시작점을 순회하며 미방문 노드마다 새로 탐색을 시작해야 함
- (`src/BOJ/Graph/P1753.java` 실사례) 다익스트라인지 확신이 안 서면 일단 "간선 가중치가 다르고 최단거리를 구한다"는 조건만 확인 — 코드 주석에도 "다익스트라 문제 인거 같은데"처럼 스스로 확신을 다지는 메모가 실제로 남아있음. 조건 체크리스트: 가중치 있음 + 음수 없음 + 최단거리 요구 → 다익스트라
- (`src/BOJ/Graph/P1238.java` 실사례) "모든 노드에서 특정 노드로 갔다가 돌아오는 왕복 최短거리"를 구할 때 다익스트라를 N번 돌리지 말고, **역방향 그래프(reverse graph)**를 하나 더 만들어 정방향/역방향 각 1번씩만 돌리는 트릭 사용
- (`src/BOJ/Graph/P1865.java` 실사례) 음수 가중치가 있으면 다익스트라 대신 벨만-포드 사용, 음수 사이클 존재 여부도 함께 판별해야 함

## 6. 이 폴더에서 푼 문제
- **P1** — 잠겨버린 사물함: 0번부터 DFS로 도달 가능한 락커를 표시하고, 못 연 락커 개수 반환 (`P1.java`)
- **P2** — 홍팀 청팀 나누기: 이분 그래프 판별(2-coloring)을 BFS로 구현 (`P2.java`)
- **P2_dfs** — P2와 동일 문제를 DFS로 재구현, BFS/DFS 결과와 로직이 동일함을 비교 (`P2_dfs.java`)
- **P3** — 잔돈 교환: 금액을 노드로 보는 암시적 그래프에서 BFS로 최소 동전 개수 탐색 (`implicitGraph`에 더 적합하지만 그래프 폴더에서 먼저 다룸, `P3.java`)

## 7. 참고: BOJ/Programmers 관련 문제
- **다익스트라**: `src/BOJ/Graph/P1753.java`(기본형), `src/BOJ/Graph/P1238.java`(정방향+역방향 그래프로 왕복 최短거리), `src/BOJ/DFSBFS/P1504.java`(경유지 2곳을 지나는 최短경로, 다익스트라 3회 결합)
- **벨만-포드(음수 가중치)**: `src/BOJ/Graph/P1865.java`(웜홀 — 음수 사이클 존재 여부 판별)
- **위상 정렬**: `src/BOJ/Graph/P2252.java`(줄 세우기), `src/BOJ/Graph/P1005.java`(ACM Craft, 진입차수 + 노드별 소요시간 배열 결합)
- **좌표평면 위 BFS**: `src/BOJ/Graph/P9205.java`(Point 클래스로 그래프 인덱스 대신 좌표 자체를 노드로 취급, 거리 조건으로 간선 판단)
- **비이분 그래프 관련 실전 예제는 이 폴더 BOJ에는 없음** — Inflearn P2/P2_dfs가 유일한 예시이므로 복습 시 이 두 파일을 우선 참고
