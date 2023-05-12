inpt = input().split()
a = int(inpt[0])
b = int(inpt[1])

inpt = input().split()
c = int(inpt[0])
d = int(inpt[1])

bat = int(input())

bat_take = abs(d-b) + abs(c-a)

if abs(bat - bat_take) % 2 == 0 and bat>=bat_take:
    print("Y")
else:
    print("N")

