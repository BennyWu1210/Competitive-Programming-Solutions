
lst = []
c_lst = []
N = int(input())
for i in range(N):
    lst.append(int(input()))


def sort():
    sorting = True
    count = 0
    i = 0
    while i < len(lst):
        count = 10**3
        for index in range(len(lst)):
            if lst.count(lst[index]) < count:
                count = lst.count(lst[index])
                store = index
        i += 1





def calculate():
    calculating = True
    index = 1
    diff = -10 ** 3
    while calculating:
        if index+1 >= len(lst):
            calculating = False
        num = lst[index]
        num_2 = lst[index-1]
        if abs(num_2-num) >= diff:
            diff = num_2-num

