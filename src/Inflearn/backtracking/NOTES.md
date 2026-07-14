# 백트래킹 (backtracking)

## 1. 개념 요약
완전탐색(`exhaustiveSearch`)과 구조는 같지만, **더 이상 답이 될 수 없는 가지를 조기에 쳐내는(가지치기, pruning)** 것이 핵심이다. 모든 경우를 다 만들고 나서 걸러내는 게 아니라, 탐색 도중 조건을 어기는 순간 그 가지를 포기하고 되돌아간다(백트래킹). N-Queen, 스도쿠, 순열 중 조건을 만족하는 것만 찾기 등에 쓰인다.

## 2. 언제 쓰는가
- 완전탐색으로 접근은 가능한데, 그대로 다 돌리면 시간초과가 날 것 같을 때 → 중간에 불가능한 조건을 미리 체크해서 가지치기
- "조건을 만족하는 배치를 찾아라" (N-Queen: 같은 행/열/대각선에 놓이면 안 됨)
- 재귀 도중 "지금까지의 선택으로 이미 조건을 위반했다"는 걸 판단할 수 있는 문제

## 3. 핵심 템플릿 코드

**가지치기가 있는 완전탐색 (완전탐색 템플릿에 조건 체크 추가)**
```java
void dfs(int depth, int[] state, boolean[] used) {
    if (!isPromising(depth, state)) return; // 가지치기: 여기서 더 가도 답이 안 됨

    if (depth == n) {
        // 정답 후보 처리
        return;
    }
    for (int i = 0; i < n; i++) {
        if (used[i]) continue;
        used[i] = true;
        state[depth] = i;
        dfs(depth + 1, state, used);
        used[i] = false; // 되돌리기 (백트래킹의 핵심)
    }
}
```

**N-Queen 스타일 가지치기 예시**
```java
boolean isPromising(int row, int[] cols) {
    for (int prevRow = 0; prevRow < row; prevRow++) {
        int prevCol = cols[prevRow];
        if (prevCol == cols[row]) return false;                         // 같은 열
        if (Math.abs(prevCol - cols[row]) == row - prevRow) return false; // 같은 대각선
    }
    return true;
}
```

**조기 종료 트릭 (`src/BOJ/BackTracking/P2580.java` 스도쿠, `System.exit(0)`)**
```java
void dfs(int depth) {
    if (depth == blanks.size()) {
        print();
        System.exit(0); // 답 하나 찾으면 전체 프로세스 즉시 종료 — 남은 재귀 스택 다 버림
    }
    for (int v = 1; v <= 9; v++) {
        if (!isPossible(v)) continue;
        place(v);
        dfs(depth + 1);
        remove(v);
    }
}
```

## 4. 시간복잡도
최악의 경우 완전탐색과 동일한 지수 시간(O(n!) 또는 O(2^n))이지만, 가지치기가 잘 되면 실제 탐색하는 노드 수가 크게 줄어든다. 정확한 상한을 구하기보다는 "가지치기 없이는 시간초과가 나는지"를 먼저 가늠하는 게 실전에 가깝다.

## 5. 자주 하는 실수
- 가지치기 조건을 재귀 진입 후(깊은 곳)에서 체크해서, 이미 낭비한 탐색이 많은 경우 — 가능하면 선택 직후 바로 체크
- 상태 복구(백트래킹)를 깜빡해서 형제 가지가 이전 가지의 상태를 물려받아 틀리는 경우 (`exhaustiveSearch`에서도 같은 실수가 흔함)
- 완전탐색과 구분 없이 그냥 "다 돌리고 나중에 필터링"하면 백트래킹의 이점(조기 종료)을 못 살림
- (`src/BOJ/BackTracking/P1759.java` 실사례) **base case 처리 후 `return`을 빠뜨리는 버그** — `if (idx == L) { ... }` 블록이 끝나고도 바로 아래 `for` 루프로 코드가 흘러 들어가 불필요하게 더 깊이 재귀함. base case 블록 끝에는 항상 `return`이 있는지 확인할 것
- (`src/BOJ/BackTracking/P15663.java` vs `P15666.java` 실사례) 값 중복을 걸러낼 때 `back`(직전에 사용한 값)을 기준으로 스킵하는 로직이 미묘하게 다름 — `P15663`은 매번 `0`부터 다시 스캔, `P15666`은 `start`부터 스캔. "순서가 다르면 다른 결과로 치는지"를 문제별로 정확히 구분해야 함
- (`src/BOJ/BackTracking/P16198.java` 실사례) `visited[]` 배열 대신 `ArrayList`에서 직접 `remove`/`add(index, val)`로 상태를 되돌리는 방식도 가능 — 두 idiom을 모두 알아두면 문제에 따라 더 간결한 쪽을 고를 수 있음

## 6. 이 폴더에서 푼 문제
아직 문제 없음 (TODO)

## 7. 참고: BOJ/Programmers 관련 문제
- **순열/조합 템플릿 계열 비교**: `src/BOJ/BackTracking/P15654.java`(순열, `visited[]`), `P15657.java`(중복조합, `start` 인덱스 그대로 전달), `P15663.java`/`P15666.java`(중복 제거 방식 비교) — 4개를 나란히 비교하면 "뼈대는 같고 조건만 다름"이 명확히 보임
- **제약 기반 가지치기**: `src/BOJ/BackTracking/P9663.java`(N-Queen, 대각선 체크 공식), `P2580.java`(스도쿠, 조기 종료)
- **부분집합/분할 + 조기 종료**: `src/BOJ/BackTracking/P14889.java`(팀 나누기, 차이가 0이면 즉시 종료), `P16198.java`(ArrayList 기반 undo)
- **Programmers 백트래킹/DFS**: `src/Programmers/level3/P43164.java`(여행경로, PQ로 사전순 보장), `src/Programmers/level3/P64064.java`(부분집합 DFS + Set 중복제거)
