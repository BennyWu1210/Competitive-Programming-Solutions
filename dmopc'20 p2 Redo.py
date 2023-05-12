import math
import sys

N, M = [int(x) for x in sys.stdin.readline().split()]
n_pos = 0
m_pos = 0
prev_m = m_pos
angle = math.atan(N/M)  # IN RADIANS
lst = []
counter = 0
inc = float(format(1/math.tan(angle), '.3f'))

#print(N/math.tan(angle))

while True:
    n_pos += 1
    m_pos = float(format(n_pos/math.tan(angle), '.5f'))
    #print(m_pos)
    if n_pos > N or m_pos > M:
        break

    for i in range(math.floor(prev_m), math.floor(m_pos)+1, 1):
        lst.append((n_pos, i+1))
        counter += 1
        #print(lst)
    if m_pos.is_integer():
        #print('removed!')
        lst.remove((n_pos, int(m_pos+1)))
        counter -= 1

    prev_m = m_pos
    #print(n_pos, m_pos)

print(counter)
for nums in lst:
    print(nums[0], nums[1])




