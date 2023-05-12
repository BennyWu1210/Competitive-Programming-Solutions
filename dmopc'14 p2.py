import math

N = int(input())

WA_counter = 0
WA_changed = 0
IR_changed = 0
lst = []
output = []

for i in range(N):
    ipt = input()
    if ipt == "WA":
        WA_counter += 1

    lst.append(ipt)

for i in range(N):
    if lst[i] == "AC":
        output.append(lst[i])

    elif lst[i] == "WA":
        if WA_changed < math.floor(WA_counter*0.3):
            output.append("AC")
        else:
            output.append("WA")
        WA_changed += 1

    elif lst[i] == "TLE":
        output.append("WA")

    else:
        if IR_changed < 10:
            output.append("AC")
        elif IR_changed < 20:
            output.append("WA")
        else:
            output.append("IR")
        IR_changed += 1


for num in output:
    print(num)