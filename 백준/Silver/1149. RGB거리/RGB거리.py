import sys
input = sys.stdin.readline

n = int(input())
color = []

for i in range(n):
    color.append(list(map(int,input().split())))
for i in range(1,len(color)):
    
    #빨간집
    color[i][0] = min(color[i-1][1],color[i-1][2]) + color[i][0]    
    #녹색집
    color[i][1] = min(color[i-1][0],color[i-1][2]) + color[i][1]
    #파란집
    color[i][2] = min(color[i-1][0],color[i-1][1]) + color[i][2]
    #print(color[i][0],color[i][1],color[i][2]) #총 합.

print(min(color[n-1][0],color[n-1][1],color[n-1][2]))