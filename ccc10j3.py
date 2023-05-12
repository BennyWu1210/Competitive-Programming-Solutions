import math

A = 0
B = 0
executing = True

'''
while executing:
    try:
        ipt = input()
        if ipt == 7:
            executing = False

        elif ipt[0] == "1":
            if ipt[2] == "A":
                A = int(ipt[4])
            else:
                B = int(ipt[4])

        elif ipt[0] == "2":
            if ipt[2] == "A":
                print(A)
            else:
                print(B)

        elif ipt[0] == "3":
            A = A + B

        elif ipt[0] == "4":
            A = A * B

        elif ipt[0] == "5":
            if ipt[2] == "A":
                if ipt[4] == "B":
                    A = A - B
                else:
                    A = 0
            else:
                if ipt[4] == "A":
                    A = B - A
                else:
                    A = 0

        elif ipt[0] == "6":
            if ipt[2] == "A":
                if ipt[4] == "B":
                    A = math.floor(A/B)
                else:
                    A = 1
            else:
                if ipt[4] == "A":
                    B = math.floor(B/A)
                else:
                    A = 1
    except (EOFError or ValueError) as e:
        pass
'''

while executing:
    ipt = input()

    if ipt == "7":
        executing = False
        break

    elif ipt[0] == "1":
        if ipt[2] == "A":
            A = int(ipt[4:])
        else:
            B = int(ipt[4:])

    elif ipt[0] == "2":
        if ipt[2] == "A":
            print(A)
        else:
            print(B)

    elif ipt[0] == "3":
        if ipt[2] == "A":
            if ipt[4] == "B":
                A = A + B
            else:
                A = A + A
        else:
            if ipt[4] == "A":
                B = A + B
            else:
                B = B + B

    elif ipt[0] == "4":
        if ipt[2] == "A":
            if ipt[4] == "B":
                A = A * B
            else:
                A = A * A
        else:
            if ipt[4] == "A":
                B = A * B
            else:
                B = B * B

    elif ipt[0] == "5":
        if ipt[2] == "A":
            if ipt[4] == "B":
                A = A - B
            else:
                A = 0
        else:
            if ipt[4] == "A":
                B = B - A
            else:
                B = 0

    elif ipt[0] == "6":
        if ipt[2] == "A":
            if ipt[4] == "B":
                A = int(math.floor(A/B))
            else:
                A = 1
        else:
            if ipt[4] == "A":
                B = int(math.floor(B/A))
            else:
                B = 1













