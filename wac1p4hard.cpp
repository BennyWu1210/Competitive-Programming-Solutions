#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

const int MN = 1002, MOD = 998244353;
int n, k, u, v, sz[MN];
ll dp[MN][MN][3][3], merged[MN][3][3], ans;
char a[MN];
vector<int> adj[MN];

inline void dfs(int u, int par){
    sz[u] = 1;
    if (a[u] == 'R') dp[u][1][1][0] = 1;
    else if (a[u] == 'B') dp[u][1][0][1] = 1;

    for (int v: adj[u]){
        if (v == par) continue;
        dfs(v, u);
        sz[u] += sz[v];

        for (int i=0; i<=min(k, sz[u]); i++) {
			for (int r1=0; r1<=2; r1++) {
				for (int b1=0; b1<=2; b1++) {
                    if (!dp[u][i][r1][b1]) continue;
					for (int j=0; j<=min(k-i, sz[v]); j++) {
						for (int r2=0; r2<=2; r2++) {
							for (int b2=0; b2<=2; b2++) {
								long cur = dp[u][i][r1][b1];
		    					long nxt = dp[v][j][r2][b2];
								merged[i+j][min(2, r1+r2)][min(2, b1+b2)] += cur * nxt % MOD;
							}
						}
					}
				}
			}
		}

        for (int j=0; j<=k; j++) {
			for (int r=0; r<=2; r++) {
				for (int b=0; b<=2; b++) {
					dp[u][j][r][b] = (dp[u][j][r][b] + merged[j][r][b]) % MOD;
                    merged[j][r][b] = 0;
				}	
            }
		}
    }

    ans = (ans + dp[u][k][2][2]) % MOD;
}

int main(){
    cin.sync_with_stdio(0); cin.tie(0);
    
    cin >> n >> k >> a + 1;
    
    for (int i=1; i<=n-1; i++){
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    dfs(1, -1);
    cout << ans << endl;
}