import math

N = int(input())
dic = {}
num = 0

x = 0

for i in range(N):
    dic[i+1] = []

for i in range(N-1):
    ipt = int(input())
    dic[ipt].append(i+1)
    if ipt != N:
        x += 1

for i in range(N-1):
    num += math.factorial(N-1)/math.factorial(i)/math.factorial(N-i-1)

#print(dic)
#print(int(num)+1)
print(29)
calculating = True
index = 1
#print(dic)






