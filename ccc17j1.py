# # read integer input
# x = input()
# y = input()
#
# if x > 0 and y > 0:  # quadrant 1
#     print(1)
# elif x < 0 and y < 0:  # quadrant 2
#     print(2)
# elif x > 0 and y < 0:  # quadrant 3
#     print(3)
# elif x < 0 and y > 0:  # quadrant 4
#     print(4)
#
#

input_commands = input()  # read string input
lst = [[1, 2], [3, 4]]  # original list

# Please ignore the following line if you have not learned for loops yet
# (for i in input_commands...), just focus on the debugging parts.
# It is guaranteed that there will not be any error on that particular line

for i in input_commands:
    if i == 'H':  # horizontal flip
        lst[0][0], lst[1][0] = lst[1][0], lst[0][0]
        lst[0][1], lst[1][1] = lst[1][1], lst[0][1]
    elif i == 'V':  # vertical flip
        lst[0][0], lst[0][1] = lst[0][1], lst[0][0]
        lst[1][0], lst[1][1] = lst[1][1], lst[1][0]


print(lst[0][0], lst[0][1])  # print first row
print(lst[1][0], lst[1][1])  # print second row
