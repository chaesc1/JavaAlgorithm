# 이분탐색 (binarySearch)

## 1. 개념 요약
정렬된 배열에서 찾는 값의 범위를 절반씩 좁혀가며 O(log n)에 탐색하는 기법이다. 값 자체를 찾는 것뿐 아니라, **"조건을 만족하는 최소/최대값을 찾아라"는 문제를 파라메트릭 서치(parametric search)로 바꿔서** 이분탐색으로 푸는 경우가 코딩테스트에서 훨씬 자주 나온다.

## 2. 언제 쓰는가
- 배열이 정렬되어 있고 특정 값을 찾아야 할 때
- "최소/최대 ~을 구하라"인데, 답이 커질수록(작아질수록) 조건 만족 여부가 단조적으로 바뀔 때 (예: "최소 몇 미터로 잘라야 나눠줄 수 있는가") → 파라메트릭 서치
- 데이터 크기가 커서(10^5 이상) 선형 탐색으로는 시간초과가 날 때

## 3. 핵심 템플릿 코드

**기본 이분탐색 (값 찾기)**
```java
int left = 0, right = arr.length - 1;
while (left <= right) {
    int mid = left + (right - left) / 2;
    if (arr[mid] == target) return mid;
    else if (arr[mid] < target) left = mid + 1;
    else right = mid - 1;
}
return -1; // 못 찾음
```

**파라메트릭 서치 (조건을 만족하는 최대값 찾기)**
```java
int left = 최소가능값, right = 최대가능값;
int answer = 0;
while (left <= right) {
    int mid = left + (right - left) / 2;
    if (isValid(mid)) {   // mid로 조건을 만족하는가
        answer = mid;
        left = mid + 1;   // 더 큰 값도 가능한지 탐색
    } else {
        right = mid - 1;
    }
}
```

**나무 자르기 실전 예제 (`src/BOJ/이분탐색/P2805.java` — 이 저장소의 유일한 완성 예제)**
```java
long start = 0, end = maxHeight;
while (start < end) {
    long mid = (start + end) / 2;
    long sum = 0;
    for (long h : trees) if (h > mid) sum += h - mid;
    if (sum >= target) start = mid + 1; // 더 잘라도 충분 → 절단선을 올려본다
    else end = mid;
}
System.out.println(end - 1); // 주의: 반개구간 컨벤션이라 최종 답은 end가 아니라 end-1
```

## 4. 시간복잡도
- 기본 이분탐색: **O(log n)**
- 파라메트릭 서치: 탐색 범위에 대해 O(log(범위)) × 매 단계 조건 검사 비용 `isValid()`의 시간복잡도

## 5. 자주 하는 실수
- `mid = (left + right) / 2`로 계산하면 `left + right`가 오버플로우 날 수 있음 → `left + (right - left) / 2` 권장
- 배열이 정렬되어 있지 않은데 이분탐색을 적용 — 반드시 정렬 여부 확인
- 파라메트릭 서치에서 `left = mid + 1` / `right = mid - 1`을 반대로 써서 무한 루프에 빠짐 — "조건 만족 시 어느 방향으로 좁혀야 하는지"를 먼저 손으로 그려볼 것
- 종료 조건(`left <= right`)과 답을 갱신하는 시점을 헷갈려서 경계값(최소/최대 자체)을 놓치는 경우가 많음
- (`src/BOJ/이분탐색/P2805.java` 실사례) `while (start < end)` 반개구간 컨벤션을 쓰면 루프가 끝난 뒤 `end`가 아니라 `end - 1`을 답으로 출력해야 하는 경우가 있음 — start/end를 폐구간(`<=`)으로 쓸지 반개구간(`<`)으로 쓸지 먼저 정하고, 그에 맞는 최종 보정값을 항상 검산할 것

## 6. 이 폴더에서 푼 문제
아직 문제 없음 (TODO)

## 7. ⚠️ 이 주제는 연습이 가장 부족함
저장소 전체를 뒤져봐도 완성된 이분탐색 예제는 `src/BOJ/이분탐색/P2805.java` **단 1개**뿐이다. 심지어 같은 폴더의 `P2143.java`는 이진탐색으로 풀려고 두 배열의 prefix-sum을 정렬까지 해놓고 `//이진탐색 시작` 주석만 남긴 채 미완성으로 방치된 상태이며(`Pad.java`는 빈 템플릿 스텁), 실제 정답은 `src/BOJ/twoPointer/P2143.java`에서 투 포인터로 완성했다 — "이분탐색으로 계획했다가 실전에서는 다른 기법으로 풀린" 실제 사례로 남겨둘 가치가 있다(`datastructure/NOTES.md`에도 교차 기록).

**추천 액션**: 이 폴더는 다른 폴더 대비 연습량이 확연히 적으므로, 파라메트릭 서치 유형(백준 1654 랜선 자르기, 2110 공유기 설치, 1300 K번째 수)을 추가로 풀어서 채워둘 것.
