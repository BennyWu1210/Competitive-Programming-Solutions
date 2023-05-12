import math
import sys

start = list(map(int, input().split()))
end = list(map(int, input().split()))

r_queue = []
c_queue = []
steps = []

for i in range(8):
    steps.append([])
    for j in range(8):
        steps[i].append(1000)


def check(R, C, oR, oC):
    if 1 <= R <= 8 and 1 <= C <= 8 and steps[R-1][C-1] > steps[oR-1][oC-1] + 1:
        steps[R-1][C-1] = steps[oR-1][oC-1] + 1
        r_queue.append(R)
        c_queue.append(C)


steps[start[0]-1][start[1]-1] = 0
r_queue.append(start[0])
c_queue.append(start[1])

while len(r_queue) > 0:
    r = r_queue.pop(0)
    c = c_queue.pop(0)
    #get_positions(r, c)
    check(r+1, c+2, r, c)
    check(r+2, c+1, r, c)
    check(r+2, c-1, r, c)
    check(r+1, c-2, r, c)
    check(r-1, c-2, r, c)
    check(r-2, c-1, r, c)
    check(r-2, c+1, r, c)
    check(r+1, c+2, r, c)

    #print(r_queue)
    #print(c_queue)
    if r == end[0] and c == end[1]:
        print(steps[r-1][c-1])
        sys.exit()
