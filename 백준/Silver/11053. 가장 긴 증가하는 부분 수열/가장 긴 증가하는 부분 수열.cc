#include <iostream>
#include <vector>
using namespace std;


vector<pair<int, int>> vec;
int dp[1002];
int arr[1002];

int main()
{
    int n;
    cin >> n;
    for(int i = 0; i < n; i++) cin >> arr[i];
    
    for(int i = 0; i < n; i++){
        int mx = 0;
        for(int j = 0; j < i; j++){
            if(arr[j] >= arr[i]) continue;
            mx = max(dp[j], mx);
        }
        dp[i] = max(dp[i], mx + 1);
    }
    
    int mx = 0;
    for(int i = 0; i < n; i++){
        mx = max(dp[i], mx);
    }
    cout << mx;
    return 0;
}
