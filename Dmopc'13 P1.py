import sys

ipt = input().split(" ")
N, M = int(ipt[0]), int(ipt[1])
dic = {}

for i in range(M):
    ipt = input().split(" ")
    p, q = int(ipt[0]), int(ipt[1])
    string = input()
    if q in dic.keys():
        dic[q].append(string)
    else:
        dic[q] = []
        dic[q].append(string)

Y = int(input())
if Y in dic.keys():
    for names in dic[Y]:
        print(names)
