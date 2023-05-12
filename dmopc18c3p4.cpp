#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
const int MN = 2e5 + 5;
int K, N, sz[MN], a[MN], vis[MN];
vector<pair<int, int>> adj[MN];
ll ans = 0;

void get_size(int u, int par) {
    sz[u] = a[u];
    for (pair<int, int> e : adj[u]) {
        if (e.first == par) continue;
        get_size(e.first, u);
        sz[u] += sz[e.first];
    }
}

int get_centroid(int u, int par, int cnt) {
    for (pair<int, int> e : adj[u]) {
        if (e.first != par && sz[e.first] > cnt / 2) return get_centroid(e.first, u, cnt);
    }
    return u;
}

void solve(int u, int par, int d) {
    ans += 1LL * a[u] * d;
    for (pair<int, int> e : adj[u]) {
        if (e.first == par) continue;
        solve(e.first, u, d + e.second);
    }
}

int main() {
    cin.tie(0);
    cin.sync_with_stdio(0);
    cin >> K >> N;

    for (int i = 1, x; i <= K; i++) {
        cin >> x;
        a[x]++;
    }

    for (int i = 1, u, v, w; i < N; i++) {
        cin >> u >> v >> w;
        adj[u].push_back({v, w});
        adj[v].push_back({u, w});
    }

    get_size(1, -1);

    int centroid = get_centroid(1, -1, K);

    solve(centroid, -1, 0);

    cout << ans << endl;
}
