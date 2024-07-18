#include <iostream>

using namespace std;


int psum[100004];

int main()
{
    int n, m;
    cin >> n >> m;
    
    cin.tie(0);
    
    for(int i = 1; i <= n; i++){
        int v;
        cin >> v;
        psum[i] = psum[i-1] + v; 
    }
    string ret = "";
    for(int i = 0; i < m; i++){
        int a, b;
        cin >> a >> b;
        
        ret += to_string(psum[b] - psum[a-1]) + "\n";
    }
    cout << ret;
    
    return 0;
}