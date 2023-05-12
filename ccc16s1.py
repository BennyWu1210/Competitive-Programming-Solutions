A = list(input())
B = list(input())
num_stars = 0


char = 0
while char < len(B):
    if B[char] == "*":
        B.pop(char) # remove star
        num_stars += 1
        char -= 1
    char += 1


for char in range(num_stars):
    B.append("*")


def calculate():
    index = 0
    while len(A) != num_stars:
        if B[index] in A:
            A.remove(B[index])
            B.pop(index)
            index -= 1
        else:
            return False
        index += 1
    return True


if calculate():
    print("A")
else:
    print("N")

