#include <bits/stdc++.h>
using namespace std;

const int MM = 1e5 + 5, SQRT = 330;
int N, Q;
long bit[MM], temp[MM], arr[MM], arr2[MM], res[MM];

struct Query{
    int l, r, ind;
} queries[MM];

bool compare(Query a, Query b){
    if (a.l / SQRT != b.l / SQRT) return a.l / SQRT < b.l / SQRT;
    return (a.l / SQRT & 1) ? a.r < b.r : a.r > b.r;
};

void update(int ind, int v){
    for (int i=ind; i<=MM; i+=i&-i) bit[i] += v;
}

int query(int ind){
    int ans = 0;
    for (int i=ind; i>0; i-=i&-i) ans += bit[i];
    return ans;
}

int main(){
     
    cin.tie(0); cin.sync_with_stdio(0); 

    cin >> N; 
    for (int i=1; i<=N; i++) {
        cin >> arr[i];
        temp[i] = arr[i];
    }
    sort(temp, temp+N+1);

    
    unordered_map<long, int> map;
    int v = 1;
    map[temp[1]] = v;

    for (int i=2; i<=N; i++){
        if (temp[i] != temp[i-1]) map[temp[i]] = ++v;
    }

    for (int i=1; i<=N; i++) {
        arr[i] = map[arr[i]];
    }

    cin >> Q;
    for (int i=1; i<=Q; i++) {
        cin >> queries[i].l >> queries[i].r;
        queries[i].ind = i;
    }

    sort(queries + 1, queries + Q + 1, compare);

    int l = 1, r = 0; long ans = 0;
    for (int i=1; i<=Q; i++){
        Query q = queries[i];
        while (r < q.r){
            r ++;
            ans += query(MM-1) - query(arr[r]);
            update(arr[r], 1);
        }
        while (l > q.l){
            l --;
            ans += query(arr[l] - 1);
            update(arr[l], 1);
        }
        while (r > q.r){
            ans -= query(MM-1) - query(arr[r]);
            update(arr[r], -1);
            r --;
        }
        while (l < q.l){
            ans -= query(arr[l] - 1);
            update(arr[l], -1);
            l ++;
        }
        res[q.ind] = ans;
    }

    for (int i=1; i<=Q; i++) printf("%lld\n", res[i]);
    


}
