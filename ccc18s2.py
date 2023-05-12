N = int(input())
lst = []
store = []
for i in range(N):
    lst.append([])
    lst[i] = input().split()


def check_final(l):
    global store
    for i in range(len(l)):
        smallest = -1
        for j in range(len(lst)):
            if int(l[j][i]) > int(smallest):
                smallest = l[j][i]
            else:
                store = []
                return False

    return True


def horizontal_right():
    global store
    row = 0
    for i in range(N):
        store.append([])
        min = -1
        for j in range(N):
            if int(lst[i][j]) > int(min):
                min = lst[i][j]
                store[row].append(min)
            else:
                store = []
                return False
        row += 1

    return check_final(store)


def horizontal_left():
    global store
    row = 0
    for i in range(N-1, -1, -1):
        store.append([])
        min = -1
        for j in range(N-1, -1, -1):
            if int(lst[i][j]) > int(min):
                min = lst[i][j]
                store[row].append(min)
            else:
                store = []
                return False
        row += 1
    return check_final(store)


def vertical_down():
    global store
    row = 0
    for i in range(N-1, -1, -1):
        store.append([])
        min = -1
        for j in range(N):
            if int(lst[j][i]) > int(min):
                min = lst[j][i]
                store[row].append(min)
            else:
                store = []
                return False
        row += 1

    return check_final(store)


def vertical_up():
    global store
    row = 0
    for i in range(N):
        store.append([])
        min = -1
        for j in range(N - 1, -1, -1):
            if int(lst[j][i]) > int(min):
                min = lst[j][i]
                store[row].append(min)
            else:
                store = []
                return False
        row += 1

    return check_final(store)


def output(l):
    for lst in l:
        print(" ".join(lst))


if horizontal_right():
    output(lst)
elif vertical_up():
    output(store)
elif horizontal_left():
    output(store)
elif vertical_down():
    output(store)

'''
3
4 3 1
6 5 2
9 7 3
'''