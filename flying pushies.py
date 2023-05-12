N = int(input())
M = int(input())

counter = 0
for i in range(M):
    ipt = int(input())
    if ipt >= N:
        counter += 1

print(counter)
