//
//  Aliens.cpp
//  Competitive-Programming
//
//  Created by Benny Wu on 2022-07-31.
//

#include <iostream>
#include <map>
#include <algorithm>
#include <vector>
#include <deque>
#include <math.h>

typedef long long ll;
using namespace std;

const int MN = 1e5 + 4;
int n, m, k, r[MN], c[MN], x[MN], y[MN], cnt[MN];
ll dp[MN];

ll max(long a, long b){
    return a > b ? a : b;
}

ll slope(int j){
    return -2 * y[j + 1];
}

ll yInt(int j, ll pen){
    ll ret = dp[j] + y[j + 1] * y[j + 1] + 2L * y[j + 1] + cnt[j];
    if (y[j + 1] <= x[j]) ret -=  max(0L, (x[j] - y[j + 1] + 1) * 1L * (x[j] - y[j + 1] + 1));
    return ret;
}

ll Intersect(int a, int b, ll pen){
    if (slope(a) == slope(b)) return -1e9;
    return (yInt(b, pen) - yInt(a, pen)) / (slope(a) - slope(b));
}

ll take_photos(int n, int m, int k, int* r, int* c){
    cin.tie(0); cin.sync_with_stdio(0);
    
    for (int i = 0; i < n; i++){
        if (r[i] > c[i]) swap(r[i], c[i]);
    }
    
    vector<pair<int, int>> temp;
    for (int i = 0; i < n; i++){
        temp.push_back({c[i], r[i]}); // be careful - column comes first
    }
    
    sort(temp.begin(), temp.end());
    
    vector<pair<int, int>> points;
    for (int i = 0; i < n; i++){
        // cout << "first " << temp[i].first << ", second: " << temp[i].second << endl;
        if (points.size() > 0 && temp[i].first == points.back().first) continue;
        while (points.size() > 0 && points.back().second >= temp[i].second) points.pop_back();
        points.push_back(temp[i]);
    }
    
    // moving the points to new arrays to simplify the solving process
    int len = points.size();
    for (int i = 0; i < len; i++){
        x[i + 1] = points[i].first;
        y[i + 1] = points[i].second;
        // cout << "x: " << x[i + 1] << ", y: " << y[i + 1] << endl;
    }
    
    k = min(n, k);
    ll lo = -1e13, hi = 1e13, ans = 1e18, mid = 0;
    while (lo <= hi){
        ll pen = (lo + hi) / 2;
        
        // now apply convex hull
        ll original[len + 1];
        deque<int> dq;
        dq.push_back(0);
        for (int i = 0; i <= len; i++) {
            dp[i] = 0;
            original[i] = 0;
            cnt[i] = 0;
        }
        
        dp[0] = 0;
        original[0] = 0;
        cnt[0] = 0;
//        for (int i = 1; i <= len; i++){
//            while (dq.size() >= 2 && Intersect(dq[0], dq[1], pen) <= x[i]){
//                dq.pop_front();
//            }
//            ll dif = x[i] - y[dq[0] + 1] + 1;
//            ll reduce = 0;
//            if (dq[0] != 0 && x[dq[0]] >= y[dq[0] + 1]) reduce = max(0L, pow(x[dq[0]] - y[dq[0] + 1] + 1, 2));
//            original[i] = dif * dif + original[dq[0]] - reduce;
//            dp[i] = dif * dif + dp[dq[0]] - reduce + pen;
//
//            cnt[i] = cnt[dq[0]] + 1;
//
//            while (dq.size() >= 2 && Intersect(dq[dq.size() - 1], dq[dq.size() - 2], pen) >= Intersect(i, dq[dq.size() - 2], pen)){
//                dq.pop_back();
//            }
//            dq.push_back(i);
//            // cout << "dp: " << dp[i] << ", original: " << original[i] << endl;
//        }
        
        for (int i = 0; i <= len; i++) {
            dp[i] = 1e18;
            cnt[i] = 0;
        }

        dp[0] = 0;
        for (int i = 1; i <= len; i++){
            for (int j = 0; j < i; j++){
                ll dif = x[i] - y[j + 1] + 1;
                ll reduce = 0;

                if (j != 0 && y[j + 1] <= x[j]) reduce = max(0L, pow(x[j] - y[j + 1] + 1, 2));

                if (dp[i] > dp[j] + dif * dif - reduce + pen || (dp[i] == dp[j] + dif * dif - reduce + pen && cnt[i] > cnt[j] + 1)){
                    dp[i] = dp[j] + dif * dif - reduce + pen;
                    original[i] = original[j] + dif * dif - reduce;
                    cnt[i] = cnt[j] + 1;
                }

            }
        }

        if (cnt[len] > k){
            // not enough penalty
            lo = pen + 1;
        } else{
            // maybe too much penalty
            hi = pen - 1;
            ans = min(ans, original[len]);
            mid = pen;

        }
        
    }
//    ll original[len + 1];
//    deque<int> dq;
//    dq.push_back(0);
//    for (int i = 0; i <= len; i++) {
//        dp[i] = 0;
//        original[i] = 0;
//        cnt[i] = 0;
//    }
//
//    dp[0] = 0;
//    original[0] = 0;
//    cnt[0] = 0;
//    for (int i = 1; i <= len; i++){
//        while (dq.size() >= 2 && Intersect(dq[0], dq[1], mid) <= x[i]){
//            dq.pop_front();
//        }
//        ll dif = x[i] - y[dq[0] + 1] + 1;
//        ll reduce = 0;
//        if (dq[0] != 0 && x[dq[0]] >= y[dq[0] + 1]) reduce = max(0L, (x[dq[0]] - y[dq[0] + 1] + 1) * 1L * (x[dq[0]] - y[dq[0] + 1] + 1));
//        original[i] = dif * dif + original[dq[0]] - reduce;
//        dp[i] = dif * dif + dp[dq[0]] - reduce + mid;
//
//        cnt[i] = cnt[dq[0]] + 1;
//
//        while (dq.size() >= 2 && Intersect(dq[dq.size() - 1], dq[dq.size() - 2], mid) >= Intersect(i, dq[dq.size() - 2], mid)){
//            dq.pop_back();
//        }
//        dq.push_back(i);
//    }

    // return dp[len] - mid * cnt[len];
    return ans;
}


int main(){
    cin.tie(0); cin.sync_with_stdio(0);
    cin >> n >> m >> k;
    for (int i = 0; i < n; i++) cin >> r[i] >> c[i];
    
    cout << take_photos(n, m, k, r, c) << endl;
    return 0;
}
