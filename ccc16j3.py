string = input()
result = 0

for char in range(1, len(string)-1):
    if string[char] == string[char+1]:
        counter = 2
        backwards = char-1
        forwards = char+2
    else:
        counter = 1
        backwards = char-1
        forwards = char+1
    while forwards < len(string) and backwards >= 0 and string[forwards] == string[backwards]:
        #print(char, string[forwards], string[backwards])
        backwards -= 1
        forwards += 1
        counter += 2

    if counter > result:
        result = counter



print(result)
