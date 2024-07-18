#include <iostream>

using namespace std;
/**
1. 테이블 정의
- d[x]는 x가 마지막일 때 가장 큰 부분 수열의 합
2. 점화식 찾기
- 2중포문 돌면서,
- arr[i] > arr[j]일때 mx(...d[j]) + arr[i]
3. 초기값 설정
- 안해도됨.
*/

int n;
int arr[1004];
int d[1004];

int main()
{
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> arr[i];
    }
    
    for(int i = 0; i < n; i++){
        int mx = 0;
        for(int j = 0; j < i; j++){
            if(arr[i] <= arr[j]) continue;
            mx = max(d[j], mx);
        }
        d[i] = mx + arr[i];
    }
    int ret = 0;
    for(int i = 0; i < n; i++){
        ret = max(ret, d[i]);
    }
    cout << ret;
    return 0;
}