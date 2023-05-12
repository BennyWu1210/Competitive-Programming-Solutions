_input = input()
hh = int(_input[:2])
mm = int(_input[3:])
past_min = 0

while past_min < 120:
    past_min += 1
    if 7 <= hh < 10 or 15 <= hh < 19:
        mm += 2
    else:
        mm += 1

    # Check for hours and minutes that exceed the range
    if mm >= 60:
        mm -= 60
        hh += 1
    if hh >= 24:
        hh -= 24

if hh < 10:
    hh = "0" + str(hh)

if mm == 0:
    mm = "00"
elif mm < 10:
    mm == "0" + str(mm)

print(str(hh) + ":" + str(mm))



