import sys

N, K = [int(x) for x in sys.stdin.readline().split()]

sum = 0

for i in range(N):
    a, b = [int(x) for x in sys.stdin.readline().split()]
    sum += a*b

print(sum%K)