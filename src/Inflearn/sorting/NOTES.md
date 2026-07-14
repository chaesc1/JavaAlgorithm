# 정렬 (sorting)

## 1. 개념 요약
데이터를 특정 기준으로 순서대로 나열하는 기법. Java의 `Arrays.sort()`/`Collections.sort()`가 내부적으로 처리해주지만, 코딩테스트에서는 **정렬 자체보다 "어떤 기준으로 정렬할지"(커스텀 컴퍼레이터)**가 핵심이다. 정렬 후 투 포인터, 그리디와 결합되는 경우가 많다.

## 2. 언제 쓰는가
- "가장 큰/작은 값부터 처리해야 유리하다" → 정렬 후 그리디
- "여러 기준으로 비교해야 한다" (예: 끝나는 시간 순, 그 다음 시작 시간 순) → 커스텀 Comparator
- "문자열을 이어 붙였을 때 가장 큰/작은 수를 만들어라" → 문자열 조합 비교 정렬
- 정렬된 상태를 가정하고 이분탐색/투포인터를 적용해야 할 때 선행 단계로 사용

## 3. 핵심 템플릿 코드

**기본 정렬 (오름차순/내림차순)**
```java
int[] arr = {5, 2, 8, 1};
Arrays.sort(arr); // 오름차순만 가능 (기본 타입 배열은 Comparator 사용 불가)

Integer[] boxed = {5, 2, 8, 1};
Arrays.sort(boxed, Collections.reverseOrder()); // 내림차순
```

**커스텀 Comparator (다중 기준 정렬)**
```java
int[][] intervals = {{1, 3}, {2, 2}, {1, 5}};
Arrays.sort(intervals, (a, b) -> {
    if (a[0] != b[0]) return a[0] - b[0]; // 1차 기준: 시작 시간
    return a[1] - b[1];                    // 2차 기준: 끝나는 시간
});
```

**문자열 조합 최댓값 만들기 (예: [3, 30, 34] → "34330"이 아니라 최댓값이 되도록, `src/BOJ/Sorting/P1422.java` 실사례)**
```java
Arrays.sort(boxed, (a, b) -> (b + "" + a).compareTo(a + "" + b));
```

**좌표 압축 (`src/BOJ/Sorting/P18870.java` 실전 idiom)**
```java
int[] sorted = arr.clone();
Arrays.sort(sorted);
Map<Integer, Integer> rank = new HashMap<>();
int r = 0;
for (int v : sorted) if (!rank.containsKey(v)) rank.put(v, r++);
// 원본 배열을 rank map으로 조회하면 좌표압축된 값
```

**다단계 tie-break 비교자 (`src/BOJ/Sorting/P1431.java` 실사례 — 길이 → 자릿수합 → 사전순)**
```java
Arrays.sort(arr, (a, b) -> {
    if (a.length() != b.length()) return a.length() - b.length();
    int sumA = digitSum(a), sumB = digitSum(b);
    if (sumA != sumB) return sumA - sumB;
    return a.compareTo(b); // 최종 fallback은 사전순
});
```

## 4. 시간복잡도
- Java `Arrays.sort()`: 기본 타입은 듀얼 피벗 퀵정렬(O(n log n) 평균), 객체 타입은 TimSort(O(n log n) 보장, 안정 정렬)
- 커스텀 Comparator를 쓰면 정렬 자체는 동일하게 O(n log n)이지만 비교 함수 비용이 커지면 상수배 증가

## 5. 자주 하는 실수
- 기본 타입 배열(`int[]`)은 `Comparator`를 못 쓴다 — `Integer[]`로 박싱하거나 2차원 배열(`int[][]`)은 가능
- Comparator에서 `a[0] - b[0]`처럼 뺄셈으로 비교하면 오버플로우 위험 (값이 매우 크면 `Integer.compare()` 사용 권장)
- 정렬 기준이 여러 개일 때 우선순위를 헷갈려서 잘못된 순서로 비교하는 경우가 많음 — 문제에서 요구하는 "1차 기준, 2차 기준"을 먼저 명확히 정리하고 코드로 옮길 것
- 안정 정렬(stable sort)이 필요한 경우(동점자 처리 등) 객체 배열 정렬(TimSort)을 사용해야 함, 기본 타입 정렬은 안정성 보장 안 됨
- (`src/BOJ/Sorting/P1422.java` 실사례) 문자열 연결 비교자로 최댓값 배열을 만들 때, 앞자리가 0인 원소를 패딩하며 최댓값 원소를 중복으로 이어붙이는 버그가 실제로 있었음 — `flag` 불리언으로 "이미 최댓값을 붙였는지" 체크하도록 수정한 이력이 커밋에 남아있음. 중복 처리 로직은 꼭 한 번 더 검증할 것
- (`src/BOJ/Sorting/P2587.java` 실사례) `sum / 5`처럼 정수 나눗셈을 평균 계산에 그대로 쓰면 정밀도가 날아감 — 입력이 "나누어떨어짐이 보장"되는 문제인지 먼저 확인하고 아니라면 실수 연산으로 바꿀 것

## 6. 이 폴더에서 푼 문제
아직 문제 없음 (TODO)

## 7. 참고: BOJ/Programmers 관련 문제
- **다중 기준 정렬**: `src/BOJ/Sorting/P10814.java`(나이순 정렬), `src/BOJ/Sorting/P11651.java`(두 값 기준 정렬), `src/BOJ/Greedy/P1931.java`(회의실 배정 — 끝나는 시간 → 시작 시간 순, greedy와 교차 참고)
- **문자열 연결 비교자**: `src/BOJ/Sorting/P1422.java`
- **좌표 압축**: `src/BOJ/Sorting/P18870.java`
- **char[] 내림차순**: `src/BOJ/Sorting/P1427.java`(`Arrays.sort(char[])` 후 역순 순회 — 기본 타입은 `Collections.reverseOrder()`를 못 쓴다는 점 재확인)
- **다단계 tie-break**: `src/BOJ/Sorting/P1431.java`
- **파일명 정렬(Programmers)**: `src/Programmers/level2/P17686.java` — 파일명을 head/number/tail로 나눠 숫자 부분은 수치 비교, head는 대소문자 무시 비교, 나머지는 `Arrays.sort`의 안정 정렬 특성에 기대는 실전 예시
