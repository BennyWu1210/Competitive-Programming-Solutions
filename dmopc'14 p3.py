veterans = {}
newbies = []

N = int(input())

for i in range(N):
    ipt = input().split()
    name = ipt[0]
    s = int(ipt[1])
    veterans[name] = s

Q = int(input())

for i in range(Q):
    ipt = input().split()
    s = int(ipt[0])
    d = int(ipt[1])
    newbies.append(s)
    newbies.append(d)
print(veterans)
print(newbies)

