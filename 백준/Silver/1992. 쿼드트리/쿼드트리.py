n = int(input())
map = [list(map(int,input())) for _ in range(n)]
# print(map)

def quad(x,y,n):
    flag = map[x][y]
    for i in range(x,x+n):
        for j in range(y,y+n):
            if flag != map[i][j]:
                flag = -1
                break
    
    if flag == -1:
        print('(',end='')
        n = n // 2 

        quad(x,y,n)
        quad(x,y+n,n)
        quad(x+n,y,n)
        quad(x+n,y+n,n)

        print(')',end='')
    elif flag == 1:
        print(1,end='')
    else:
        print(0,end='')

quad(0,0,n)