from collections import defaultdict

N = int(input())
string = list(input())
dic = {}

i = 0
while i < len(string):
    if string[i] in dic:
        dic[string[i]] += 1
    else:
        dic[string[i]] = 1
    i += 1

#print(dic)
double_counter = 0
single_counter = 0
one_counter = 0
for element in dic.values():
    if element % 2 == 1:
        single_counter += 1
    else:
        double_counter += 1

if double_counter >= 1:
    if double_counter > single_counter:
        print(single_counter + 1)
    else:
        print(double_counter + (single_counter-double_counter))

else:
    print(double_counter + (single_counter-double_counter))
