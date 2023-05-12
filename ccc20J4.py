#
# T = input()
# S = list(input())
#
#
# def detect():
#     for i in range(len(S)):
#         S.insert(0, S[-1])
#         S.pop(-1)
#         string = "".join(S)
#         if string in T:
#             return True
#     return False
#
#
# if detect():
#     print("yes")
# else:
#     print("no")


t = input()
s = input()
hasAns = False
list = []

for i in range (len(s)):
    list.append(s[i:]+s[:i])


for string in list:
    if string in t:
        hasAns = True
        break

if hasAns:
    print("yes")
else:
    print("no")
