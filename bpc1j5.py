N, K = [int(x) for x in input().split()]

lstA = []
indices = [0 for x in range(N)]

for i in range(K):
    lstA.append([int(x) for x in input().split()])


def calc(ind, prevIndices):

    if ind == N:
        res = []

        allZeros = True
        for num in prevIndices:
            if num != 0:
                allZeros = False
                break

        if allZeros:
            return

        for i in range(K):
            ans = []
            for j in range(N):
                ans.append(str(lstA[(i + prevIndices[j]) % K][j]))
            res.append(" ".join(ans))

        for i in range(len(res)):
            print(res[i])

        return

    curIndices = prevIndices.copy()

    for i in range(K):
        curIndices[ind] = i
        calc(ind + 1, curIndices)


calc(1, indices)