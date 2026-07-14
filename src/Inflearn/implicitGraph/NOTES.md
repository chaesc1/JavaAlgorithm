# 암시적 그래프 (implicitGraph)

## 1. 개념 요약
간선이 배열로 명시적으로 주어지지 않고, "상태 → 다음 상태로의 전이 규칙"으로 그래프가 즉석에서 정의되는 문제다. 예를 들어 "금액 → 동전 하나를 빼거나 더한 금액"처럼, 노드(상태)와 간선(전이)을 문제 조건에서 직접 만들어내야 한다. 탐색 방식 자체는 `graph` 폴더의 BFS/DFS와 동일하다.

## 2. 언제 쓰는가
- "최소 횟수/최소 개수로 어떤 상태에 도달"하는 문제 → 상태를 노드로 보는 BFS (모든 전이 비용이 1이면 최단 경로 = 최소 횟수)
- 퍼즐류(숫자 조합, 게임판 상태 변화)에서 "최소 이동으로 목표 상태에 도달 가능한가"
- 그래프가 인접 리스트로 주어지지 않고, 문제 설명 안에 "~를 하면 ~가 된다"는 규칙만 있을 때 → 그 규칙이 곧 간선

## 3. 핵심 템플릿 코드

**상태공간 BFS (잔돈 교환 예시 기준)**
```java
boolean[] visited = new boolean[amount + 1];
Queue<int[]> queue = new ArrayDeque<>(); // {현재 상태, 단계 수}

queue.add(new int[]{amount, 0});
visited[amount] = true;

while (!queue.isEmpty()) {
    int[] cur = queue.poll();
    int curAmount = cur[0];
    int count = cur[1];

    if (curAmount == 0) return count; // 목표 상태 도달

    for (int coin : coins) {
        int nextAmount = curAmount - coin; // 상태 전이 규칙
        if (nextAmount < 0) continue;
        if (!visited[nextAmount]) {
            visited[nextAmount] = true;
            queue.add(new int[]{nextAmount, count + 1});
        }
    }
}
return -1; // 도달 불가
```

**그리드 DFS 템플릿 (`dfs_template.java`, 4방향)**
```java
int[] dx = {-1, 1, 0, 0};
int[] dy = {0, 0, -1, 1};
void dfs(int x, int y, int[][] grid, boolean[][] visited) {
    visited[x][y] = true;
    for (int d = 0; d < 4; d++) {
        int nx = x + dx[d], ny = y + dy[d];
        if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length) continue;
        if (visited[nx][ny] || grid[nx][ny] != 1) continue;
        dfs(nx, ny, grid, visited);
    }
}
```

**멀티소스 BFS (`src/BOJ/DFSBFS/P7576.java` 토마토, 실전 idiom)**
```java
Queue<int[]> queue = new ArrayDeque<>();
for (int i = 0; i < n; i++)
    for (int j = 0; j < m; j++)
        if (box[i][j] == 1) queue.add(new int[]{i, j}); // 시작점이 여러 개!
// 이후 BFS는 단일 소스와 동일 — 큐에 여러 시작점을 미리 넣는 것만 다름
```

## 4. 시간복잡도
상태의 총 개수를 S, 상태 하나당 가능한 전이 수를 K라 하면 **O(S × K)**. 잔돈 교환 예시라면 S = amount, K = coins.length.

## 5. 자주 하는 실수
- `visited` 배열의 크기를 상태 범위(예: `amount + 1`)에 맞춰 정확히 잡아야 함 — 범위를 벗어난 상태를 인덱스로 접근하면 예외 발생
- 상태를 큐에 넣을 때 방문 처리를 안 하면 같은 상태가 여러 번 큐에 들어가 비효율적
- `HashSet<Integer>`로 방문 체크를 해도 되지만, 상태 범위가 정수로 고정돼 있으면 `boolean[]` 배열이 오토박싱 오버헤드 없이 더 빠름
- 값이 음수가 되거나 범위를 벗어나는 상태로 전이하는 경우를 빠짐없이 걸러야 함(`nextAmount < 0` 같은 경계 체크)
- (`src/BOJ/DFSBFS/P1103.java` 실사례) 상태 전이가 "칸에 적힌 값만큼 이동"처럼 순환할 수 있는 규칙이면 무한 루프에 빠질 수 있음 — 코드 주석에도 "게임을 되도록 오래 하고 싶다"는 고민이 남아있음. 사이클 감지(메모이제이션/visited)를 반드시 넣을 것
- (`src/BOJ/DFSBFS/P16953.java` 실사례) "완전탐색(순수 재귀)으로 되나? → 시간초과??"라는 자기 검토 주석처럼, 상태 전이 문제를 최短 횟수로 묻고 있다면 브루트포스 재귀 대신 BFS로 프레이밍을 바꿔야 TLE를 피할 수 있음
- 같은 문제를 BFS/DFS 둘 다로 풀어보면 어느 쪽이 더 적합한지 체감하기 좋음 — `src/BOJ/DFSBFS/P1012_BFS.java` vs `P1012_DFS.java`, `src/Programmers/level2/P1844.java`(DFS) vs `P1844_BFS.java`(BFS, 최단거리 보장)

## 6. 이 폴더에서 푼 문제
- **P1** — 구름의 개수(연결 요소 세기): 미방문 `1` 셀을 만날 때마다 BFS로 인접한 셀들을 전부 방문 처리하며 컴포넌트 개수를 카운트 (`P1.java`, DFS 버전도 주석으로 함께 남겨 비교)
- 잔돈 교환 문제는 여전히 `graph/P3.java`에 있음 — 상태공간 BFS라는 점에서 이 폴더 주제와 더 맞지만, 먼저 푼 순서상 graph에 남겨둠 (`dp/NOTES.md`에서도 같은 문제를 DP로 재도전할 예정이라 교차 참조됨)

## 7. 참고: BOJ/Programmers 관련 문제
- **그리드 BFS/DFS (가장 흔한 패턴)**: `src/BOJ/DFSBFS/P2178.java`(미로), `P2667.java`/`P2667_다시.java`(단지번호붙이기, 재도전 버전 비교), `P1926.java`(그림 영역), `P2583.java`(영역 구하기)
- **멀티소스 BFS**: `src/BOJ/DFSBFS/P7576.java`(토마토)
- **3D 그리드**: `src/BOJ/DFSBFS/P6593.java`(dx/dy/dz 6방향)
- **말/기물 이동형 암시적 그래프**: `src/BOJ/DFSBFS/P7562.java`(나이트의 이동, 8방향 오프셋)
- **상태공간 BFS 두 변형 비교**: `src/BOJ/DFSBFS/P13549_queue.java`(0-1 BFS류, 일반 큐) vs `P13549_priorityQueue.java`(다익스트라식 PQ) — 같은 문제를 두 방식으로 풀어 성능/구현 차이를 비교하기 좋음
- **사이클 위험이 있는 상태 전이**: `src/BOJ/DFSBFS/P1103.java`, `P16953.java`
- **인접행렬 → 인접리스트 리팩터링 사례**: `src/BOJ/DFSBFS/P2606.java`(행렬) → `P2606_ArrayListADJ.java`(리스트로 리팩터링) — 같은 로직, 자료구조만 바꾼 비교
- **BFS vs DFS 같은 문제 비교**: `src/BOJ/DFSBFS/P1012_BFS.java`/`P1012_DFS.java`, `src/Programmers/level2/P1844.java`/`P1844_BFS.java`
