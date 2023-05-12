import math

low = []
high = []

N = int(input())
high = input().split()
high = [int(i) for i in high]

high.sort()


for i in range(math.ceil(N/2)):
    low.append(high[0])
    high.pop(0)


high = [str(i) for i in high]
low = [str(i) for i in low]
output = ''
if N % 2 == 0:
    length = len(low)
    for i in range(length):
        output += low[length-i-1] + ' '
        output += high[i] + ' '
else:
    length = len(high)
    for i in range(length):
        output += low[length-i] + ' '
        output += high[i] + ' '

    output += low[0]

print(output)
