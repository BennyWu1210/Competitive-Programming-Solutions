N = int(input())
lst = []

for i in range(N):
    lst.append(int(input()))

lst = sorted(lst)
num = lst[2]-lst[0]
store = num+1

#print(lst)
for i in range(1, N-1):
    #print(lst)
    num = (lst[i+1] - lst[i-1])/2
    if num < store:
        store = num

print(round(store, 1))