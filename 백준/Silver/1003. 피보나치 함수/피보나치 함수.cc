#include <iostream>

using namespace std;


int d[42][2];

int main()
{
    int n;
    cin >> n;
    d[0][0] = 1;
    d[1][1] = 1;
    
    for(int i = 2; i <= 40; i++){
        d[i][0] = d[i-1][0] + d[i-2][0];
        d[i][1] = d[i-1][1] + d[i-2][1];
    }
    
    while(n--){
        int v;
        cin >> v;
        
        cout << d[v][0] << " " << d[v][1] << "\n";
    }
    

    return 0;
}