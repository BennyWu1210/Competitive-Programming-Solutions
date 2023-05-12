import math

x = int(input())
y = int(input())
size = int(math.sqrt(y-x+1)) + 1
lst = []

for i in range(size):
    lst.append([])
    if size*(size-1) >= y-x+1:
        for j in range(size-1):
            lst[i].append([])
            lst[i][j] = ""
        sizeX = size-1
    else:
        for j in range(size):
            lst[i].append([])
            lst[i][j] = ""
        sizeX = size


def calculating():
    x_index = math.ceil(size/2)-1
    y_index = math.ceil(sizeX/2)-1
    num = x
    add = 1
    while x_index < size and y_index < sizeX and num <= y:
        for i in range(add):
            if x_index < size and y_index < size and num <= y:
                lst[x_index][y_index] = str(num)
                x_index += 1
                num += 1

        for i in range(add):
            if x_index < size and y_index < size and num <= y:
                lst[x_index][y_index] = str(num)
                y_index += 1
                num += 1

        add += 1

        for i in range(add):
            if x_index < size and y_index < size and num <= y:
                lst[x_index][y_index] = str(num)
                x_index -= 1
                num += 1

        for i in range(add):
            if x_index < size and y_index < sizeX and num <= y:
                lst[x_index][y_index] = str(num)
                y_index -= 1
                num += 1

            add += 1


calculating()


for row in lst:
    txt = ""
    for num in row:
        if num is "":
            txt += "  "
        if len(str(num)) == 1:
            txt += " "
        txt += num + " "
    print(txt)




