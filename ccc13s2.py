import sys

W = int(input())
N = int(input())
lst = []

for i in range(N):
    ipt = int(input())
    lst.append(ipt)

weight_counter = 0
car_counter = 0
if N > 4:
    for i in range(4):
        if weight_counter + lst[i] <= W:
            weight_counter += lst[i]
            car_counter += 1
        else:
            weight_counter = W + 1
            break
else:
    for j in range(len(lst)):
        if weight_counter + lst[j] <= W:
            weight_counter += lst[j]
            car_counter += 1
        else:
            weight_counter = W + 1
            break

endurable = (weight_counter <= W)

index = 0
index_end = 3
while endurable and index_end+1 < len(lst):
    if weight_counter - lst[index] + lst[index_end+1] <= W:
        weight_counter = weight_counter + lst[index_end + 1] - lst[index]
        index += 1
        index_end += 1
        car_counter += 1
    else:
        endurable = False

print(car_counter)
