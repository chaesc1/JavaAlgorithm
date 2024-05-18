N, K = map(int, input().split())

time = 1
move = [[-1, -1] for _ in range(500001)]  # 방문 시, 짝수, 홀수 최소 시간 저장
move[N][0] = 0
points = set([N])

if N != K:
    while K < 500001:
        # 수빈 움직임 추가
        n_points = set()
        for subin in points:
            for nxt in (subin-1, subin+1, subin*2):
                if -1 < nxt < 500001:
                    flag = time % 2
                    if move[nxt][flag] < 0:
                        move[nxt][flag] = time
                        n_points.add(nxt)

        points = n_points

        # 동생 움직이고 잡혔는지 판단
        K += time
        if K < 500001:
            flag = time % 2
            
            # 현재 시간에 동생 잡을 수 있는지 판단
            if move[K][flag] > -1:
                break           

            time += 1
else:
    time = 0

if K < 500001:
    print(time)
else:
    print(-1)