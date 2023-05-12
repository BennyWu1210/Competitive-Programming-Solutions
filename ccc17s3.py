
N = int(input())
l = input().split()
lst = [int(i) for i in l]
lst.sort()
height = {}


def calculate(a, b):

    for j in range(b, a, -1):
        # print(height)
        # print(lst[a], lst[j])
        # print(j, a)
        n = lst[a] + lst[j]
        if n in height:
            '''print(lst.count(a))
            print(height[n].count(a))
            print(height)
            print(lst)'''
            if lst.count(lst[a]) > height[n].count(lst[a]) and lst.count(lst[j]) > height[n].count(lst[j]):
                height[n].append(lst[a])
                height[n].append(lst[j])
            else:
                break

        else:
            height[n] = [lst[a], lst[j]]


y = len(l)-1

for i in range(y):
    x = i
    calculate(x, y)

sorted_dict = sorted(height.items(), key=lambda kv: len(kv[1]), reverse=True)

num = 0
for x in height.values():
    h = len(x)
    break

value = len(sorted_dict[0][1])
# print(value)
for k in sorted_dict:
    # print(k[1])
    if len(k[1]) == value:
        num += 1
    else:
        break

'''print(sorted_dict)
print(height)'''
print(round(h/2), num)

