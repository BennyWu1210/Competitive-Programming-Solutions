lst = ["*x*", " xx", "* *"]

num = int(input())

for i in range(3):
    string = ""
    for j in range(3):
        string += lst[i][j] * num
    for l in range(num):
        print(string)