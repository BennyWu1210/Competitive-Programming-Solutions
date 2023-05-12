import sys

parent = []
def union():
N, Q = [int(x) for x in sys.stdin.readline().split()]

for i in range(6):
    query, x, y = [int(x) for x in sys.stdin.readline().split()]
    if query ==