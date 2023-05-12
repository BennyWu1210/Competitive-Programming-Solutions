# Did it in java but resulted in "presentation error" dmoj
# No clue on how to solve that
# decide it to redo in python instead
# YAay

import sys
import math

# NVM NOW IT WORKS

N = int(input())
strength = list(map(int, input().split()))
sum = 0
for num in strength:
    sum += num

def switchPos(lst, index)
    if index + 1 > len(lst)
        return lst[0]
    original = lst[index]
    lst[index] = switchPos(lst, index + 1)
    return orginal
