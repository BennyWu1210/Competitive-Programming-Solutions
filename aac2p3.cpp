#include <bits/stdc++.h>
#include <iostream>

using namespace std;

const int MM = 1e5 + 5, LOG = 17;
vector<pair<int, int>> adj[MM];
int up[MM][LOG+1], tin[MM], tout[MM], dep[MM], timer, N, Q;
pair<int, int> cost[MM][LOG+1]; // 1st and 2nd max cost

// Hmm should've made an update function like this and life would be much easier lol
/*
inline pi upd(pi x, pi y){
    pi z = x;
    if(y.f > z.f) { z.s = z.f; z.f = y.f; }
    else if(y.f > z.s) z.s = y.f;
    if(y.s > z.s) z.s = y.s;
    return z;
}
*/ 

inline void dfs(int u, int prev){
    up[u][0] = prev;
    dep[u] = dep[prev] + 1;
    tin[u] = ++timer;

    for (int i=1; i<=LOG; i++){
        up[u][i] = up[up[u][i-1]][i-1];

        if (cost[up[u][i-1]][i-1].first > cost[u][i-1].first) {
            cost[u][i].first = cost[up[u][i-1]][i-1].first;
            cost[u][i].second = max(cost[up[u][i-1]][i-1].second, cost[u][i-1].first);
        } else {
            cost[u][i].first = cost[u][i-1].first;
            cost[u][i].second = max(cost[up[u][i-1]][i-1].first, cost[u][i-1].second);
        }
    }

    for (pair nxt: adj[u]){
        if (nxt.first != prev){
            cost[nxt.first][0].first = nxt.second;
            dfs(nxt.first, u);
        }
    }

    tout[u] = ++timer;
    
}

inline bool isAnc(int u, int v){
    return tin[u] <= tin[v] && tout[u] >= tout[v];
}

inline int query(int u, int v){
    if (dep[u] > dep[v]) swap(u, v);
    if (isAnc(u, v) && dep[v] - dep[u] < 2) return -1;
    int f = 0, s = 0; // 1st and 2nd max cost
    if (!isAnc(u, v)){
        for (int i=LOG; i>=0; i--){ // u moves up to LCA
            if (up[u][i] && !isAnc(up[u][i], v)){ // make sure up[u][i] exists and is not v's ancestor
                if (cost[u][i].first >= f){
                    s = max(f, cost[u][i].second);
                    f = cost[u][i].first;
                } else if (cost[u][i].first > s){
                    s = cost[u][i].first;
                }
                u = up[u][i];
            }
        }
        if (cost[u][0].first >= f){
            s = f;
            f = cost[u][0].first;
        } else if (cost[u][0].first > s){
            s = cost[u][0].first;
        }
        u = up[u][0]; // u is now the LCA
    }

    for (int i=LOG; i>=0; i--){ // v moves up to LCA
        if (tin[u] <= tin[up[v][i]]){
            if (cost[v][i].first <= f){
                s = max(s, cost[v][i].first);
            }
            if (cost[v][i].first >= f){
                s = max(f, cost[v][i].second);
                f = cost[v][i].first;
            }
            if (cost[v][i].second >= f){
                s = f;
                f = cost[v][i].second;
            }

            v = up[v][i];
        }
    }

    return s;
}
int main() {
    cin >> N;
    int u, v, w;
    for (int i=0; i<N-1; i++){
        cin >> u >> v >> w;
        adj[u].push_back({v, w});
        adj[v].push_back({u, w});
    }

    dfs(1, 0);
    cin >> Q;
    while (Q --){
        cin >> u >> v;
        cout << query(u, v) << '\n';
    }
} 