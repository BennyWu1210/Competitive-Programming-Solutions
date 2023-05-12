A3 = int(input())
A2 = int(input())
A1 = int(input())
B3 = int(input())
B2 = int(input())
B1 = int(input())

A = 0
B = 0


A += 3*A3
A += 2*A2
A += A1

B += 3*B3
B += 2*B2
B += B1


if A > B:
    print("A")
elif B > A:
    print("B")
else:
    print("T")

