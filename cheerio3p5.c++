#include <iostream>
#include <vector>
#include <cmath>
#include <queue>
#include <array>
#include <algorithm>
#include <cassert>

#define ll long long;
using namespace std;

const int MAX = (int)2e9;
const int LOG = 14;
int N, Q;
int max_depth = 0;
int timer = 0;
int tin[2003], tout[2003];
int up[2003][LOG + 1];

void setup(int cur, int par, vector<int> adj[])
{
    tin[cur] = ++timer;
    up[cur][0] = par;
    for (int i = 1; i <= LOG; i++)
    {

        up[cur][i] = up[up[cur][i - 1]][i - 1];
    }

    for (int next : adj[cur])
    {
        if (next != par)
        {
            setup(next, cur, adj);
        }
    }

    tout[cur] = ++timer;
}

bool is_ancestor(int u, int v)
{
    return tin[u] <= tin[v] && tout[u] >= tout[v];
}

int lca(int u, int v)
{
    if (is_ancestor(u, v))
        return u;
    if (is_ancestor(v, u))
        return v;

    for (int i = LOG; i >= 0; i--)
    {
        if (!is_ancestor(up[u][i], v))
            u = up[u][i];
    }
    return u; // this is changed
}

void dfs(int cur, int depth, vector<int> adj[],
         int *res)
{

    res[cur] = depth;
    max_depth = max(max_depth, depth);

    for (int v : adj[cur])
    {
        if (res[v] != MAX)
            continue;
        dfs(v, depth + 1, adj, res);
    }
}

int search(int ancestor, int node, int target, int depth[], bool left_most)
{

    if (left_most)
    {
        // find the smallest u such that is_ancestor(ancestor, u) and depth[u] == target
        int left = 0, right = N - 1, ans = node;
        while (left <= right)
        {
            int mid = (left + right) / 2;

            if (is_ancestor(ancestor, mid) && depth[mid] == target)
            {
                ans = mid;
                right = mid - 1;
            }
            else if (depth[mid] >= target)
            {
                right = mid - 1;
            }
            else
            {
                left = mid + 1;
            }
        }

        return ans;
    }
    else
    {
        // find the largest u such that is_ancestor(node, u) and depth[u] == target
        int left = 0, right = N - 1, ans = node;
        while (left <= right)
        {
            int mid = (left + right) / 2;

            if (is_ancestor(ancestor, mid) && depth[mid] == target)
            {
                ans = mid;
                left = mid + 1;
            }
            else if (depth[mid] < target)
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }

        return ans;
    }
}

int dfs2(int cur, int target, int depth[], vector<int> adj[], bool dir)
{
    if (depth[cur] == target)
        return cur;

    if (dir)
    {
        for (int next : adj[cur])
        {
            if (depth[next] > depth[cur])
            {
                return dfs2(next, target, depth, adj, dir);
            }
        }
    }
    else
    {
        for (int i = adj[cur].size() - 1; i >= 0; i--)
        {
            int next = adj[cur][i];
            if (depth[next] > depth[cur])
            {
                return dfs2(next, target, depth, adj, dir);
            }
        }
    }
    assert(1 == 0);
    return -1;
}

int main()
{
    cin.tie(0);
    cin.sync_with_stdio(0);

    cin >> N >> Q;

    vector<int> adj[N], adj2[N];

    int u, v;
    for (int i = 0; i < N - 1; i++)
    {
        cin >> u >> v;
        u--;
        v--;

        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    for (int i = 0; i < N; i++)
    {
        sort(adj[u].begin(), adj[u].end());
    }

    int depth[N];
    int steps[N][N];  // include shortcut
    int steps2[N][N]; // original tree

    fill(depth, depth + N, MAX);

    dfs(0, 0, adj, depth);
    setup(0, 0, adj);

    vector<int> node_depth[max_depth + 1];

    for (int i = 0; i < N; i++)
    {
        node_depth[depth[i]].push_back(i);
    }

    for (int node = 0; node < N; node++)
    {
        queue<int> q;
        fill(steps[node], steps[node] + N, MAX);
        fill(steps2[node], steps2[node] + N, MAX);

        steps[node][node] = 0;
        steps2[node][node] = 0;
        q.push(node);

        while (!q.empty())
        {
            int cur = q.front();
            q.pop();

            for (int next : adj[cur])
            {
                if (steps[node][next] > steps[node][cur] + 1)
                {
                    steps[node][next] = steps[node][cur] + 1;
                    q.push(next);
                }
                if (steps2[node][next] > steps2[node][cur] + 1)
                {
                    steps2[node][next] = steps2[node][cur] + 1;
                    q.push(next);
                }
            }

            if (depth[cur] == depth[node])
            {
                if (cur + 1 < N && depth[cur + 1] == depth[cur] && steps[node][cur + 1] > steps[node][cur] + 1)
                {
                    steps[node][cur + 1] = steps[node][cur] + 1;
                    q.push(cur + 1);
                }

                if (cur - 1 >= 0 && depth[cur - 1] == depth[cur] && steps[node][cur - 1] > steps[node][cur] + 1)
                {
                    steps[node][cur - 1] = steps[node][cur] + 1;
                    q.push(cur - 1);
                }
            }
        }
    }

    int d;
    for (int i = 0; i < Q; i++)
    {
        cin >> u >> v >> d;
        u--;
        v--;

        int ans = MAX;

        if (d > max_depth)
        {
            cout << steps2[u][v] << '\n';
            continue;
        }

        int ancestor = lca(u, v);

        if (depth[ancestor] > d)
        {
            cout << steps2[u][v] << '\n';
            continue;
        }

        // int left_node = search(ancestor, u, d, depth, true);
        // int right_node = search(ancestor, u, d, depth, false);

        int left_node = dfs2(ancestor, d, depth, adj, true);
        int right_node = dfs2(ancestor, d, depth, adj, false);

        // cout << "ancestor: " << ancestor + 1 << endl;
        // cout << "left_node: " << left_node + 1 << endl;
        // cout << "right_node: " << right_node + 1 << endl;

        ans = min(ans, steps[left_node][u] + steps[left_node][v]);
        ans = min(ans, steps[right_node][u] + steps[right_node][v]);
        ans = min(ans, steps2[u][v]);

        cout << ans << '\n';
    }
}
