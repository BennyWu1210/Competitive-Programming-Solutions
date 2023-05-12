import math

t = int(input())
lst = []

for i in range(t):
    a = input().split()
    lst.append(a)
    for j in range(3):
        lst[i][j] = int(lst[i][j])


for l in lst:
    l.sort()
    #print(l)
    num = math.sqrt(math.pow(int(l[0]), 2) + math.pow(int(l[1]), 2))
    #print(num)

    if num == int(l[2]):
        print("R")
    elif num > int(l[2]):
        print("A")
    else:
        print("O")


    #aa = math.acos(m)
