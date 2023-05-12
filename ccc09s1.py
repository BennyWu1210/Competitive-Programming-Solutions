import math


a = int(input())
b = int(input())
count = 0
for i in range(a, b+1):
    root = i**(1/2)
    cubic = math.ceil(i**(1/3))
    if (root % 1 == 0 and (math.ceil(cubic)- cubic)<0.000001):
        print(i)





print(count)
