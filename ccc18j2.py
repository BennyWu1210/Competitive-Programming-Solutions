N = int(input())
lst = []
count = 0
for i in range(2):
    lst.append(input())


def calculating():
    global count
    for i in range(N):
        if lst[0][i] == lst[1][i] == 'C':
            count += 1
    print(count)

calculating()
