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
    lst[i] = list(map(int, input().split()))

for i in range(1000001):
    bool_lst.append(False)


queue = [lst[0][0]]


while len(queue) > 0:
    num = queue[0]
    queue.pop(0)

    if not bool_lst[num] and num <= m*n:
        bool_lst[num] = True

        for i in range(1, int(math.sqrt(num)) + 1, 1):
            if num % i == 0:
                r = i
                c = int(num / i)

                if (r == m and c == n) or (r == n and c == m):
                    cleared = True
                    queue = []
                    break

                if r <= m and c <= n and not bool_lst[lst[r-1][c-1]] and lst[r-1][c-1] not in queue:
                    # print(r,c)
                    # print(queue)
                    '''
                    if r != m or c != n:
                        queue.append(lst[r - 1][c - 1])
                    else:
                        cleared = True
                        queue = []
                        break
                    '''
                    queue.append(lst[r - 1][c - 1])

                r, c = c, r
                if r <= m and c <= n and not bool_lst[lst[r-1][c-1]] and lst[r-1][c-1] not in queue:
                    # print(r,c)
                    # print(queue)
                    '''
                    if r != m or c != n:
                        queue.append(lst[r - 1][c - 1])
                    else:
                        cleared = True
                        queue = []
                        break
                    '''
                    queue.append(lst[r - 1][c - 1])
    else:
        continue


if cleared:
    print("yes")
else:
    print("no")
