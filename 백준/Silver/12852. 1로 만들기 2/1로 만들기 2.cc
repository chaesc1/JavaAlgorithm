#include <iostream>
#include <vector>

using namespace std;

int n;
int dp[1000002];
int path[1000002];
int main()
{
    cin >> n;
    
    // dp[x] = min(dp[x/3],dp[x/2],dp[x-1])
    for(int x = 2; x <= n; x++){
        int mn = dp[x-1];
        path[x] = x-1;
        if(x % 3 == 0 && mn > dp[x/3]) {
            mn = min(dp[x/3],mn);
            path[x] = x / 3;
        }
        if(x % 2 == 0 && mn > dp[x/2]) {
            mn = min(dp[x/2],mn);
            path[x] = x / 2;         
        }
        dp[x] = mn + 1;
    }
    cout << dp[n] << "\n";
    
    vector<int> ret;
    int v = n;
    while(true){
        ret.push_back(v);
        if(v == 1) break;
        v = path[v];
    }

    for(int p : ret){
        cout << p << " ";
    }
    return 0;
}