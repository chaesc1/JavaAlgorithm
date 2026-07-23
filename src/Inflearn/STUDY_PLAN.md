# Inflearn 학습용 코드 작성 계획

기업 코딩테스트(프로그래머스/Inflearn 스타일) 대비를 위해 `src/Inflearn/` 아래에서 진행하는 알고리즘 유형별 학습 계획이다.

## 1. 폴더/파일 컨벤션

- 패키지: `package Inflearn.<topicName>;` — 카멜케이스 (예: `exhaustiveSearch`, `implicitGraph`)
- 클래스명: `P1`, `P2`, `P3` ... 주제 폴더 내 문제 번호 순으로 통일
  - `exhaustiveSearch`의 `ex1~ex5`는 초기에 쓰던 레거시 네이밍으로 그대로 두고, 새 문제부터는 `P#`로 통일한다
- 메서드: `public <반환타입> solution(...)` 하나를 중심으로, 필요시 `private` 보조 메서드(`dfs`, `bfs` 등)로 분리
- `main()`에 예시 입력과 기대 출력을 `// 주석`으로 남겨 즉석에서 눈으로 검증 가능하게 작성
- 필요하면 파일 하단에 원문제 요약을 한국어 주석으로 짧게 남긴다 (`exhaustiveSearch/P1.java` 참고)
- 같은 문제를 다른 접근으로도 풀어볼 가치가 있을 때만 `P#_bfs.java`처럼 접미사를 붙여 별도 파일로 분리 (예: DP vs BFS 비교)
- 각 주제 폴더에는 개념 설명/템플릿 코드/자주 하는 실수를 정리한 `NOTES.md`를 둔다 (문제 풀이 코드와 학습 자료를 분리)

## 2. 학습 주제 및 순서

기업 코딩테스트에 자주 나오는 유형을 다음 순서로 다룬다. 완료된 주제는 체크 표시.

- [x] `datastructure` — 배열/해시맵/투포인터
- [x] `exhaustiveSearch` — 완전탐색, DFS 백트래킹 기초
- [x] `graph` — 명시적 그래프 BFS/DFS
- [ ] `tree` — 이진/N진 트리 순회, 높이/지름, LCA, BST
- [ ] `implicitGraph` — 상태공간 탐색 (잔돈교환류, 퍼즐 최단경로 등 그래프가 명시되지 않는 문제)
- [ ] `sorting` — 정렬 응용, 커스텀 컴퍼레이터
- [ ] `greedy` — 그리디 선택, 활동선택/구간 문제
- [ ] `binarySearch` — 이분탐색, 파라메트릭 서치
- [ ] `dp` — 1차원/2차원 DP, 배낭 문제, LIS
- [ ] `backtracking` — 순열/조합/N-Queen류 (exhaustiveSearch와 구분: 가지치기 중심)
- [ ] `unionFind` — 분리집합, 크루스칼과 연계
- [ ] `priorityQueueHeap` — 힙 활용, 다익스트라와 연계
- [ ] `stringAlgo` — 문자열 매칭, 파싱형 문제
- [ ] `simulation` — 구현/시뮬레이션형 (좌표 이동, 격자)

각 주제를 시작할 때 폴더를 새로 만들고, 별도 README 없이 이 문서의 체크리스트만 갱신한다.

## 3. 문제 소스

Inflearn 강의 문제를 기본으로 진행하고, 주제별로 문제가 부족하면 프로그래머스/백준에서 보충한다. (구체적 링크는 금방 낡으므로 여기 남기지 않는다)

## 4. 커밋 컨벤션

주제 단위로 묶어서 커밋한다: `Inflearn <주제명 한글> 문제풀이 추가/개선`
