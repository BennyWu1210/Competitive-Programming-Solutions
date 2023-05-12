import math

ipt = input().split()
n = int(ipt[0])
q = int(ipt[1])
lst = list(map(int, input().split()))
operations = []
for i in range(q):
    operations.append(list(map(int, input().split())))

for i in range(q):
    #print(lst)
    command = operations[i][0]
    number = operations[i][1]
    if command == 1:
        for p in range(len(lst)):
            if lst[p] == number:
                lst.append(math.ceil(number/2))
                lst.append(math.floor(number/2))
                lst.pop(p)
    elif command == 2:
        counter = 0
        for p in range(len(lst)):
            if lst[p] == number:
                counter += 1
        print(counter)


