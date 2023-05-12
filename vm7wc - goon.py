ipt = input().split("-")

sum_1 = 0
sum_2 = 0
sum_3 = 0

for num in list(ipt[0]):
    sum_1 += int(num)

for num in list(ipt[1]):
    sum_2 += int(num)

for num in list(ipt[2]):
    sum_3 += int(num)

if sum_1 == sum_2 == sum_3:
    print("Goony!")
else:
    print("Pick up the phone!")