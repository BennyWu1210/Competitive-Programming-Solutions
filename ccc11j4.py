
lst = []
dic = {}


for i in range(401):
    lst.append([])
    for j in range(200):
        lst[i].append(False)


lst[200][0] = True
lst[200][1] = True
lst[200][2] = True
lst[201][2] = True
lst[202][2] = True
lst[203][2] = True
lst[203][3] = True
lst[203][4] = True
lst[204][4] = True
lst[205][4] = True
lst[205][3] = True
lst[205][2] = True
lst[206][2] = True
lst[207][2] = True
lst[207][3] = True
lst[207][4] = True
lst[207][5] = True
lst[207][6] = True
lst[206][6] = True
lst[205][6] = True
lst[204][6] = True
lst[203][6] = True
lst[202][6] = True
lst[201][6] = True
lst[200][6] = True
lst[199][6] = True
lst[199][5] = True
lst[199][4] = True


def check():
    x = 199
    y = 4
    while True:
        ipt = input().split()
        direction = ipt[0]
        steps = int(ipt[1])
        danger = False

        if direction == "q":
            return

        for i in range(steps):
            if direction == "u":
                y -= 1
            elif direction == "d":
                y += 1
            elif direction == "r":
                x += 1
            elif direction == "l":
                x -= 1
            if lst[x][y]:
                danger = True

            lst[x][y] = True

        if danger:
            print(x-200, -(y+1), "DANGER")
            return
        else:
            print(x-200, -(y+1), "safe")


check()












