#include <iostream>

using namespace std;

/**
1. 테이블정의
- d[x]는 가장 긴 길이
2. 점화식 찾기
- d[x] = d[x-2] + d[x-3]

3. 초기값 설정
- d[1] = 1, d[2] = 1, d[3] = 1
- x-3을 했을 때 1이 되게 4이전까지 채움. 
*/

long long d[1004];
int main()
{
    int t;
    cin >> t;
    
    d[1] = 1;
    d[2] = 1;
    d[3] = 1;
    for(int i = 4; i <= 100; i++){
        d[i] = d[i-2] + d[i-3];
    }
    
   
    while(t--){
        int n;
        cin >> n;
        cout << d[n] << "\n";   
    }
}