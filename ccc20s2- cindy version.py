import math
m = int(input())
n = int(input())
lst = []
bool_lst = []
step = []
cleared = False

for i in range(m):
    lst.append([])
    step.append([])
    lst[i] = input().split()
    for j in range(n):
        step[i].append(1000001)
        lst[i][j] = int(lst[i][j])

for i in range(m*n+1):
    bool_lst.append(False)
'''
print(lst)
print(bool_lst)
'''

cur_r = 1
cur_c = 1
r_queue = [1]
c_queue = [1]
step[0][0] = 0

while len(r_queue) > 0:
    cur_r = r_queue[0]
    cur_c = c_queue[0]
    r_queue.pop(0)
    c_queue.pop(0)
    num = lst[cur_r-1][cur_c-1]

    if num <= m*n and not bool_lst[num]:
        bool_lst[num] = True

        for i in range(1, int(math.sqrt(num)) + 1, 1):
            if num % i == 0:
                r = i
                c = int(num / i)

                if (r == m and c == n) or (r == n and c == m):
                    cleared = True
                    step[m-1][n-1] = 0
                    r_queue = []
                    break

                if r <= m and c <= n and not bool_lst[lst[r-1][c-1]] and step[r-1][c-1] > step[cur_r-1][cur_c-1]+1:
                    step[r-1][c-1] = step[cur_r-1][cur_c-1] + 1
                    r_queue.append(r)
                    c_queue.append(c)

                r, c = c, r
                if r <= m and c <= n and not bool_lst[lst[r-1][c-1]] and step[r-1][c-1] > step[cur_r-1][cur_c-1]+1:
                    step[r-1][c-1] = step[cur_r-1][cur_c-1]+1
                    r_queue.append(r)
                    c_queue.append(c)
    else:
        continue


if step[m-1][n-1] != 1000001:
    print("yes")
else:
    print("no")
