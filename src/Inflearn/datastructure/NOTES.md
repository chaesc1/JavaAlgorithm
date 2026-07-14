# 자료구조 (datastructure)

## 1. 개념 요약
배열, 해시맵, 스택/덱(Deque) 같은 기본 자료구조를 활용해 데이터를 효율적으로 저장·탐색하는 기법이다. 알고리즘 자체보다는 "어떤 자료구조를 쓰면 시간복잡도를 줄일 수 있는가"에 초점을 맞춘다. 대표적으로 투 포인터(정렬 후 양끝에서 좁혀오기), 해시맵(빠른 존재 여부/빈도 조회), 스택(괄호 짝 맞추기, 다음 큰 원소 찾기)이 있다.

## 2. 언제 쓰는가
- "두 수의 합/차가 target" → 정렬 + 투 포인터, 또는 해시맵으로 O(n)
- "짝을 맞춰야 한다", "괄호 유효성" → 스택
- "각 원소보다 다음에 나오는 더 큰 값까지 거리" → 스택(단조 스택, Monotonic Stack)
- "중복 체크, 빈도수 세기" → HashMap/HashSet

## 3. 핵심 템플릿 코드

**투 포인터**
```java
Arrays.sort(arr);
int left = 0, right = arr.length - 1;
while (left < right) {
    int sum = arr[left] + arr[right];
    if (sum < target) left++;
    else if (sum > target) right--;
    else { /* 조건 충족 처리 */ left++; }
}
```

**스택으로 괄호 검사**
```java
Deque<Character> stack = new ArrayDeque<>();
for (char c : s.toCharArray()) {
    if (c == '(') stack.push(c);
    else {
        if (stack.isEmpty()) return false;
        stack.pop();
    }
}
return stack.isEmpty();
```

**단조 스택 (다음 더 큰 원소까지 거리)**
```java
Stack<Integer> stack = new Stack<>(); // 인덱스 저장
for (int i = 0; i < arr.length; i++) {
    while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
        int idx = stack.pop();
        answer[idx] = i - idx;
    }
    stack.push(i);
}
```

## 4. 시간복잡도
- 투 포인터: 정렬 O(n log n) + 탐색 O(n) = O(n log n)
- 해시맵 조회/삽입: 평균 O(1), 전체 O(n)
- 스택 기반(괄호, 단조 스택): 각 원소가 최대 한 번씩 push/pop → O(n)

## 5. 자주 하는 실수
- 투 포인터는 정렬을 먼저 해야 동작한다 — 정렬 잊으면 로직이 깨짐
- 스택이 비어있는지 확인 안 하고 `pop()`/`peek()` 호출 → 예외 발생
- 여러 종류 괄호(`()`, `{}`, `[]`)를 섞어 처리할 때 여는 괄호와 닫는 괄호 종류를 따로 매칭해야 함 (`P3`에서 다룸)
- 단조 스택에서 값 대신 인덱스를 저장해야 나중에 "몇 번째와의 거리"를 계산할 수 있음
- (`src/BOJ/StackQueueDeque/P9935.java` 실사례) 문자열 폭발 문제에서 스택 top이 폭발 문자열과 매치되면 `count`를 리셋하고 **바깥 루프를 `break`해야 하는데** 빠뜨리면 같은 글자에 대해 다음 매치 검사가 오염됨 — 스택 pop 로직 안에서 "매치 성공 후 상태 초기화"를 빠뜨리기 쉬움
- (`src/BOJ/MapAndSet/P2002.java` 실사례) 배열 인덱스 조회 방식에서 HashMap 방식으로 바꾸다가 이전 구현을 주석으로만 남기고 지우지 않는 경우가 많음 — 접근법을 바꿨으면 죽은 코드는 정리할 것
- (`src/BOJ/이분탐색/P2143.java` vs `src/BOJ/twoPointer/P2143.java`) 같은 문제를 이진탐색으로 풀려고 prefix-sum까지 정렬해놓고 `//이진탐색 시작` 주석만 남긴 채 미완성으로 남긴 사례가 있음. 실제로는 투 포인터로 완성함 — "계획한 기법이 안 풀리면 다른 자료구조로 피벗하는 것도 정상"이라는 교훈. 자세한 내용은 `binarySearch/NOTES.md` 참고

## 6. 이 폴더에서 푼 문제
- **P1** — 두 수의 합이 target인 쌍의 개수: 정렬 후 투 포인터로 O(n log n)에 해결 (`P1.java`)
- **P2** — 괄호 문자열 유효성 검사(단일 종류 `()`): 스택에 인덱스를 넣고 짝 맞추기 (`P2.java`)
- **P3** — 여러 종류 괄호(`()`, `{}`, `[]`) 짝 검사: 문자를 스택에 넣고 `peek()`으로 종류 확인 (`P3.java`)
- **P4** — 스쿼트 최대 중량 기록에서 "더 무거운 기록까지 며칠 걸리는지": 단조 스택으로 O(n) 해결 (`P4.java`)

## 7. 참고: BOJ/Programmers 관련 문제
실제 이 저장소의 다른 폴더에 이미 이 주제 기법을 쓴 풀이가 많다. 막힐 때 아래 파일들을 참고하면 좋다.

- **모노토닉 스택**: `src/BOJ/Stack/P2493.java`(탑, `Top` 클래스로 인덱스+높이 저장), `src/Programmers/level2/P154539.java`(다음 큰 원소)
- **괄호/스택 계열**: `src/BOJ/StackQueueDeque/P9012.java`, `P4949.java`(중첩 괄호 두 종류), `src/BOJ/Stack/P1918.java`(중위→후위 변환, 연산자 우선순위 함수)
- **빈도수 카운팅**: `HashMap.getOrDefault(key, 0) + 1` 패턴이 표준 idiom — `src/BOJ/MapAndSet/P10816.java`, `P9375.java`, `src/Programmers/level2/P132265.java`
- **존재 여부 체크**: `HashSet`에 넣어가며 빠른 조회 — `src/BOJ/MapAndSet/P11478.java`(모든 부분문자열을 Set에 넣어 distinct count)
- **투 포인터/슬라이딩 윈도우**: `src/BOJ/twoPointer/P1806.java`, `P2018.java`, `P1940.java`, `P2470.java`(정렬된 배열 양끝 좁히기)
- **prefix-sum과의 조합**: `src/BOJ/twoPointer/P2143.java` — 두 배열의 부분합을 각각 구해 정렬한 뒤 투 포인터로 병합해 target 합 쌍의 개수를 세는 응용. prefix-sum → 정렬 → 투 포인터의 3단 콤보 예시로 좋음
- **비교하면 좋은 쌍**: `src/BOJ/이분탐색/P2143.java`(미완성) ↔ `src/BOJ/twoPointer/P2143.java`(완성) — 같은 문제, 다른 접근
