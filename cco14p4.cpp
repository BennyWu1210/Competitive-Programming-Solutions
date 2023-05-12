#include <bits/stdc++.h>
using namespace std;

const int MN = 1e5 + 3;
int N, P, A[MN], B[MN], ans, cnt;


int main(){
    cin.sync_with_stdio(0); cin.tie(0);
    
    cin >> N >> P;
    for (int i = 1; i <= N; i++) cin >> A[i] >> B[i];

    for (int i = 1; i <= N; i++){
        if (i == P){
            ans += A[i];
            cnt ++;
            continue;
        }
        if (A[i] >= B[i]){
            ans += A[i] - B[i];
            cnt ++;
        }
    }

    cout << ans << endl;
    cout << cnt << endl;
    
}