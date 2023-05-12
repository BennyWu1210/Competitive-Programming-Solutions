import sys
import math

lst = list("abcdefghijklmnopqrstuvwxyz")
S = input()
T = input()

ipt = []
t_ipt = []
for i in range(len(list(S))):
    ipt.append(ord(S[i]) - 96)

for i in range(len(list(T))):

    t_ipt.append(ord(T[i]) - 96)

'''print(lst)
print(ipt)
print(t_ipt)'''

i = 0

while i + len(T) < len(S):
    matched = True
    #print(ipt[i], t_ipt[0])
    if ipt[i] >= t_ipt[0]:
        prev = abs(ipt[i] - t_ipt[0])
    elif ipt[i] < t_ipt[0]:
        prev = abs(26 - ipt[i] - t_ipt[0])
    P = ipt[i] - t_ipt[0]
    for j in range(len(T)):
        #print(str(i), 'ghi')
        if abs(ipt[j+i] - t_ipt[j]) != prev and abs(26 - ipt[j+1] - t_ipt[j]) != prev:
            matched = False
            break

    if matched:
        #print(prev)
        break
    i += 1

result = []
#print("prev" + str(prev))
for i in range(len(ipt)):
    #print(ipt[i], prev)
    #print(lst[26%(ipt[i]-prev-1)])
    
    result.append(lst[ipt[i]-prev-1])

if prev < 0:
    print(prev+26)
else:
    print(prev)
print("".join(result))

