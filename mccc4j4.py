from sys import *
from functools import cmp_to_key

N, S = [int(x) for x in stdin.readline().split()]

A = []


# comparator
def compare(item1, item2):
    if item1[1] != item2[1]:
        return item2[1] - item1[1]
    return 1 if item1[0] - item2[0] >= 0 else -1


for i in range(int(N/S)):
    A.append(stdin.readline().split())

B = [[[0, 0] for j in range(S)] for i in range(int(N/S))]

for i in range(int(N/S)):
    count = [0 for x in range(N+1)]
    for j in range(int(S*(S-1)/2)):
        a, b, c = [x for x in stdin.readline().split()]
        a = int(a)
        b = int(b)

        if c == 'W':
            count[a] += 3
        elif c == 'T':
            count[a] += 1
            count[b] += 1
        else:
            count[b] += 3

    for j in range(S):
        A[i][j] = int(A[i][j])
        B[i][j][0] = A[i][j]
        B[i][j][1] = count[A[i][j]]

K = int(stdin.readline().split()[0])
B[0].sort(key=cmp_to_key(compare))
ans = str(B[0][K-1][0])

for r in range(1, int(N/S)):
    B[r].sort(key=cmp_to_key(compare))
    ans += " " + str(B[r][K-1][0])

print(ans)




