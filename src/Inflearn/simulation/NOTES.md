# 시뮬레이션 (simulation)

## 1. 개념 요약
문제에서 설명하는 규칙을 그대로 코드로 옮겨서 "한 단계씩 그대로 실행"하는 유형이다. 특별한 알고리즘 기법보다는 **문제 설명을 정확히 읽고 빠짐없이 조건을 구현하는 능력**이 핵심이다. 격자(2차원 배열) 위에서 좌표 이동, 방향 전환, 상태 갱신을 반복하는 문제가 많다.

## 2. 언제 쓰는가
- "다음과 같은 규칙으로 N번 반복하라"처럼 절차가 명확히 주어진 문제
- 2차원 격자에서 캐릭터/물체가 이동하며 상태가 바뀌는 문제 (뱀 게임, 로봇 청소기 등)
- 알고리즘적 트릭보다 "예외 케이스를 빠짐없이 처리했는가"가 정답 여부를 가르는 문제
- 다른 유형(BFS, 그리디 등)과 결합되어 "매 단계 상태를 갱신하면서 그래프 탐색도 같이" 하는 복합 문제

## 3. 핵심 템플릿 코드

**2차원 격자 방향 이동 (상하좌우)**
```java
int[] dx = {-1, 1, 0, 0}; // 상, 하
int[] dy = {0, 0, -1, 1}; // 좌, 우

for (int d = 0; d < 4; d++) {
    int nx = x + dx[d];
    int ny = y + dy[d];
    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue; // 범위 체크
    // nx, ny 처리
}
```

**방향 전환 (예: 시계 방향 회전)**
```java
// 동(0) -> 남(1) -> 서(2) -> 북(3) -> 동(0) 순서로 인덱싱해두면
int dir = (dir + 1) % 4; // 시계 방향 90도 회전
int dir2 = (dir + 3) % 4; // 반시계 방향 90도 회전
```

**격자를 문자열/2차원 배열로 초기화하고 상태 갱신 반복**
```java
char[][] grid = new char[n][m];
for (int step = 0; step < totalSteps; step++) {
    // 1. 이번 스텝의 규칙 적용
    // 2. 상태(grid) 갱신
    // 3. 종료 조건 체크
}
```

**지연 반전 플래그 (`src/BOJ/Implement/P5430.java` AC 명령어, 핵심 성능 idiom)**
```java
Deque<Integer> deque = new ArrayDeque<>();
boolean isReverse = false;
for (char cmd : commands) {
    if (cmd == 'R') isReverse = !isReverse; // 실제로 뒤집지 않고 플래그만 토글
    else { // 'D' — 앞/뒤 어느 쪽에서 뺄지는 isReverse에 따라 결정
        if (isReverse) deque.pollLast(); else deque.pollFirst();
    }
}
// 매 R마다 O(n) 반전을 하면 TLE — 플래그 토글로 O(1)에 처리
```

**신발끈 공식 + 오버플로 방지 (`src/BOJ/Implement/P2166.java`)**
```java
long sum = 0;
for (int i = 0; i < n; i++) {
    int j = (i + 1) % n;
    sum += (long) x[i] * y[j] - (long) x[j] * y[i]; // (long) 캐스팅으로 int 곱셈 오버플로 방지
}
double area = Math.abs(sum) / 2.0;
```

## 4. 시간복잡도
문제마다 다르지만, 격자 크기 N×M에 대해 매 스텝 전체를 훑으면 **O(steps × N × M)**이 되기 쉬우므로, 문제의 제한사항(격자 크기, 반복 횟수)을 보고 시간초과 여부를 미리 가늠해야 한다.

## 5. 자주 하는 실수
- 격자 범위를 벗어나는 이동 체크(`nx < 0 || nx >= n`)를 빼먹어 `ArrayIndexOutOfBoundsException` 발생
- 방향 배열(`dx`, `dy`)의 순서와 회전 로직의 인덱스 순서가 어긋나서 엉뚱한 방향으로 이동
- 문제 설명의 조건을 하나라도 놓치면(예: "장애물이 있으면 이동 불가", "경계에 부딪히면 방향 전환") 전체 시뮬레이션이 틀어짐 — 조건을 체크리스트로 만들어 하나씩 구현하는 습관 필요
- 상태를 얕은 복사해서 이전 상태와 현재 상태가 서로 참조를 공유해 의도치 않게 같이 바뀌는 경우 (2차원 배열 복사 시 `deepCopy` 필요 여부 확인)
- (`src/BOJ/Implement/P5430.java` 실사례) 매 회전 명령마다 실제로 자료구조를 뒤집으면 O(n)이 누적되어 느려짐 — "뒤집었다고 치고 플래그만 바꾸는" 지연 반전(lazy reverse) idiom이 훨씬 빠름
- (`src/BOJ/Implement/P1004.java` 실사례) 거리 비교에 `Math.pow(x, 2)`를 반복 호출하면 함수 호출 오버헤드+부동소수점 변환 비용이 붙음 — 정수 제곱은 그냥 `x * x`가 더 빠르고 정확함
- (`src/BOJ/Implement/P1021.java` 실사례) 큐를 회전시킬 때 항상 한쪽 방향으로만 돌리지 말고 `Math.min(count, size - count)`로 더 짧은 방향을 골라 회전 횟수를 최소화하는 최적화가 가능
- 스텁/미완성 파일 다수 존재(`P1025`, `P11723`, `P17837`, `P20207`, `P26074`) — 시뮬레이션 폴더에서도 아직 안 푼 문제가 많다는 기록, 참고용으로 로직을 베끼지 말 것

## 6. 이 폴더에서 푼 문제
아직 문제 없음 (TODO)

## 7. 참고: BOJ/Programmers 관련 문제
- **배열 시프트 회전**: `src/BOJ/Implement/P20055.java`(컨베이어 벨트)
- **큐 회전 최소화**: `src/BOJ/Implement/P1021.java`
- **지연 반전 데크**: `src/BOJ/Implement/P5430.java`
- **재귀 전파 시뮬레이션**: `src/BOJ/Implement/P14891.java`(톱니바퀴, 인접 톱니가 다를 때만 재귀적으로 회전 전파)
- **대칭 확장 패턴**: `src/BOJ/Implement/P1244.java`(스위치 켜고 끄기)
- **기하 공식(신발끈)**: `src/BOJ/Implement/P2166.java`
- **스택 + lookback 채점**: `src/BOJ/Implement/P2504.java`
- **팰린드롬/문자열 시뮬레이션 경계 사례**: `src/BOJ/Implement/P1259.java`
