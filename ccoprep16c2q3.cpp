#include <bits/stdc++.h>
#include <iostream>
using namespace std;

const int MM = 2e5 + 5, SQRT = 520;
int N, Q, k[MM], dp[MM], nxt[MM], blk[MM], c, x, v;

int main() {
    cin.tie(0); cin.sync_with_stdio(0);
    cin >> N;
    for (int i=1; i<=N; i++) cin >> k[i];
    for (int i=N; i>0; i--){
        blk[i] = i / SQRT;
        if (i + k[i] >= N || blk[i + k[i]] != blk[i]){
            dp[i] = 1;
            nxt[i] = i + k[i];
        }
        else{
            dp[i] = dp[i + k[i]] + 1;
            nxt[i] = nxt[i + k[i]];
        }
    }

    cin >> Q;

    for (int i=1; i<=Q; i++){
        cin >> c;
        if (c == 1){
            cin >> x; x ++;
            int ans = 0;
            while (x <= N){
                ans += dp[x];
                x = nxt[x];
            }

            cout << ans << '\n';
        } else{
            cin >> x >> v; x ++;
            int num = blk[x];
            k[x] = v;
            while (blk[x] == num && x > 0){
                if (blk[x + k[x]] != blk[x]){
                    dp[x] = 1;
                    nxt[x] = x + k[x];
                }
                else{
                    dp[x] = dp[x + k[x]] + 1;
                    nxt[x] = nxt[x + k[x]];
                }

                x --;
            }
        }
    }



} 