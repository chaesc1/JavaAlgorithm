n = int(input())
array = list(map(int,input().split()))
dp = [0] * (n+1)

dp = [1 for i in range(n)]

for i in range(n):
    for j in range(i):
        if array[i] < array[j]:
            dp[i] = max(dp[i], dp[j]+1)

print(n-max(dp))