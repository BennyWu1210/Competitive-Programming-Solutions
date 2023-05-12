N, M = [int(x) for x in input().split()]
A = [0] + [int(x) for x in input().split()]
B = [0] + [int(x) for x in input().split()]
dp = [[0 for i in range(M + 1)] for i in range(N + 1)]

for i in range(1, N + 1):
    for j in range(1, M + 1):
        dp[i][j] = max(dp[i][j - 1], dp[i - 1][j])
        if A[i] == B[j]:
            dp[i][j] = max(dp[i][j], dp[i - 1][j - 1] + 1)

print(dp[N][M])
