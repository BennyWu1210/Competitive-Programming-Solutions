#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

int n;
vector<pair<int, int>> a;

int main() {
    cin >> n;
    int u, v;
    for (int i=0; i<n; i++){
        cin >> u >> v;
        a.push_back({u, v});
    }

    ll sum1 = 0, sum2 = 0;

    for (int i=0; i<=n; i++){
        sum1 += a[i].first * a[(i+1)%n].second;
        sum2 += a[i].second * a[(i+1)%n].first;
    }
    cout << ceil(abs((sum1 - sum2) / 2.0)) << endl;


} 