import math

T = int(input())
lst = []

for i in range(T):
    total = 0
    ipt = input().split(" ")
    N = int(ipt[0])
    S = int(ipt[1])

    total += N*(N+1)/2

    counter = 0
    diff = total - S
    begin = 1
    end = N

    if diff > begin + end:
        begin += diff - (begin + end)
    elif diff < begin + end:
        end -= (begin + end) - diff

    counter = math.floor((end - begin + 1)/2)
    print(counter)
    #lst.append(counter)

'''
for items in lst:
    print(items)
'''