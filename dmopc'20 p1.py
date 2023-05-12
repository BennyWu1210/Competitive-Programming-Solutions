S = input()
T = input()

overlap_counter = 0
i = 0

while i < len(S) and i < len(T):
    if S[i] == T[i]:
        overlap_counter += 1
    else:
        break
    i += 1


print(len(S) + len(T) - overlap_counter*2)