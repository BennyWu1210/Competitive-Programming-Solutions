
year = int(input())
detect = True

while detect:
    year = int(year) + 1
    year = str(year)
    l = len(year)
    detect = False
    for i in range(l):
        for num in range(i+1, l):
            print(year)
            if year[i] == year[num]:
                detect = True
                break

print(year)








