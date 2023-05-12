R = int(input())
L = int(input())
lst = []

for i in range(R):
    lst.append([])
    lst[i] = input().split()


#print(lst)

possibility = 1

if R <= 2:
    pass
else:
    for c in range(L):
        one_solution = True
        for r in range(1, R):
            #print(lst[r - 1][c], lst[r][c], lst[r][c])
            #print(lst[r-1][c] == lst[r][c] and lst[r][c] == "0")
            #print(lst[r-1][c] != lst[r][c] and lst[r][c] == "1")
            #if r == R-1:

            if not ((lst[r-1][c] == lst[r][c] and lst[r][c] == "0")
                    or (lst[r-1][c] != lst[r][c] and lst[r][c] == "1")):
                one_solution = False
                #print('ffff')
                break

        if not one_solution:
            #print("yay")

            possibility *= 2
            #print('noo')

print(possibility)










