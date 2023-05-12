N = int(input())

highest = -2**21+1
name = ""
for i in range(N):
    ipt = input().split()
    n = ipt[0]
    rating = float(ipt[1])
    if rating > highest:
        highest = rating
        name = n

print(name)