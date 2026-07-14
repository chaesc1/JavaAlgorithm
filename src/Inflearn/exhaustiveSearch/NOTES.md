# 완전탐색 (exhaustiveSearch)

## 1. 개념 요약
가능한 모든 경우의 수를 빠짐없이 시도해보며 답을 찾는 기법이다. 주로 재귀(DFS)로 구현하며, "선택 → 재귀 호출 → 선택 취소(백트래킹)"의 반복 구조를 가진다. 완전탐색은 백트래킹의 기초이자 그 자체로 정답 후보를 나열하는 문제(순열, 조합, 부분집합)에 쓰인다.

## 2. 언제 쓰는가
- 데이터 크기가 작다 (n ≤ 15~20 수준) → 모든 경우를 다 봐도 시간 내에 끝남
- "가능한 모든 조합/순열/부분집합을 구하라"
- "최댓값/최솟값이 되는 조합을 찾아라" (예: 최대한 많은 나라를 여행할 수 있는 경로)
- 그리디나 DP로 점화식을 세우기 애매할 때 우선 완전탐색으로 접근 가능한지 검토

## 3. 핵심 템플릿 코드

**조합 (순서 상관없이 m개 선택)**
```java
void dfs(int[] arr, int m, int start, List<Integer> curr, List<List<Integer>> res) {
    if (curr.size() == m) {
        res.add(new ArrayList<>(curr));
        return;
    }
    for (int i = start; i < arr.length; i++) {
        curr.add(arr[i]);
        dfs(arr, m, i + 1, curr, res); // i+1: 자기 자신 재사용 안 함
        curr.remove(curr.size() - 1);
    }
}
```

**순열 (순서 상관있게 m개 선택)**
```java
void dfs(int[] arr, int m, List<Integer> curr, boolean[] visited, List<List<Integer>> res) {
    if (curr.size() == m) {
        res.add(new ArrayList<>(curr));
        return;
    }
    for (int i = 0; i < arr.length; i++) {
        if (visited[i]) continue;
        visited[i] = true;
        curr.add(arr[i]);
        dfs(arr, m, curr, visited, res);
        curr.remove(curr.size() - 1);
        visited[i] = false;
    }
}
```

**부분집합 (선택/미선택 이진 트리)**
```java
void dfs(int[] arr, int idx, List<Integer> curr, List<List<Integer>> res) {
    if (idx == arr.length) {
        res.add(new ArrayList<>(curr));
        return;
    }
    dfs(arr, idx + 1, curr, res); // 선택 안 함
    curr.add(arr[idx]);
    dfs(arr, idx + 1, curr, res); // 선택함
    curr.remove(curr.size() - 1);
}
```

## 4. 시간복잡도
- 조합: O(C(n, m) × m) — 경우의 수 × 각 경우 처리 비용
- 순열: O(n! / (n-m)!)
- 부분집합: O(2^n)
- 완전탐색은 지수적으로 커지므로 n이 커지면(20 초과) 반드시 가지치기(백트래킹)나 DP로 전환을 고려해야 함

## 5. 자주 하는 실수
- 조합에서 `start` 대신 `0`부터 돌리면 순열이 되어버림 (중복/순서 문제)
- 순열에서 `visited` 배열 리셋을 안 하면 다음 재귀에서 잘못된 상태로 진행됨
- 재귀 후 상태 복구(`remove`, `visited[i] = false`)를 빠뜨리면 다른 가지에 영향을 줌
- 합/개수를 리스트에 매번 다시 계산하면 비효율적 — `sum`을 파라미터로 들고 다니는 게 낫다 (`ex2` vs `ex2_2` 비교)
- (`src/BOJ/BruteForce/P1018.java` 실사례) `Boolean[][]` 같은 박싱 타입을 큰 그리드에 쓰면 불필요한 오토박싱 비용 발생 — `boolean[][]` 프리미티브 사용
- (`src/BOJ/BruteForce/P19532.java` 실사례) 두 방정식을 크래머 공식류로 풀 때 분모가 0이 될 수 있는 경우(두 직선이 평행) 체크 없이 나눗셈하면 위험 — 입력 제약으로 안전하다고 확신할 수 없다면 방어 코드나 최소한 주석을 남길 것
- (`src/BOJ/BruteForce/P2231.java`, 스텁) 입력만 읽고 로직이 비어있는 미완성 파일 — 완전탐색 폴더에서도 "일단 스켈레톤만 세팅"하고 미룬 문제가 있었다는 기록

## 6. 이 폴더에서 푼 문제
- **ex1** — 두 수의 합이 target: 이중 for문 완전탐색 O(n²) (`ex1.java`)
- **ex2** — 배열에서 m개를 뽑아 합이 target인지: 리스트에 넣고 매번 합을 다시 계산하는 재귀 (`ex2.java`)
- **ex2_2** — ex2와 동일 문제, `sum`을 파라미터로 들고 다니며 매번 재계산하지 않도록 개선 (`ex2_2.java`)
- **ex3** — m개를 뽑아 순서를 고려한 배열(순열) 생성, `visited` 배열로 O(n) 중복 체크 (`ex3.java`)
- **ex4** — m개를 뽑는 조합 생성 (`ex4.java`)
- **ex5** — 전체 부분집합 생성 (선택/미선택 방식) (`ex5.java`)
- **P1** — 여행자 잔고로 최대한 많은 나라 여행하기: 방문 배열로 조합을 시도하며 최댓값 갱신 (`P1.java`)

## 7. 참고: BOJ/Programmers 관련 문제
- **범위 전수조사(수치)**: `src/BOJ/BruteForce/P1107.java`(채널 0~999999 전부 시도), `src/BOJ/BruteForce/P1747.java`(2씩 증가시키며 소수+회문 체크)
- **try/undo 방식 브루트포스**: `src/BOJ/BruteForce/P3085.java` — 인접 스왑 → 최대 연속 구간 탐색 → 다시 스왑 원복. 백트래킹처럼 보이지만 실제로는 상태를 하나씩 되돌리는 단순 완전탐색
- **DFS로 조합적 열거**: `src/BOJ/BruteForce/P14500.java`(테트로미노, 4방향 DFS + 특수 도형은 오프셋 테이블로 별도 처리), `src/Programmers/level2/P43165.java`(타겟 넘버, +/- 두 갈래 DFS)
- **재귀 분할(divide & conquer 성격의 재귀)**: `src/BOJ/recursive/P2447.java`(별찍기, 3x3 블록 재귀 분할), `src/BOJ/recursive/P4779.java`(칸토어 집합), `src/BOJ/recursive/P24060.java`(병합정렬 도중 K번째 원소 추적, 버퍼 재사용으로 재할당 방지)
- **참고**: `src/BOJ/DivisionalConquest`(분할정복 3문제, `P1629.java` 빠른 거듭제곱)도 재귀 감각을 넓히는 데 도움됨
