import sys
import math


def find_bowl(bowl, target):
    for num in range(len(lst)):
        if (lst[num] + bowl)/2 == target:
            return 1
        if (lst[num] + bowl)/2 > target:
            # if (bowl - target) + lst[0] >= target:
            #     return 0
            # else:
            #     return -1
            return 0
    return -1


N = int(input())
lst = [int(x) for x in sys.stdin.readline().split()]
lst.sort(reverse=False)
dic = {}

maximum = -1
for i in range(len(lst)):
    if lst[i] in dic:
        dic[lst[i]] += 1
    else:
        dic[lst[i]] = 1
    if dic[lst[i]] > maximum:
        maximum = dic[lst[i]]

dic = {k: v for k, v in sorted(dic.items(), key=lambda item: item[1], reverse=True)}

targets = []
for i in range(len(lst)):
    if dic[lst[i]] >= maximum - 2:
        if lst[i] not in targets:
            targets.append(lst[i])


# print("targets" + str(targets))
# print(dic)
# print(sorted(dic.values())[-1])
bowl_index = len(lst) - 1
target_index = 0
largest = -1
while bowl_index >= 0:
    #print('ysy')
    if target_index >= len(targets):
        bowl_index -= 1
        target_index = 0
        continue
    # print(lst)
    # print(bowl_index)
    amount = lst[bowl_index]
    # print(targets)
    # print(target_index)
    target = targets[target_index]
    result = find_bowl(amount, target)
    # print(amount, target, result)
    if amount == target:
        target_index += 1
        continue

    if result == 1:
        print(dic[target]+2)
        sys.exit()
    elif result == 0:
        if dic[target] + 1 > largest:
            largest = dic[target] + 1
        target_index += 1
        continue
    elif result == -1:
        target_index = 0
        bowl_index -= 1
        if dic[target] > largest:
            largest = dic[target]
        continue

if largest > sorted(dic.values())[-1]:
    print(largest)
else:
    print(sorted(dic.values())[-1])













