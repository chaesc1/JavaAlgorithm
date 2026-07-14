# 그리디 (greedy)

## 1. 개념 요약
매 단계마다 "지금 당장 최선으로 보이는 선택"을 반복해서 전체 최적해에 도달하는 기법이다. DP처럼 모든 경우를 저장하지 않고 한 번의 선택으로 넘어가기 때문에 빠르지만, **문제가 그리디로 풀리는지(탐욕적 선택 속성 + 최적 부분구조를 만족하는지)를 먼저 증명/직관적으로 확인**해야 한다. 안 그러면 반례에서 틀린다.

## 2. 언제 쓰는가
- "정렬 후 앞에서부터/뒤에서부터 순서대로 처리하면 되는가"를 먼저 의심 (그리디 문제의 8할은 정렬 + 순차 선택)
- "겹치지 않는 구간을 최대한 많이 선택" → 활동 선택 문제(끝나는 시간 기준 정렬)
- "동전 단위가 배수 관계"처럼 특정 구조가 있어 큰 단위부터 채워도 최적인 경우 → 그리디 거스름돈
- 반례가 잘 안 떠오르고, 매 순간의 선택이 이후 선택에 영향을 주지 않는 것처럼 보일 때

## 3. 핵심 템플릿 코드

**활동 선택 문제 (겹치지 않는 구간 최대 개수)**
```java
Arrays.sort(intervals, (a, b) -> a[1] - b[1]); // 끝나는 시간 기준 정렬

int count = 0;
int lastEnd = Integer.MIN_VALUE;
for (int[] interval : intervals) {
    if (interval[0] >= lastEnd) { // 겹치지 않으면 선택
        count++;
        lastEnd = interval[1];
    }
}
```

**그리디 거스름돈 (단위가 배수 관계일 때만 유효)**
```java
int[] coins = {500, 100, 50, 10}; // 큰 단위부터
int count = 0;
for (int coin : coins) {
    count += amount / coin;
    amount %= coin;
}
```

**PQ로 최소 쌍 합치기 (`src/BOJ/Greedy/P1715.java` 카드 정렬 실사례)**
```java
PriorityQueue<Long> pq = new PriorityQueue<>();
for (int c : cards) pq.offer((long) c);
long total = 0;
while (pq.size() > 1) {
    long merged = pq.poll() + pq.poll(); // 가장 작은 두 개를 합치는 게 항상 유리
    total += merged;
    pq.offer(merged);
}
```

**비트 트릭 그리디 (`src/BOJ/Greedy/P1052.java` — 최소 집합 개수로 만들기)**
```java
while (Integer.bitCount(n) > k) {
    n += n & (-n); // 가장 낮은 set bit를 없애는 대신 그 다음 자리로 합침
}
```

## 4. 시간복잡도
대부분 정렬이 병목이므로 **O(n log n)**, 정렬 이후 선형 순회는 O(n). PQ 기반 그리디(쌍 합치기)는 원소마다 삽입/삭제가 O(log n)이므로 전체 **O(n log n)**.

## 5. 자주 하는 실수
- 그리디가 항상 최적해를 보장하지 않는데도 "일단 정렬하고 순서대로 고르면 되겠지"라고 검증 없이 적용 — 동전 단위가 배수 관계가 아니면(`[1,3,4]`, target=6 같은 경우) 그리디 거스름돈은 틀림. 이런 경우는 DP로 풀어야 함
- 정렬 기준을 잘못 잡음 (활동 선택은 시작 시간이 아니라 **끝나는 시간** 기준 정렬이 핵심)
- 그리디로 접근하기 전에 작은 반례를 직접 만들어 검증하는 습관이 필요함
- (`src/BOJ/Greedy/P2141.java` 실사례) 문제를 "거리의 합"으로 오독하기 쉬운데 실제로는 "각 사람까지의 거리의 합"이 조건 — 코드 주석에도 직접 "거리의 합이 아니라 각 사람까지의 거리의 합임에 유의"라고 남겨둔 사례. 그리디는 문제를 정확히 읽어야 정렬 기준을 제대로 잡을 수 있음(이 문제는 가중 중앙값 패턴)
- (`src/BOJ/Greedy/P1911.java`, `P2141.java` 실사례) 누적합/좌표 값이 int 범위를 넘을 수 있으면 그리디 누적 변수는 처음부터 `long`으로 선언할 것
- (`src/BOJ/Greedy/P1202.java`, `P2138.java`, 스텁) 로직이 비어있는 미완성 파일 — 그리디 폴더에서도 손대지 않은 문제가 있었다는 기록
- (`src/BOJ/Greedy/P4796.java` 실사례) 반복 시뮬레이션 대신 `(V/P)*L + Math.min(V%P, L)` 같은 닫힌 형태(closed-form) 공식으로 유도하면 훨씬 빠르고 간결함 — 그리디 문제를 풀 때 "반복문으로 시뮬레이션 vs 수식으로 직접 계산" 둘 다 고려해볼 것

## 6. 이 폴더에서 푼 문제
아직 문제 없음 (TODO)

## 7. 참고: BOJ/Programmers 관련 문제
- **PQ 최소쌍합치기**: `src/BOJ/Greedy/P1715.java`, `P13975.java`(동일 로직, `long` 오버플로 방지판), `P1744.java`(양/음수 분리 + 1은 특수처리)
- **구간 스케줄링**: `src/BOJ/Greedy/P1931.java`(끝나는시간→시작시간 정렬, sorting 폴더와 교차 참고)
- **투포인터형 구간 커버링**: `src/BOJ/Greedy/P1911.java`(포트홀, `% L` 나머지 연산으로 채우기)
- **양/음 버킷 분리**: `src/BOJ/Greedy/P1461.java`, `P1744.java`
- **비트 트릭**: `src/BOJ/Greedy/P1052.java`
- **가중 중앙값**: `src/BOJ/Greedy/P2141.java`
- **문자열 split 기반 그리디 파싱**: `src/BOJ/Greedy/P1541.java`(뺄셈 앞의 덧셈들을 괄호로 묶는 트릭)
- **닫힌 형태 유도**: `src/BOJ/Greedy/P4796.java`
