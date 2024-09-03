from collections import deque

# 터널 타입에 따른 이동 가능 방향 설정
DIRECTION = {
    1: [(-1, 0), (1, 0), (0, -1), (0, 1)],   # 상, 하, 좌, 우
    2: [(-1, 0), (1, 0)],                    # 상, 하
    3: [(0, -1), (0, 1)],                    # 좌, 우
    4: [(-1, 0), (0, 1)],                    # 상, 우
    5: [(1, 0), (0, 1)],                     # 하, 우
    6: [(1, 0), (0, -1)],                    # 하, 좌
    7: [(-1, 0), (0, -1)]                    # 상, 좌
}

def is_connected(tunnel_from, tunnel_to, direction):
    if tunnel_from == 0 or tunnel_to == 0:
        return False
    
    from_y, from_x = direction
    to_direction = (-from_y, -from_x)
    
    return to_direction in DIRECTION[tunnel_to]

def bfs(N, M, R, C, L, tunnel_map):
    queue = deque([(R, C)])
    visited = [[False] * M for _ in range(N)]
    visited[R][C] = True
    count = 1
    time = 1

    while queue and time < L:
        for _ in range(len(queue)):
            y, x = queue.popleft()
            for direction in DIRECTION[tunnel_map[y][x]]:
                ny, nx = y + direction[0], x + direction[1]
                if 0 <= ny < N and 0 <= nx < M and not visited[ny][nx] and tunnel_map[ny][nx] and is_connected(tunnel_map[y][x], tunnel_map[ny][nx], direction):
                    queue.append((ny, nx))
                    visited[ny][nx] = True
                    count += 1
        time += 1
    
    return count

def main():
    T = int(input())
    results = []
    for t in range(1, T+1):
        N, M, R, C, L = map(int, input().split())
        tunnel_map = [list(map(int, input().split())) for _ in range(N)]
        
        result = bfs(N, M, R, C, L, tunnel_map)
        results.append(f"#{t} {result}")
    
    for result in results:
        print(result)

if __name__ == "__main__":
    main()