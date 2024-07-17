#include <iostream>
#include <queue>
#include <cmath>

using namespace std;

/**
1. bfs로 네방향 돌면서 가까운거 다 넣음
2. 큐빼면서 먹을 수 있는게 있으면 리턴함.
3. 없으면 break
4. 있으면 반환
5. 먹고, 새 위치에서 돌림
*/

#define P pair<int, int>
#define T pair<int, P>
#define X first
#define Y second

int n;
const int MX = 24;
int board[MX][MX];
P cur;

int dx[4] = {-1,0,0,1};
int dy[4] = {0,-1,1,0};

bool ch[MX][MX];

int sz = 2;
int cnt, t;

int get_dist(P pos1, P pos2){
    int diffX = abs(pos1.X - pos2.X);
    int diffY = abs(pos1.Y - pos2.Y);
    return diffX + diffY;
}

P bfs(){
    queue<pair<P, int>> q;
    int minDist = 1e9;
    P target = {-1, -1};

    for (int i = 0; i < n; i++) {
        fill(ch[i], ch[i] + n, false);
    }

    q.push({cur, 0});
    ch[cur.X][cur.Y] = true;

    while (!q.empty()) {
        int x = q.front().first.X;
        int y = q.front().first.Y;
        int dist = q.front().second;
        q.pop();

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if (board[nx][ny] > sz || ch[nx][ny]) continue;

            ch[nx][ny] = true;

            if (board[nx][ny] > 0 && board[nx][ny] < sz) {
                if (dist + 1 < minDist) {
                    minDist = dist + 1;
                    target = {nx, ny};
                } else if (dist + 1 == minDist) {
                    if (nx < target.X || (nx == target.X && ny < target.Y)) {
                        target = {nx, ny};
                    }
                }
            }

            q.push({{nx, ny}, dist + 1});
        }
    }

    if (target.X != -1 && target.Y != -1) {
        t += minDist;
    }

    return target;
}
int main()
{
    cin >> n;
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> board[i][j];
            if(board[i][j] == 9) {
                cur = {i,j};
                board[i][j] = 0;
            }
        }
    }
    
    while(true){
        //  cout << "cur: " << cur.X << " " << cur.Y << "\n";
        P pos = bfs();
        // cout << "pos: " << pos.X << " " << pos.Y << "\n";
        if(pos.X == -1 && pos.Y == -1) break;
        board[pos.X][pos.Y] = 0;
        cur = pos;
        cnt++;
        if(cnt == sz){
            sz++;
            cnt = 0;
        }
    }
    
    cout << t;
    

    return 0;
}