#include <iostream>

using namespace std;
/**
1. 테이블 정의
- d[x]는 x까지 연속선택했을 때 x까지의 최댓값
- for문돌면서 d[x]가 최대일 때 출력
2. 점화식 찾기
- d[x] = max(d[x-1] + arr[x], arr[x])
- x를 선택했을 때 본인보다 작으면, 첨부터 시작
3. 초기값
- x-1인데 아무것도 안해도 d[0]은 arr[x]로 초기화됨
*/
int arr[1000006];
int d[1000006];
int main()
{
    int n;
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> arr[i];
    }
    for(int i = 0; i < n; i++){
        d[i] = max(d[i-1] + arr[i], arr[i]);
    }
    int mx = -1e9;
    for(int i = 0; i < n; i++){
        mx = max(mx, d[i]);
    }
    
    cout << mx;
    return 0;
}