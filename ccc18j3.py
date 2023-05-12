import math

lst = input().split()
location = [0]

for i in range(len(lst)):
    location.append(location[i]+int(lst[i]))

for i in range(5):
    num = location[i]
    store = ""
    for element in location:
        store += str(abs(element-num)) + " "
    print(store)
