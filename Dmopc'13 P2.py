t = int(input())
s = input()
year, month, day, hour, minute, second = int(s[0:4]), int(s[5:7]), int(s[8:10]), \
                                         int(s[11:13]), s[14:16], s[17:19]

while t > 0:
    hour -= 1

    if hour < 0:
        day -= 1
        hour = 23

    if day < 1:
        month -= 1
        if month < 1:
            month = 12
            year -= 1
            day = 31
        elif month == 1 or month == 3 or month == 5 or month == 7 or month == 8 or month == 10:
            day = 31
        elif month == 2:
            day = 28
        else:
            day = 30
    t -= 1


if month < 10:
    month = "0" + str(month)
if day < 10:
    day = "0" + str(day)
if hour < 10:
    hour = "0" + str(hour)

print(str(year) + "/" + str(month) + "/" + str(day) + " " + str(hour) + ":" + minute + ":" + second)





