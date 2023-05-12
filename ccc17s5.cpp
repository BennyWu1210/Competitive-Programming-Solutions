#include <bits/stdc++.h>
#include <iostream>
using namespace std;

const int MM = 150002;
int N, M, Q, c, l, r, x, SQRT;
int a[MM], line[MM], blk[MM], upd[MM], n_pos[MM], sum[400];
vector<int> lines[MM], bounds[MM];

int calc(int x){
    int l = line[x];
    int ind = lines[l][(n_pos[x] - upd[l] % lines[l].size() + lines[l].size()) % lines[l].size()];
    return a[ind];
}

void update(int x){
    for (int i=0; i<bounds[x].size(); i++){
        int v = calc(bounds[x][i]);
        sum[blk[bounds[x][i]]] -= v;
        sum[blk[bounds[x][(i + 1) % bounds[x].size()]]] += v;
    }
    upd[x] ++;
}

int query(int l, int r){
    int ans = 0;
    while (l % SQRT != 0 && l <= r){
        ans += calc(l);
        l ++;
    }
    while (r % SQRT != SQRT - 1 && r >= l){
        ans += calc(r);
        r --;
    }
    while (l <= r){
        ans += sum[blk[l]];
        l += SQRT;
    }

    return ans;
    
}
int main() {
    cin >> N >> M >> Q; SQRT = sqrt(N);
    for (int i=0; i<N; i++) {
        cin >> line[i];
        line[i] --;
        lines[line[i]].push_back(i);
        n_pos[i] = lines[line[i]].size() - 1;
    }

    for (int i=0; i<N; i++) cin >> a[i];

    for (int l=0; l<N; l+=SQRT){
        int r = min(N-1, l+SQRT-1);
        for (int i=l; i<=r; i++){
            blk[i] = i / SQRT;
            sum[blk[i]] += a[i];
            if (bounds[line[i]].empty() || blk[bounds[line[i]].back()] != blk[i]){
                bounds[line[i]].push_back(i);
            } else{
                bounds[line[i]][bounds[line[i]].size() - 1] = i;
            }

        }
    }

    while (Q --){
        cin >> c;
        if (c == 1){
            cin >> l >> r;
            l --; r --;
            cout << query(l, r) << '\n';;
        } else{
            cin >> x;
            x --;
            update(x);
        }
    }


} 