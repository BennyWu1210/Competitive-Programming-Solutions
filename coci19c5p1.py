mask = 1
print(bool(0))

import sys
N, M = [int(x) for x in sys.stdin.readline().split()]
mat = [[] for i in range(N)]
vis = [[False for x in range(M)] for i in range(N)]

for i in range(N):
    lst = list(sys.stdin.readline().strip("\n"))
    mat[i] = lst



ans = 0
for i in range(N):
    for j in range(M):
        if not vis[i][j]:
            vis[i][j] = True

            if mat[i][j] == "*":
                ans += 1
                x, y = i, j
                while x < N and mat[x][y] == "*":
                    x += 1

                x -= 1
                while y < M and mat[x][y] == "*":
                    y += 1

                y -= 1


                # print(i, j)
                # print(x, y)
                # print("==")
                for r in range(i, x+1):
                    for c in range(j, y+1):
                        vis[r][c] = True
                        # print(r, c)




print(ans)




