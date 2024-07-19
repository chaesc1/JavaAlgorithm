#include <iostream>

using namespace std;

int n;
int times[21],revenue[21], d[21];

int main(){
    cin >> n;
    for(int i = 1; i <= n; i++){
        cin >> times[i] >> revenue[i];
    }
    // 0. d[i]는 i일까지 상담했을 때 최대 수익
    for(int i = 1; i <= n; i++){
        int t = times[i], r = revenue[i];
        // 1. dp[i]는 이전까지 중에서 최댓값
        d[i] = max(d[i], d[i-1]);
        
        // 2. i일에 상담하면 i+t[i]일의 점수를 갱신 (t[i]만큼은 상담을 못하기때문)
        if(i + t <= n + 1) { // 상담끝나는날이 퇴사날안에 있는지
        	d[i+t] = max(d[i] + r, d[i+t]); 
        }
    }
    // 3. dp[n]과 dp[n+1] 중 최댓값 출력
    // dp는 n일까지 갱신됐고, n + 1은 끝난게 있을 수 있음.
    cout << max(d[n], d[n + 1]) << '\n'; 
}
