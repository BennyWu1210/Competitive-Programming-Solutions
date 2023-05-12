N = int(input())
horizontal = 0
vertical = 0

for i in range(N):
    direction = input()
    distance = int(input())
    if direction == "North":
        vertical += distance
    elif direction == "South":
        vertical -= distance
    elif direction == "East":
        horizontal += distance
    else:
        horizontal -= distance

print(horizontal, vertical)

