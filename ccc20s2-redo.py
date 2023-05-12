import math
import sys
import time
# start = time.time()
# for i in range(10000000):
#     a = math.sqrt(1000000)
# print(time.time() - start)
#
# start = time.time()
# for i in range(10000000):
#     a = math.pow(1000000, 0.5)
# print(time.time() - start)


M = int(input())
N = int(input())

graph = []
for i in range(M):
    graph.append(input().split())


visited = []
for i in range(M):
    visited.append([False for i in range(N)])


#print(graph)
#print(visited)

queue = [(0, 0)]
boo = [False for i in range(1000001)]

while len(queue) > 0:
    coord = queue.pop(0)
    x = coord[0]
    y = coord[1]
    num = int(graph[x][y])
    #print(x, y)
    if not boo[int(graph[x][y])]:
        for i in range(1, int(math.sqrt(num))+1):
            if num % i == 0:
                a = i - 1
                b = int(num/i) - 1
                if (a == N-1 and b == M-1) or (a == M-1 and b == N-1):
                    print("yes")
                    sys.exit()
                if a != b:
                    if a < M and b < N and not visited[a][b]:
                        queue.append((a, b))
                        visited[a][b] = True

                    if a < N and b < M and not visited[b][a]:
                        queue.append((b, a))
                        visited[b][a] = True
                else:
                    if a < M and not visited[a][b]:
                        queue.append((a, b))
                        visited[a][b] = True
    if x < M and y < N:
        boo[int(graph[x][y])] = True
    elif x < N and y < M:
        boo[int(graph[y][x])] = True

print("no")

















