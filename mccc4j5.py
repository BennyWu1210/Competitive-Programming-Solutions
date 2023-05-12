from sys import *


def readInt():
    return int(stdin.readline().split()[0])


N = readInt()
dep = [0 for i in range(N+1)]
adj = [[] for i in range(N+1)]
dep_list = [[] for i in range(N+1)]
w = [0 for i in range(N+1)]

for i in range(N):
    lst = [int(x) for x in stdin.readline().split()]
    T = lst[0]
    R = lst[1]
    w[i+1] = T
    dep[i+1] = R
    for j in range(R):
        n = lst[j+2]
        adj[n].append(i+1)
        dep_list[i+1].append(n)

ans = -100000000
minimum = [0 for x in range(N+1)]

while True:
    ok = False
    for i in range(N+1):
        if dep[i] == 0:
            maximum = 0
            for j in dep_list[i]:
                maximum = max(maximum, minimum[j])

            minimum[i] = maximum + w[i]

            for j in adj[i]:
                dep[j] -= 1
            ok = True
            dep[i] = -1
            ans = max(ans, minimum[i])
    if not ok:
        break

print(ans)
