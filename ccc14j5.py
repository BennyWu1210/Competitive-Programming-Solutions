import sys

dic, N, a, b = {}, int(input()), input().split(), input().split()

for i in range(N):
    if (a[i] in dic and dic[a[i]] != b[i]) or (b[i] in dic and dic[b[i]] != a[i]) or a[i] == b[i]:
        print("bad")
        sys.exit()

    dic[a[i]], dic[b[i]] = b[i], a[i]

print("good")