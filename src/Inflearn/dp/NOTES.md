# 동적 계획법 (dp)

## 1. 개념 요약
큰 문제를 작은 부분 문제로 쪼개고, 그 부분 문제의 답을 저장(메모이제이션)해서 재사용하는 기법이다. 완전탐색과 달리 **중복 계산을 제거**하는 것이 핵심이며, "최적 부분구조"(부분 문제의 최적해로 전체 최적해를 구성 가능)와 "중복 부분 문제"(같은 계산이 여러 번 반복됨) 두 조건을 만족할 때 적용 가능하다.

## 2. 언제 쓰는가
- "최소/최대 ~을 구하라"인데 완전탐색으로는 시간초과가 나는 경우 (동전 교환 최소 개수, 배낭 문제 등)
- "경우의 수를 구하라" (계단 오르기, 타일 채우기)
- 재귀로 풀었을 때 같은 인자로 함수가 여러 번 호출되는 게 보이는 경우 → 메모이제이션 추가
- 순서가 있는 데이터에서 "이전까지의 최적값"을 기준으로 현재 값을 결정할 수 있을 때 (LIS, 배낭)

## 3. 핵심 템플릿 코드

**1차원 DP (동전 교환 최소 개수 예시)**
```java
int[] dp = new int[amount + 1];
Arrays.fill(dp, Integer.MAX_VALUE);
dp[0] = 0;

for (int i = 1; i <= amount; i++) {
    for (int coin : coins) {
        if (coin <= i && dp[i - coin] != Integer.MAX_VALUE) {
            dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        }
    }
}
```

**2차원 DP (0/1 배낭 문제)**
```java
int[][] dp = new int[n + 1][capacity + 1];
for (int i = 1; i <= n; i++) {
    for (int w = 0; w <= capacity; w++) {
        dp[i][w] = dp[i - 1][w]; // i번째 물건을 안 넣는 경우
        if (weight[i] <= w) {
            dp[i][w] = Math.max(dp[i][w], dp[i - 1][w - weight[i]] + value[i]); // 넣는 경우
        }
    }
}
```

**최장 증가 부분수열 (LIS, O(n²))**
```java
int[] dp = new int[n];
Arrays.fill(dp, 1);
for (int i = 1; i < n; i++) {
    for (int j = 0; j < i; j++) {
        if (arr[j] < arr[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
    }
}
```

**Top-down 메모이제이션 (`src/BOJ/DynamicProgramming/P11726.java` 실전 idiom)**
```java
static int[] d = new int[1001]; // 0 = 미계산 sentinel
int dp(int n) {
    if (n <= 2) return n;
    if (d[n] != 0) return d[n]; // 이미 계산됨
    return d[n] = dp(n - 1) + dp(n - 2);
}
```

**무한 배낭(동전 개수 세기) 루프 순서 (`src/BOJ/DynamicProgramming/P9084.java`)**
```java
int[] dp = new int[amount + 1];
dp[0] = 1;
for (int coin : coins) {       // 코인을 바깥 루프에 둬야 조합(순서 무시) 카운트가 됨
    for (int j = coin; j <= amount; j++) {
        dp[j] += dp[j - coin];
    }
}
```

## 4. 시간복잡도
- 1차원 DP: 상태 수 × 전이 수, 동전 교환 예시는 O(amount × coins.length)
- 2차원 DP(배낭): O(n × capacity)
- LIS(기본 DP): O(n²) — 이분탐색 최적화 시 O(n log n)까지 줄일 수 있음

## 5. 자주 하는 실수
- DP 배열의 초기값 설정을 빠뜨림 (`dp[0]` 같은 기저 상태를 안 정해주면 전체가 틀어짐)
- 배낭 문제에서 반복문 순서를 잘못 잡아 "물건을 여러 번 사용"하게 됨 (0/1 배낭은 물건 루프를 바깥에, 무한 배낭은 용량 루프를 바깥에 두는 식으로 구분 필요)
- 점화식을 세우지 않고 바로 코드부터 짜려다 막힘 — 종이에 `dp[i]`가 무엇을 의미하는지 먼저 정의하고 시작할 것
- 메모이제이션 없이 재귀만 짜서 완전탐색과 다를 바 없는 시간복잡도가 나오는 경우 (Top-down 방식이면 `Integer[] memo` 캐시 필수)
- (`src/BOJ/DynamicProgramming/P11726.java` 등 실사례) `d[n] != 0`을 "계산됨" sentinel로 쓰는 패턴은 **dp 값 자체가 0이 될 수 있는 문제에서는 깨짐** — 0이 유효한 답일 가능성이 있다면 별도의 `boolean[] visited` 캐시를 두거나 -1을 sentinel로 쓸 것
- (`src/BOJ/DynamicProgramming/P9251.java` vs `P9252.java` 실사례) 둘 다 LCS(최장 공통 부분수열)인데 `P9252`는 `dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1])` else 분기가 주석 처리된 채 미완성으로 남아있음 — `P9251`의 완성본과 나란히 비교하면 LCS 점화식의 "일치 안 할 때" 분기를 놓치기 쉽다는 걸 바로 확인 가능
- (`src/BOJ/DynamicProgramming/P9095.java`, `P9461.java` 실사례) 값이 빠르게 커지는 수열(트리보나치, 파도반)은 `int[]` 대신 처음부터 `long[]`로 선언

## 6. 이 폴더에서 푼 문제
아직 문제 없음 (TODO) — 참고: 동전 교환 최소 개수는 현재 BFS(`graph/P3.java`)로 풀려 있음. DP 버전은 이 폴더에서 별도로 풀어볼 것.

## 7. 참고: BOJ/Programmers 관련 문제
- **Top-down 메모이제이션(0-sentinel)**: `src/BOJ/DynamicProgramming/P11726.java`, `P11727.java`
- **1D bottom-up + overflow 대비**: `src/BOJ/DynamicProgramming/P9095.java`, `P9461.java`
- **2D 누적합형 DP**: `src/BOJ/DynamicProgramming/P11660.java`(구간 합, `map[i][j]=map[i][j-1]+val`)
- **0/1 배낭(top-down) vs 무한 배낭 개수 세기(bottom-up)**: `src/BOJ/DynamicProgramming/P12865.java` vs `P9084.java` — 루프 순서 차이를 비교하기 좋은 쌍
- **LCS 완성본 vs 미완성 비교**: `src/BOJ/DynamicProgramming/P9251.java` ↔ `P9252.java`
- **집 색칠/비인접 최대합류**: `src/BOJ/DynamicProgramming/P9465.java`, `P17404.java`(3색 페인트, 시작 색 3가지를 각각 시도)
- **조합론 + mod 연산**: `src/BOJ/DynamicProgramming/P2225.java`
