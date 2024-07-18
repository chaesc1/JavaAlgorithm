#include <iostream>

using namespace std;

int d[1004];
int mod = 10007;
int main()
{
    int n;
    cin >> n;
    d[1] = 1;
    d[2] = 3;
    for(int i = 3; i <= n; i++){
       d[i] = d[i-2] % mod * 2 + d[i-1] % mod;
    }
    cout << (d[n] % mod);

    return 0;
}