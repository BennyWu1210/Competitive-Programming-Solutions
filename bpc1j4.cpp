#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

const int MN = 1e4 + 4;
int N, M;
map<ll, bool> dp;
char numbers[MN];
bool vis[MN];

int main() {
    cin >> N >> M;
    cin >> numbers;

    int num = 0;
    for (int i = 0; i <= 4; i++){
        if (i >= numbers.length || num > M) break;
        num = num * 10
    }
}