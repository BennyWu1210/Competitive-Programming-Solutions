N = int(input())
a_lst = []
b_lst = []
calculating = True

a_lst = input().split()
b_lst = input().split()
a_store = 0
b_store = 0
store = 0

for i in range(N):
    a_store += int(a_lst[i])
    b_store += int(b_lst[i])
    if a_store == b_store:
        store = i+1


print(store)




