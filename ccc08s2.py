from sys import stdin
import math

while True:
    rad = int(stdin.readline())
    if rad == 0:
        break

    sum = 0
    for i in range(rad, 0, -1):
        y = (2 * (math.floor(math.sqrt(math.pow(rad, 2) - math.pow(i, 2))+1))-1) * 2
        sum += y
        # print(y)

    sum += 2*rad+1

    print(sum)

