import sys
import functools


class Edge():
    def __init__(self, bv, ev, cost, t):
        self.bv = bv
        self.ev = ev
        self.cost = cost
        self.type = t

    def __gt__(self, other):
        return self.cost > other.cost


class DisjointSet():

    def __init__(self, n):
        self.parent = []
        self.num_left = n
        # for i in range(1, n + 1):
        #     self.parent.append(i)
        self.parent = [i for i in range(1, n+1)]
        #print(self.parent)

    def get_num(self):
        return self.num_left

    @functools.lru_cache(1)
    def find(self, city):
        if self.parent[city-1] == city:
            return city
        else:
            self.parent[city-1] = self.find(self.parent[city-1])
            return self.parent[city-1]

    def union(self, a, b):
        self.parent[a-1] = b


def find(self, vertex):
    if self.parent[vertex] == -1:
        return vertex
    else:
        self.parent[vertex] = self.find(self.parent[vertex])
        return self.parent[vertex]



total_cost = 0
mst_cost = 0
queue = []

test_input = '''2 3 4 1
2 3 5
3 2 7
1 2 6
1 1 8
2 1 5'''

# ipt = input().split(" ")
# # all_ipt = test_input.split("\n")
# # ipt = all_ipt[0].split(" ")
#
# N = int(ipt[0])
# M = int(ipt[1])
# P = int(ipt[2])
# Q = int(ipt[3])

N, M, P, Q = [int(x) for x in sys.stdin.readline().split()]

for i in range(P):
    # ipt = input().split(" ")
    # # ipt = all_ipt[i + 1].split(" ")
    # bv = int(ipt[0])
    # ev = int(ipt[1])
    # cost = int(ipt[2])
    # queue.append(Edge(bv, ev, cost, True))  # True is flight!

    a, b, c = [int(x) for x in sys.stdin.readline().split()]
    queue.append(Edge(a, b, c, True))

for i in range(Q):
    # ipt = input().split(" ")
    # # ipt = all_ipt[i + P + 1].split(" ")
    # bv = int(ipt[0])
    # ev = int(ipt[1])
    # cost = int(ipt[2])
    # queue.append(Edge(bv, ev, cost, False))  # False is portal!
    a, b, c = [int(x) for x in sys.stdin.readline().split()]
    queue.append(Edge(a, b, c, False))

queue.sort()
planets = DisjointSet(N)
cities = DisjointSet(M)
# print(planets.parent)
# print(cities.parent)
# print("cities", cities.find(2))
# print("cities", cities.find(3))

while len(queue) > 0:
    e = queue.pop(0)

    if e.type:  # FLIGHTS
        # print('flights')
        # print(e.bv, e.ev, e.cost, e.type)
        total_cost += N * e.cost
        # print(cities.find(e.bv))
        # print(cities.find(e.ev))
        if cities.num_left != 0 and cities.find(e.bv) != cities.find(e.ev):
            mst_cost += planets.num_left * e.cost
            cities.union(cities.find(e.bv), cities.find(e.ev))
            # print(cities.parent)
            cities.num_left -= 1

    else:  # PLANETS
        # print('planets')
        # print(e.bv, e.ev, e.cost, e.type)
        total_cost += M * e.cost
        # print(cities.find(e.bv))
        # print(cities.find(e.ev))
        if planets.num_left != 0 and planets.find(e.bv) != planets.find(e.ev):
            mst_cost += cities.num_left * e.cost
            planets.union(planets.find(e.bv), planets.find(e.ev))
            # print(planets.parent)
            planets.num_left -= 1

# print(total_cost, mst_cost)
print(total_cost - mst_cost)
