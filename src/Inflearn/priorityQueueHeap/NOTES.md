# 우선순위 큐 / 힙 (priorityQueueHeap)

## 1. 개념 요약
항상 "가장 크거나 가장 작은 원소"를 O(log n)에 꺼낼 수 있는 자료구조다. Java의 `PriorityQueue`는 내부적으로 힙(이진 트리 기반)으로 구현되어 있다. "정렬된 전체 순서"는 필요 없고 "지금 가장 우선순위 높은 것 하나만" 반복적으로 필요할 때 정렬(O(n log n) 1회)보다 유리하다. 다익스트라 최단경로, K번째 최댓값, 작업 스케줄링 등에 쓰인다.

## 2. 언제 쓰는가
- "매번 최솟값/최댓값을 꺼내서 처리하고, 처리 결과를 다시 넣어야 한다" (예: 두 파일 합치기 최소 비용)
- "K번째로 크거나 작은 값을 구하라" → 크기 K로 제한된 힙 유지
- 그래프에서 "지금까지 알려진 최단 거리가 가장 짧은 노드부터 방문" → 다익스트라
- 데이터가 계속 들어오는데 그때그때 최솟값/최댓값만 필요한 스트리밍 상황

## 3. 핵심 템플릿 코드

**기본 사용법 (최소 힙 / 최대 힙)**
```java
PriorityQueue<Integer> minHeap = new PriorityQueue<>();               // 기본은 최소 힙
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙

minHeap.offer(5);
minHeap.offer(1);
minHeap.poll(); // 1 (가장 작은 값)
```

**커스텀 Comparator (예: 다익스트라에서 {노드, 거리} 쌍을 거리 기준으로)**
```java
PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // 거리 오름차순
pq.offer(new int[]{start, 0});

while (!pq.isEmpty()) {
    int[] cur = pq.poll();
    int node = cur[0], dist = cur[1];
    if (dist > distArr[node]) continue; // 이미 더 짧은 경로로 처리된 노드면 스킵
    for (int[] edge : graph.get(node)) {
        int next = edge[0], weight = edge[1];
        if (dist + weight < distArr[next]) {
            distArr[next] = dist + weight;
            pq.offer(new int[]{next, dist + weight});
        }
    }
}
```

**이중 힙 + 지연 삭제 (`src/BOJ/PriorityQueue/P7662.java` 실전 idiom)**
```java
PriorityQueue<Integer> minPQ = new PriorityQueue<>();
PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
Map<Integer, Integer> count = new HashMap<>(); // 값별 유효 개수(지연 삭제용 카운터)

// 삭제 시: 힙 top이 count에 남아있는 값이 될 때까지 그냥 버리며 poll
int popValid(PriorityQueue<Integer> pq) {
    while (!pq.isEmpty() && count.getOrDefault(pq.peek(), 0) <= 0) pq.poll();
    int v = pq.poll();
    count.put(v, count.get(v) - 1);
    return v;
}
// Java PriorityQueue는 임의 원소 O(log n) 삭제를 지원하지 않으므로
// "삭제됐다고 표시만 해두고, 나중에 top에서 만나면 그때 버리는" 방식으로 우회
```

## 4. 시간복잡도
- 삽입(`offer`)/삭제(`poll`): O(log n)
- n개를 모두 넣고 빼면 O(n log n) — 정렬과 동일한 오더지만, "일부만 꺼내면 되는" 경우엔 정렬보다 유리
- 다익스트라: O((V + E) log V)

## 5. 자주 하는 실수
- 기본 `PriorityQueue`는 최소 힙이라는 걸 잊고 최댓값이 필요한 문제에 그대로 써서 반대 결과가 나옴 — `Collections.reverseOrder()` 또는 Comparator로 반대로 정렬
- 다익스트라에서 "큐에서 꺼낸 거리가 이미 알고 있는 최단 거리보다 크면 스킵" 처리를 안 하면 중복 계산으로 느려지거나 틀림
- 힙에 넣은 후 값이 바뀌어도 힙 내부에서 자동으로 재정렬되지 않음 (Java `PriorityQueue`는 감소 키 갱신을 지원하지 않으므로, 갱신이 필요하면 새로 넣고 오래된 것은 꺼낼 때 걸러내는 방식(lazy deletion)을 씀)
- Comparator에서 `a[1] - b[1]`처럼 뺄셈 비교 시 오버플로우 가능성 — 값이 클 수 있으면 `Integer.compare()` 권장
- (`src/BOJ/Graph/P1197.java` 실사례) `Node implements Comparable`로 PQ를 쓰는 코드가 전부 다익스트라는 아님 — 같은 idiom이 **프림(Prim) MST**에도 그대로 쓰인다. "PQ에서 뭘 꺼내는가"(거리 vs 간선 가중치)로 구분할 것
- `Collections.reverseOrder()`와 `Comparator.reverseOrder()`가 저장소 안에서 혼용되고 있음(`P11279`는 전자, Programmers 쪽은 후자) — 기능은 동일하니 한쪽으로 통일해서 쓰는 습관을 들이면 좋음

## 6. 이 폴더에서 푼 문제
아직 문제 없음 (TODO)

## 7. 참고: BOJ/Programmers 관련 문제
- **기본 최대힙**: `src/BOJ/PriorityQueue/P11279.java`
- **이중 힙 + 지연삭제**: `src/BOJ/PriorityQueue/P7662.java`, `src/Programmers/level3/P42628.java`(이중우선순위큐, 동일 idiom)
- **다익스트라 Node/Comparable**: `src/BOJ/Graph/P1753.java`, `P1238.java`, `P1504.java`(경유지 2곳)
- **PQ가 MST(프림)에 재사용되는 사례**: `src/BOJ/Tree/P1197.java`
- **0-1 BFS vs PQ 기반 다익스트라 비교**: `src/BOJ/DFSBFS/P13549_queue.java` vs `P13549_priorityQueue.java`
- **PQ + DFS 조합**: `src/Programmers/level3/P43164.java`(여행경로, 사전순 보장을 위해 PQ 사용)
- **top-k/그리디용 힙**: `src/Programmers/level3/P12927.java`, `P12987.java`, `src/Programmers/level2/P42587.java`
