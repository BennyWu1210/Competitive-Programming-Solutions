import sys
import math


N, M = [int(x) for x in sys.stdin.readline().split()]
adjList = [[] for i in range(N)]
temp = []
edges = []
parents = []
visited = [False for i in range(N+1)]


class Edge:
    def __init__(self, b, e, cost):
        self.bv = b
        self.ev = e
        self.cost = cost

    def __gt__(self, other):
        return self.cost > other.cost  # Reversed


class AdjEdge:
    def __init__(self, b, cost):
        self.bv = b
        self.cost = cost


def binary_search(left, right, value):
    while left <= right:
        mid = math.floor((left+right)/2)
        if temp[mid].cost > value:  # Do it the other way around since the list is sorted in reverse order
            left = mid+1
        elif temp[mid].cost < value:
            right = mid-1
        else:
            return mid
    return left


def update():
    global parents, adjList
    parents = [-1 for i in range(N+1)]
    adjList = [[] for i in range(N+1)]
    mst()


def mst():
    for cur in temp:
        broot = find(cur.bv)
        eroot = find(cur.ev)
        if broot != eroot:

            adjList[cur.bv].append(AdjEdge(cur.ev, cur.cost))
            adjList[cur.ev].append(AdjEdge(cur.bv, cur.cost))
            #print(adjList)
            union(broot, eroot)


def find(vertex):
    if parents[vertex] == -1:
        return vertex
    else:
        parents[vertex] = find(parents[vertex])
        return parents[vertex]


def union(a, b):
    parents[b] = a


def dfs(vertex, final, cost):
    for edges in adjList[vertex]:
        if not visited[edges.bv] and edges.cost >= cost:
            visited[edges.bv] = True
            if visited[final]:
                break
            dfs(edges.bv, final, cost)


for i in range(M):
    bv, ev, cost = [int(x) for x in sys.stdin.readline().split()]
    edges.append(Edge(bv, ev, cost))

temp = edges.copy()
temp.sort(reverse=True)


update()
Q = int(input())
results = []


for i in range(Q):
    commands = input().split()
    if commands[0] == "1":  # Update the cost and replacing it in the correct slot
        m_i, x_i = int(commands[1]), int(commands[2])

        original = edges[m_i-1].cost
        edges[m_i-1].cost = x_i
        temp.pop(binary_search(0, N-1, original))
        temp.insert(binary_search(0, N-2, x_i), edges[m_i-1])

        update()
    elif commands[0] == "2":  # Find whether there is a path between a_i and b_i with cost under w_i
        a_i, b_i, w_i = int(commands[1]), int(commands[2]), int(commands[3])
        visited = [False for j in range(N+1)]
        dfs(a_i, b_i, w_i)
        if visited[b_i]:
            results.append(1)
        else:
            results.append(0)

for num in results:
    print(num)
# for j in parents:
#     print(j)
'''

3 4
1 2 3
2 3 3
2 1 1
1 2 1
6
2 1 2 4
2 2 3 2
1 1 4
2 1 2 4
1 2 1
2 2 3 2

'''
