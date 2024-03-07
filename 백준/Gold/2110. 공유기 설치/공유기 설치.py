import sys
input = sys.stdin.readline

#집의 개수, 공유기의 개수 입력
n,c = list(map(int,input().split(' ')))

array = []
for _ in range(n):
    array.append(int(input()))

array.sort() #이진 탐색하기 위해 정렬


#최소길이
min = 1
#공유기 사이의 최대길이
max = array[-1] - array[0]
result = 0

while min <= max:
    mid = (min+max)//2
    val = array[0]#맨처음 설치해
    count = 1

    for i in range(1,n):
        if array[i] >= val + mid:
            val = array[i]
            count += 1
    if count >= c:#c개 이상 설치 가능하면? 거리를 늘려
        min = mid + 1
        result = mid
    else:
        max = mid - 1

print(result)