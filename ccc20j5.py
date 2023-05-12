import math

m = int(input())
n = int(input())
lst = []
bool_lst = []
ran_lst = []
cleared = False

for i in range(m):
    lst.append([])
    bool_lst.append([])
    lst[i] = input().split()
    for j in range(n):
        lst[i][j] = int(lst[i][j])
        bool_lst[i].append(False)

'''for i in range(1000):
    bool_lst.append([])
    for j in range(1000):
        bool_lst[i].append(False)'''

'''
print(lst)
print(bool_lst)
'''

r = 1
c = 1
queue = [lst[0][0]]
ran_lst = [queue[0]]

while len(queue) > 0:
    num = queue[0]
    queue.pop(0)
    #print(num)
    for i in range(1, math.ceil(math.pow(num, 0.5))+1, 1):
        if num % i == 0:
            #print(queue)
            #print(ran_lst)
            r = i
            c = int(num/i)
            if not cleared and r <= m and c <= n and not bool_lst[r-1][c-1]:

                #print(r,c)
                #print(queue)
                if r == m and c == n:
                    cleared = True
                    queue = []
                    break
                else:
                    if lst[r-1][c-1] not in ran_lst:
                        #print(queue)
                        queue.append(lst[r-1][c-1])
                        ran_lst.append(lst[r - 1][c - 1])
                    bool_lst[r-1][c-1] = True
            r, c = c, r
            
            if not cleared and r <= m and c <= n and not bool_lst[r-1][c-1]:
                #print(r,c)
                #print(queue)
                if r == m and c == n:
                    cleared = True
                    queue = []
                    break
                else:
                    if lst[r - 1][c - 1] not in ran_lst:
                        #print(queue)
                        queue.append(lst[r - 1][c - 1])
                        ran_lst.append(lst[r - 1][c - 1])
                    bool_lst[r-1][c-1] = True

        '''bool_lst[i-1][int(num/i)-1] = True
        bool_lst[int(num/i)-1][i-1] = True'''

if cleared:
    print("yes")
else:
    print("no")
