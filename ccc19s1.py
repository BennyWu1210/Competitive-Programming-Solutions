ipt = input()
lst = [[1,2], [3,4]]


def h():
    lst[0], lst[1] = lst[1], lst[0]


def v():
    lst[0][0], lst[0][1] = lst[0][1], lst[0][0]
    lst[1][0], lst[1][1] = lst[1][1], lst[1][0]


for i in ipt:
    if i == 'H':
        h()
    else:
        v()

for i in lst:
    print(i[0], i[1])