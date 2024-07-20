from collections import deque

n = int(input())
a,b = map(int,input().split())
m = int(input())
graph = [[] for _ in range(n+1)]
visited = [0] * (n+1)

for _ in range(m):
    u,v = map(int,input().split())
    graph[u].append(v)
    graph[v].append(u)

def bfs(node):
    q = deque()
    q.append(node)

    while q:
        v = q.popleft()
        for i in graph[v]:
            if visited[i] == 0:#방문하지 않은 노드라면?
                visited[i] = visited[v] + 1
                q.append(i)

bfs(a)

if visited[b] > 0:
    print(visited[b])
else:
    print(-1)