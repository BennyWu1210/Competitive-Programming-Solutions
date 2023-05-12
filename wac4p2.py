import math


N = int(input())

MAX = 1e18
total = 0
votes = []
points = []
dp = [[MAX for _ in range(5001)] for _ in range(2)]


def votes_needed(x):
    return int(x / 2) + 1


for i in range(N):
    ipt = [int(x) for x in input().split()]
    votes.append(votes_needed(ipt[0]))
    points.append(ipt[1])
    total += ipt[1]


dp[0][0] = 0
ind = 0

for i in range(0, N):
    ind ^= 1
    for p in range(0, 5001):
        # if we do not take the current province
        dp[ind][p] = min(dp[ind][p], dp[ind ^ 1][p])

        # we do take the current province
        if p >= points[i]:
            dp[ind][p] = min(dp[ind][p], dp[ind ^ 1][p - points[i]] + votes[i])


ans = 1e18


for p in range(0, 5001):
    if p > total - p:
        ans = min(ans, dp[ind][p])

print(ans)
