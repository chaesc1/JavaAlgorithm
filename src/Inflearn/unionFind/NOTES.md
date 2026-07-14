# 유니온 파인드 / 분리집합 (unionFind)

## 1. 개념 요약
여러 원소를 그룹(집합)으로 묶고, "두 원소가 같은 그룹인지", "두 그룹을 합쳐라"를 빠르게 처리하는 자료구조다. `find()`(루트 찾기)와 `union()`(두 집합 합치기) 두 연산이 핵심이며, 경로 압축(path compression)과 랭크(rank/size) 기반 합치기를 쓰면 거의 O(1)에 가까운 속도가 나온다. 크루스칼 최소 신장 트리 알고리즘의 핵심 구성요소이기도 하다.

## 2. 언제 쓰는가
- "두 원소가 같은 그룹/네트워크에 속해 있는가"를 반복적으로 물어볼 때
- "간선을 하나씩 추가하며 사이클이 생기는지 판단" (크루스칼 MST)
- 친구 관계, 네트워크 연결 여부처럼 그래프 BFS/DFS로도 풀리지만 **동적으로 간선이 추가되는 상황**에서는 매번 그래프 탐색보다 유니온 파인드가 효율적
- "몇 개의 그룹으로 나뉘는가"를 구해야 할 때

## 3. 핵심 템플릿 코드

```java
int[] parent;

void init(int n) {
    parent = new int[n];
    for (int i = 0; i < n; i++) parent[i] = i; // 처음엔 자기 자신이 루트
}

int find(int x) {
    if (parent[x] == x) return x;
    return parent[x] = find(parent[x]); // 경로 압축
}

void union(int a, int b) {
    int rootA = find(a);
    int rootB = find(b);
    if (rootA != rootB) parent[rootA] = rootB;
}

boolean isSameGroup(int a, int b) {
    return find(a) == find(b);
}
```

**크루스칼 MST와 결합하는 흐름 (참고용 의사코드)**
```java
Arrays.sort(edges, (a, b) -> a[2] - b[2]); // 가중치 오름차순
for (int[] edge : edges) {
    int a = edge[0], b = edge[1];
    if (find(a) != find(b)) {
        union(a, b);
        // 이 간선을 MST에 포함
    }
}
```

## 4. 시간복잡도
경로 압축 + 랭크 합치기를 둘 다 적용하면 연산당 **거의 O(1)**(정확히는 O(α(n)), 애커만 역함수로 사실상 상수). 경로 압축만 해도 실전에서는 충분히 빠르다.

## 5. 자주 하는 실수
- `find()`에서 경로 압축(`parent[x] = find(parent[x])`)을 빼먹으면 트리가 한쪽으로 길어져서 O(n)까지 느려질 수 있음
- `union()`에서 루트끼리 비교 안 하고 원소 자체를 비교(`a != b`)하면 이미 같은 그룹인데도 잘못 합치는 경우가 생김
- 초기화(`parent[i] = i`)를 빼먹고 바로 `find()`를 호출하면 NPE 또는 잘못된 결과
- 그래프 문제인데 간선이 정적으로 다 주어져 있으면 BFS/DFS로도 충분한데, 굳이 유니온 파인드를 써야 하는지 먼저 판단할 것 (동적 추가/삭제가 없으면 BFS/DFS가 더 직관적일 수 있음)
- **`parent[]` 배열이 있다고 다 유니온 파인드가 아님** — `src/BOJ/DFSBFS/P1068.java`, `src/BOJ/DFSBFS/P11725.java`는 입력에서 주어진 트리 부모를 그대로 저장하는 **트리 부모 포인터 배열**이지, `find`/`union` 연산이 있는 분리집합이 아니다. 이름만 보고 착각하기 쉬운 실제 사례이니 구분할 것

## 6. 이 폴더에서 푼 문제
아직 문제 없음 (TODO)

## 7. ⚠️ 이 저장소에는 실제 유니온 파인드 예제가 없음
`src/BOJ/Graph`와 `src/BOJ/DFSBFS` 전체(56개 파일)를 `parent[`, `find(`, `union(`, `rank[`, `Disjoint` 등으로 뒤져봤지만 경로 압축/union-by-rank가 들어간 진짜 분리집합 구현이 하나도 없다. 위에 적은 "parent[] 배열이지만 유니온 파인드 아님" 사례가 오히려 헷갈릴 수 있는 유일한 근접 예시다.

**추천 액션**: 이 폴더는 코드 기반이 완전히 비어있으니, 아래 문제로 최소 2~3개는 직접 채워둘 것.
- 백준 1717 (집합의 표현) — 가장 기본적인 union-find 뼈대 연습
- 백준 1976 (여행가자) — 그래프 연결 여부를 union-find로 판별
- 백준 4386 (별자리 만들기) — 크루스칼 MST + union-find 결합
