a = int(input())
b = int(input())
c = int(input())
d = int(input())


def calculate():
    if a != 8 and a != 9:
        return False
    if d != 8 and d !=9:
        return False
    if b != c:
        return False
    return True


if calculate():
    print("ignore")
else:
    print("answer")
