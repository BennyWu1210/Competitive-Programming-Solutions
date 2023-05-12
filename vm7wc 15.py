
def swap(i, j, arr):
    arr[i], arr[j] = arr[j], arr[i]


N = int(input())


for i in range(N):
    counter = 0
    L = int(input())
    lst = input().split(" ")
    for j in range(L):
        lst[j] = int(lst[j])

    sorted = False
    while not sorted:
        sorted = True
        for j in range(1, len(lst)):
            if lst[j] < lst[j-1]:
                sorted = False
                swap(j, j-1, lst)
                counter += 1
    print(counter)












