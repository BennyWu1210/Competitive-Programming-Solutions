#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
const int MN = 3e5 + 5, MOD = 1e9 + 7;
int N; ll red[MN], blue[MN], ans;
char color[MN];
vector<int> adj[MN];

void dfs(int u, int par){
    ans ++;
    if (color[u] == 'R') red[u] = 1;
    else blue[u] = 1;
    
    for (int v: adj[u]){
        if (v == par) continue;
        dfs(v, u);
        
        ans = (ans + blue[u] * blue[v]) % MOD;
        ans = (ans + red[u] * red[v]) % MOD;

        if (color[u] == 'R'){
            blue[u] = (blue[u] + blue[v] + blue[u] * blue[v]) % MOD;
            red[u] = (red[u] + red[v] + (red[u] - 1) * red[v]) % MOD;
        } else {
            blue[u] = (blue[u] + blue[v] + (blue[u] - 1) * blue[v]) % MOD;
            red[u] = (red[u] + red[v] + red[u] * red[v]) % MOD;
        }
        

    }

    
}

int main(){
    cin.sync_with_stdio(0); cin.tie(0);
    cin >> N;
    cin >> (color + 1);

    for (int i = 0, u, v; i < N - 1; i++){
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    dfs(1, -1);
    cout << ans << endl;
}