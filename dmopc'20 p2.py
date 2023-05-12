import math

ipt = input().split()
N = int(ipt[0])
M = int(ipt[1])
lst = []
inc = max(N, M)
low = min(N, M)
num = 0
prev = 0
i = 0
counter = 0

while num < low:
    num += low/inc
    '''
    n = num
    j = math.floor(prev)
    while math.ceil(n) > num:
        num += low/inc
        if low == N and i+1<=inc and j+1<=low:
            lst.append((j + 1, i+1))
            counter += 1
        elif i+1<=inc and j+1<=low:
            lst.append((i+1, j + 1))
            counter += 1
    '''   
    #print(num)
    r = math.floor(num) - math.floor(prev)
    if num%1 < 0.000001 or num%1 > 0.999999:
        r -= 1

    for j in range(math.floor(prev), math.floor(prev)+r+1):
        #print(i, j, num)
        lst.append((j + 1, i + 1))
        counter += 1
        '''if low == N and i+1<=inc:
            lst.append((j + 1, i+1))
            counter += 1
        elif i+1<=inc and j+1<=low:
            lst.append((i+1, j + 1))
            counter += 1'''

    prev = num
    i += 1

#print(lst)
print(counter)
for p in lst:
    print(p[0], p[1])






