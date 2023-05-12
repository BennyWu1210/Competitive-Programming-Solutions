T = int(input())
C = int(input())
lst = []
time_take = 0
for i in range(C):
    lst.append(int(input()))

lst.sort()
i = 0
while time_take+lst[i]<=T:
    time_take += lst[i]
    i += 1

print(i)
