import datetime

N = int(input())

for i in range(N):
    ipt = input()
    if ipt[0] == "-":
        year = int(ipt[0:5])
        month = int(ipt[6:8])
        day = int(ipt[9:11])
    else:
        year = int(ipt[0:4])
        month = int(ipt[5:7])
        day = int(ipt[8:10])

    date = datetime.date(year, month, day)
    day_week = date.isoweekday()
    print(day_week.)
    # if day_week == 1:
    #     print("Monday")
    # elif day_week == 2:
    #     print("Tuesday")
    # elif day_week == 3:
    #     print("Wednesday")
    # elif day_week == 4:
    #     print("Thursday")
    # elif day_week == 5:
    #     print("Friday")
    # elif day_week == 6:
    #     print("Saturday")
    # else:
    #     print("Sunday")