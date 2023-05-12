height = {"one": [1,2,3], "two": [1,2], "three": [1,2,3,4,5], 'four': [1,2,3,4,5,6,7]}
sorted_dict = sorted(height.items(), key=lambda kv: len(kv[1]), reverse=True)
print(len(sorted_dict[3][1]))
'''
lst1 = [1, 2, 3, 4]
lst2 = [i for i in lst1]
n = 'cool'
height = {}
height[n] = [0, 1]
lst2.remove(1)
print(lst1)
print(lst2)
height[n].append(lst1[0])
height[n].append(lst1[1])
print(10 in height[n])
print(height)
'''

lst1 = [1, 2, 3, 4]
lst2 = lst1
lst2.remove(1)
print(lst1)
print(lst2)

