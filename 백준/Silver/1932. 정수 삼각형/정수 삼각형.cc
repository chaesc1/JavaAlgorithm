#include <iostream>

using namespace std;

/**
# boj 1932 정수삼격형  
1. 테이블 정의
- d[i]를 해당 줄의 최댓값으로 잡으면, 대각선만 선택할 수 있는 걸 못 표현
- d[i][j]를 i층에서 j를 선택한 경우 최댓값
- 그 후 d[n-1][i]에서 최댓값 찾기
2. 점화식찾기
- d[i][j] = mx(d[i-1][j-1], d[i-1][j])
3. 기본값 셋팅
- i-1이므로 d[0][0]값 셋팅  
*/
int arr[504][504];
int d[504][504];
int main()
{
    int n;
    cin >> n;
    int sum = 0;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < i+1; j++){
            cin >> arr[i][j];
        }
    }
    
    d[0][0] = arr[0][0];
    for(int i = 1; i < n; i++){
        for(int j = 0; j < i+1; j++){
            int mx = d[i-1][j] ;
            if(j > 0) mx = max(mx, d[i-1][j-1]);
            d[i][j] = mx + arr[i][j];
        }
    }
    int ret = -1;
    for(int i = 0; i < n; i++){
        ret = max(ret, d[n-1][i]);
    }
    cout << ret;
    
}