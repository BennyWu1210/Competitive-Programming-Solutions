import math

m = int(input())
n = int(input())
lst = []
bool_lst = []
ran_lst = []
checked = []
cleared = False

for i in range(m):
    lst.append([])
    bool_lst.append([])
    lst[i] = input().split()
    for j in range(n):
        lst[i][j] = int(lst[i][j])
        bool_lst[i].append(False)


r = 1
c = 1
queue = [[m, n]]
ran_lst = [queue[0]]
bool_lst[m-1][n-1] = True

while len(queue) > 0:
    num = queue[0]
    queue.pop(0)
    for i in range(0, m):
        for j in range(0, n):
            if lst[i][j] == num[0]*num[1] and not bool_lst[i][j]:
                bool_lst[i][j] = True
                queue.append([i+1, j+1])
                #print(i, j, queue)
                if i == 0 and j == 0:
                    queue = []
                    cleared = True
                    break


if cleared:
    print("yes")
else:
    print("no")
