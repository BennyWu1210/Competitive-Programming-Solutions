N = int(input())
dic = {}
index = 1

for i in range(N):
    dic[i+1] = []

while index < N:
    num = int(input())
    dic[num].append(index)
    index += 1

num = 1
store_list = []
print(dic)

def remove(n):
    '''
    for i in range(1, N+1):
        if num in dic[i]:
            for elements in dic[i]:
                if elements not in p_list:
                    p_list.append(elements)
                    remove(elements)
    '''
    for elements in dic[n]:
        remove(elements)
        p_list.append(elements)


while num < N:
    p_list = []
    remove(num)
    store_list.append(p_list)
    print(p_list)
    num += 1








