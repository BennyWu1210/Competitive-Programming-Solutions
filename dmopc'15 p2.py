ipt = input().split()
N = int(ipt[0])
L = int(ipt[1])
R = int(ipt[2])

strength = list(input().split())
for i in range(len(strength)):
    strength[i] = int(strength[i])
counter = 0

i = 0
strength.sort()

while len(strength) > 0:
    #print(strength[-1])
    i += 1
    if i > L:
        i = 1

    if i == R:
        #print("yay")
        counter += int(strength[-1])

    strength.pop(-1)

print(counter)




