# 트리 (tree) — 이진/N진 트리 순회, 높이/지름, LCA, BST

## 1. 개념 요약
트리는 **사이클이 없는 연결 그래프**다. 그래프 탐색(BFS/DFS)과 코드 구조는 거의 동일하지만, 사이클이 없기 때문에 (양방향으로 표현되지 않는 한) `visited` 배열이 필요 없다는 점이 가장 큰 차이다 (`DFS.java` 주석의 "basecase 어디? -> 필요 없음"도 같은 맥락 — 자식이 없으면 재귀가 알아서 종료됨).

- **이진 트리**: 각 노드가 `left`/`right` 최대 2개 자식을 가짐
- **N진 트리**: 각 노드가 `children` 리스트를 가짐 (`Tree.java`의 `NNode` 참고)
- **BST(이진 탐색 트리)**: 이진 트리 + "왼쪽 서브트리 전체 < 노드 < 오른쪽 서브트리 전체" 불변식이 추가된 것

## 2. 언제 어떤 순회를 쓰는가
- **전위(pre-order, 루트→왼쪽→오른쪽)**: 트리를 복사하거나 직렬화할 때 (부모를 자식보다 먼저 처리해야 함)
- **중위(in-order, 왼쪽→루트→오른쪽)**: BST에 적용하면 **정렬된 순서**로 값이 나옴 (`bst_basic.java`에서 확인 가능)
- **후위(post-order, 왼쪽→오른쪽→루트)**: 자식들의 결과를 다 취합한 뒤에야 부모를 처리할 수 있을 때 — 트리 삭제, 높이/지름 계산(`height_diameter.java`)
- **레벨 순서(BFS)**: "레벨별로 묶어야 하는" 문제, 또는 최단 경로/거리 개념이 필요할 때 (`level_order.java`)

## 3. 핵심 템플릿 코드

**재귀 3순회** (`order_traversal.java`, `DFS.java`)
```java
void preOrder(Node cur, List<Integer> result) {
    if (cur == null) return;
    result.add(cur.value);
    preOrder(cur.left, result);
    preOrder(cur.right, result);
}
// inOrder/postOrder는 result.add() 위치만 다름
```

**반복 중위** (`order_traversal.java`) — 왼쪽 끝까지 스택에 쌓고, 못 내려가면 꺼내서 방문 후 오른쪽 이동
```java
Deque<Node> stack = new ArrayDeque<>();
Node cur = root;
while (cur != null || !stack.isEmpty()) {
    while (cur != null) {
        stack.push(cur);
        cur = cur.left;
    }
    cur = stack.pop();
    result.add(cur.value);
    cur = cur.right;
}
```

**레벨 순서 탐색 (BFS by level)** (`level_order.java`) — 큐 크기를 반복문 시작 시점에 스냅샷 떠야 함
```java
while (!q.isEmpty()) {
    int levelSize = q.size();
    List<Integer> level = new ArrayList<>();
    for (int i = 0; i < levelSize; i++) {
        Node cur = q.poll();
        level.add(cur.value);
        if (cur.left != null) q.offer(cur.left);
        if (cur.right != null) q.offer(cur.right);
    }
    result.add(level);
}
```

**높이/지름 패턴** (`height_diameter.java`) — 후위 순회로 자식 결과를 받아 전역 답 갱신
```java
private int diameter = 0;
private int height(Node cur) {
    if (cur == null) return 0;
    int left = height(cur.left);
    int right = height(cur.right);
    diameter = Math.max(diameter, left + right); // 이 노드를 지나는 경로 길이
    return 1 + Math.max(left, right);
}
```

**LCA 패턴** (`lca.java`) — 좌우 재귀 결과를 보고 "둘 다 찾음 / 한쪽만 찾음"으로 분기
```java
Node lca(Node root, Node p, Node q) {
    if (root == null || root == p || root == q) return root;
    Node left = lca(root.left, p, q);
    Node right = lca(root.right, p, q);
    if (left != null && right != null) return root;
    return left != null ? left : right;
}
```

**BST 삭제 패턴** (`bst_basic.java`) — 자식 2개인 경우 오른쪽 서브트리의 최솟값(후속자)으로 값을 대체
```java
if (root.left == null) return root.right;
if (root.right == null) return root.left;
Node successor = findMin(root.right); // root.right에서 가장 왼쪽으로 끝까지
root.value = successor.value;
root.right = delete(root.right, successor.value);
```

**BST 유효성 검사 (min/max 범위 넘기기)** (`bst_validate.java`)
```java
boolean isValid(Node cur, Integer min, Integer max) {
    if (cur == null) return true;
    if (min != null && cur.value <= min) return false;
    if (max != null && cur.value >= max) return false;
    return isValid(cur.left, min, cur.value) && isValid(cur.right, cur.value, max);
}
```

## 4. 시간복잡도
- 순회(전위/중위/후위/레벨): 모든 노드를 한 번씩만 방문하므로 **O(N)**
- BST 삽입/탐색/삭제: 트리 높이 h에 비례 — **O(h)** (균형 트리면 O(log N), 편향 트리면 최악 O(N))
- 지름: 각 노드에서 O(1) 작업 후 자식 결과 재사용 → 전체 **O(N)** (모든 쌍을 비교하는 O(N²) 방식과 헷갈리지 말 것)

## 5. 자주 하는 실수
- 트리인데 습관적으로 그래프처럼 `visited` 배열을 쓰는 것 — 트리는 사이클이 없으므로 불필요 (단, 인접 리스트로 양방향 표현했다면 부모로 되돌아가지 않기 위해 필요할 수 있음, `BFS.java`의 `bfs2`가 그 경우)
- N진 트리에서 `children`이 빈 리스트가 아니라 `null`일 수 있다고 착각하고 null 체크를 빼먹는 것 — `NNode`/`Node2`는 생성자에서 항상 `new ArrayList<>()`로 초기화되므로 실제로는 안전하지만, 직접 만든 클래스가 아니라면 확인 필요
- 지름을 구할 때 "루트를 지나는 경로"만 생각하고 다른 서브트리 내부의 경로(양쪽 자식이 모두 한쪽 서브트리에 있는 경우)를 놓치는 것 — 그래서 모든 노드에서 `left+right`를 비교하며 전역 최댓값을 갱신해야 함
- BST 삭제에서 자식이 2개인 경우, 후속자(오른쪽 서브트리의 최솟값)를 찾고 나서 **그 후속자 노드 자체를 삭제하는 재귀 호출을 빼먹는 것** — 값만 복사하고 원래 후속자 노드를 안 지우면 값이 중복됨
- BST 유효성 검사에서 바로 아래 자식(부모-자식 1단계)만 비교하는 것 — 조상 전체 기준의 범위(min/max)를 누적해서 넘겨야 `bst_validate.java`의 `invalid` 케이스 같은 오류를 잡을 수 있음

## 6. 이 폴더에서 정리한 개념/연습 코드
`P#`는 Inflearn 강의의 실제 문제 번호 전용이라, 아래는 개념 학습용 연습 코드라 설명적인 파일명을 그대로 썼다 (`graph/bfs_template.java` 방식과 동일).

- **order_traversal** — 이진 트리 전위/중위/후위 순회를 재귀+반복(스택) 양쪽으로 구현 (`order_traversal.java`)
- **level_order** — 레벨 순서 탐색(BFS by level), 응용으로 트리의 오른쪽 뷰 (`level_order.java`)
- **height_diameter** — 트리의 높이, 트리의 지름 (`height_diameter.java`)
- **lca** — 이진 트리에서 최소 공통 조상(LCA) (`lca.java`)
- **bst_basic** — BST 삽입/탐색/삭제 (`bst_basic.java`)
- **bst_validate** — 주어진 트리가 유효한 BST인지 검사 (`bst_validate.java`)
- `BFS.java`/`DFS.java`/`Tree.java` — 트리를 인접 리스트/이진 Node/N진 Node로 표현하는 3가지 방식과 기본 순회 비교 (개념 정리용)

## 7. 이 폴더에서 푼 문제
- **P1** — 감염된 폴더 (`P1.java`, 진행 중)
