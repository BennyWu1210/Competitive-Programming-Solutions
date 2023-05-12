#include <bits/stdc++.h>
using namespace std;

inline void update(int ind, int bit[]) {
    ind ++;
    for (int i=ind; i<sizeof(bit); i+=i&-i) {
        bit[i] += 1;
    }
}


int main() {
    int T;
    cin >> T;
		
    while (T --) {
        int n;
        cin >> n;
        int a[n+1];
        int freq[n+1], temp_freq[n+1], bit[n+10];

        for (int i=1; i<=n; i++) {
            cin >> a[i];
            freq[a[i]] ++;
        }
        
        int ans = 0, nxt = 0;
        vector<int> res;
        // Set<Integer> set = new HashSet();
        
        cout << "HI";
        for (int i=1; i<=n; i++) {
            if (a[i] == ans) {
                int l = a[i] + 1, r = n;
                while (l <= r) {
                    int mid = (l + r) / 2;
                    if (query(mid, bit) == mid) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                        ans = mid;
                    }
                }
                
            }
            freq[a[i]] --;

            if (freq[ans] == 0) {
                res.push_back(ans);
                ans = 0;
                temp_freq = new int[n+1];
                bit = new int[n+10];
            } else {
                if (temp_freq[a[i]] == 0) {
                    update(a[i], bit);
                }
                temp_freq[a[i]] ++;
				}
            
        }
        
        cout << res.size() << '\n';
        for (int i=0; i<res.size()-1; i++) {
            cout << res[i] << " ";
        }
        cout << res[res.size()-1];

    }
} 