#include <iostream>

using namespace std;

long dp[100];

int main(){
    int n;
    cin >> n;
    
 
    dp[1] = 1;
    for(int i = 2; i <= n; i++){
        dp[i] = dp[i-2] + dp[i-1];
    }
    
    cout << dp[n];
   

    return 0;
}
