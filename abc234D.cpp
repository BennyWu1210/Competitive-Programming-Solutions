#include <bits/stdc++.h>
using namespace std;

const int MM = 5e5 + 5;
int N, K, ans, f[MM];

int main(){
    cin.sync_with_stdio(0); cin.tie(NULL); 
    cin >> N >> K;

    int n; ans = 1e9;
    for (int i=1; i<=K; i++){
        cin >> n;
        f[n] ++;
        ans = min(ans, n);
    }

    cout << ans << '\n';

    for (int i=K+1; i<=N; i++){
        cin >> n;
        f[n] ++;

        if (n > ans){
            while (f[++ans] == 0){}
        }

        cout << ans << '\n';
    }
    

}