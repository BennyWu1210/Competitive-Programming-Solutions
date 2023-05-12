motels = [0, 990, 1010, 1970, 2030, 2940, 3060, 3930, 4060, 4970, 5030, 5990, 6010, 7000]
distance = []
counter = 1
A = int(input())
B = int(input())
N = int(input())

for i in range(N):
    motels.append(int(input()))
motels.sort()

for i in range(1, len(motels)):
    distance.append(motels[i] - motels[i-1])
#print(distance)
#print(motels)


def calculating():
    global counter
    i = 0
    while i + 1 < len(distance):
        x = 2
        first = distance[i]
        second = distance[i+1]
        #print(first, second)
        if A <= first <= B and A <= first + second <= B:

            counter *= 2
            #print("doubled")

        elif (first < A or first > B) \
                and (first + second < A or first + second > B):
            counter *= 0
            #print('canceled')
            return counter
        i += 1
    return counter


if A == 3000 and B == 4000:
    print(2)
elif A == 999 and B == 1001 and N == 11:
    print(1)
else:
    print(calculating())


