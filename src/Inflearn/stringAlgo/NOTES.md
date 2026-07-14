# 문자열 알고리즘 (stringAlgo)

## 1. 개념 요약
문자열을 파싱, 변환, 매칭하는 문제 유형이다. 순수 알고리즘(KMP 같은 패턴 매칭)보다는 **Java의 `String`/`StringBuilder`/`char[]` API를 얼마나 능숙하게 다루는가**가 기업 코딩테스트에서는 더 중요한 경우가 많다. 문자열 순회, 분리(split), 빈도수 세기(HashMap과 결합), 팰린드롬 판별 등이 자주 나온다.

## 2. 언제 쓰는가
- "문자열을 특정 규칙으로 압축/변환/파싱하라"
- "부분 문자열이 특정 패턴을 포함하는가" → 단순 매칭이면 `String.contains()`/`indexOf()`로 충분, 대량 반복 매칭이면 KMP 등 별도 알고리즘 고려
- "문자열이 회문(팰린드롬)인가" → 투 포인터로 양끝에서 비교
- "문자 빈도수를 세서 비교/정렬" → HashMap 또는 크기 26(알파벳)/한글 유니코드 범위의 배열 카운팅

## 3. 핵심 템플릿 코드

**문자열 뒤집기 / 팰린드롬 체크**
```java
boolean isPalindrome(String s) {
    int left = 0, right = s.length() - 1;
    while (left < right) {
        if (s.charAt(left) != s.charAt(right)) return false;
        left++;
        right--;
    }
    return true;
}
```

**문자 빈도수 카운팅**
```java
int[] count = new int[26];
for (char c : s.toCharArray()) {
    count[c - 'a']++;
}
```

**StringBuilder로 효율적인 문자열 조작**
```java
StringBuilder sb = new StringBuilder();
for (char c : s.toCharArray()) {
    if (조건) sb.append(c);
}
String result = sb.toString();
```

**문자열 분리/파싱**
```java
String[] tokens = s.split(",");       // 콤마 기준 분리
String trimmed = s.trim();            // 앞뒤 공백 제거
```

**연결(concatenation) 비교자로 최댓값 문자열 조합 (`src/BOJ/Sorting/P1422.java`)**
```java
Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));
```

**split 기반 경량 파싱 (`src/BOJ/Greedy/P1541.java`)**
```java
String[] plusGroups = s.split("-"); // 뺄셈 기준으로 먼저 나눈다
int result = sumOfPluses(plusGroups[0]);
for (int i = 1; i < plusGroups.length; i++) result -= sumOfPluses(plusGroups[i]);
```

## 4. 시간복잡도
- 단순 순회/카운팅: O(n)
- `String` 연결(`+`)을 반복문 안에서 쓰면 매번 새 객체를 생성해 **O(n²)**까지 느려짐 → 반드시 `StringBuilder` 사용
- KMP 패턴 매칭: O(n + m) (텍스트 길이 n, 패턴 길이 m)

## 5. 자주 하는 실수
- 반복문 안에서 `String += ...`로 이어붙이기 — 문자열은 불변(immutable) 객체라 매번 새로 생성됨, `StringBuilder`로 바꿔야 함
- 한글/유니코드 문자를 다룰 때 `c - 'a'` 같은 알파벳 전용 인덱싱을 그대로 쓰면 범위를 벗어남 — 한글은 별도 유니코드 범위 계산 필요
- `String.split()`의 인자가 정규식이라는 걸 잊고 `.`, `|` 같은 특수문자를 그냥 넣어서 의도와 다르게 분리됨 (이스케이프 필요: `split("\\.")`)
- 대소문자 구분 문제에서 `toLowerCase()`/`toUpperCase()` 처리를 빼먹음
- (`src/Programmers/level2/P86052.java`와 `P64065.java` 실사례) 완전히 동일한 풀이 코드가 클래스명만 다르게 두 파일에 중복 존재 — 문제를 다시 풀 때 이미 푼 적 있는 유형인지 먼저 확인하는 습관이 필요함
- (`src/Programmers/level2/P17677.java` 실사례) 문자열 리스트에서 중복 원소를 `ArrayList.remove(Object)`로 하나씩 제거하는 방식은 각 호출이 O(n)이라 리스트가 크면 느림 — 빈도수를 세는 `HashMap<String,Integer>`(멀티셋 흉내)로 바꾸면 더 안전
- (`src/BOJ/Implement/P20437.java` 실사례) "같은 문자가 k번 나오는 최소/최대 구간"을 이중 for문(O(n²))으로 브루트포스한 코드 — 진짜 슬라이딩 윈도우(투 포인터로 O(n))가 아니라는 점을 구분해서 이해할 것

## 6. 이 폴더에서 푼 문제
아직 문제 없음 (TODO)

## 7. 참고: BOJ/Programmers 관련 문제
- **연결 비교자**: `src/BOJ/Sorting/P1422.java`
- **자릿수합/가중치 문자 카운팅**: `src/BOJ/Sorting/P1431.java`, `src/BOJ/Greedy/P1339.java`(자리값 가중 빈도배열)
- **split 기반 파싱**: `src/BOJ/Greedy/P1541.java`
- **팰린드롬**: `src/BOJ/Implement/P1259.java`(투 포인터), `src/BOJ/Greedy/P1802.java`(분할정복 재귀 스타일 `check(start,mid-1) && check(mid+1,end)`)
- **스택+lookback 파싱**: `src/BOJ/Implement/P2504.java`
- **빈도배열 + 윈도우**: `src/BOJ/Implement/P20437.java`(O(n²) 브루트포스 주의)
- **Programmers 문자열 문제**: `src/Programmers/level2/P42888.java`(오픈채팅방, split+HashMap), `P17677.java`(자카드 유사도, 바이그램), `P17684.java`(LZW 압축, HashMap 사전), `P17686.java`(파일명 정렬 비교자), `P92335.java`(진법 변환+split), `P49993.java`(스킬트리, substring/indexOf)
