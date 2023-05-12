question = int(input())
N = int(input())
D = list(input().split(" "))
P = list(input().split(" "))



for num in range(len(D)):
    D[num] = int(D[num])

for num in range(len(P)):
    P[num] = int(P[num])

D.sort()
P.sort()


def maximum():
    total = 0
    for i in range(N):
        if D[-1] >= P[-1]:
            total += D[-1]
            D.pop(-1)
            P.pop(0)
        else:
            total += P[-1]
            P.pop(-1)
            D.pop(0)
    return total


def minimum():
    total = 0
    for i in range(N):
        if D[-1] >= P[-1]:
            total += D[-1]
            D.pop(-1)
            P.pop(-1)
        else:
            total += P[-1]
            P.pop(-1)
            D.pop(-1)
    return total


if question == 1:
    print(minimum())
else:
    print(maximum())
