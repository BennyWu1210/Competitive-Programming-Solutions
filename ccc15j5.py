import math

pieces = int(input())
people = int(input())
#print(pieces, people)
counter = 1
lst = []
store_lst = []

for i in range(people-1):
    lst.append(1)
lst.append(pieces-(people-1))




def check_list(lst):
    difference_counter = 0
    for i in range(len(lst)-1, 0, -1):
        if lst[i] - lst[i-1] > 1:
            return True
        elif lst[i] - lst[i-1] == 1:
            difference_counter += 1
    if difference_counter > 1:
        return True
    else:
        return False




def check_index(lst, index):
    for i in range(index, -1, -1):
        '''
        if lst[i] > lst[index]:
            print('hiu', lst[i], lst[index])
            return -1
        '''
        if lst[index] - lst[i] > 1:
            return i

    return -1





def calculate(lst):
    global counter
    global store_lst
    s = []
    for i in lst:
        s.append(i)
    #index = people - 1
    while check_list(s):
        for index in range(people - 1, 0, -1):
            compare_index = check_index(s, index)
            if compare_index != -1 and s[index] > s[index-1]:
                print(s)
                s[compare_index] += 1
                s[index] -= 1
                counter += 1
                d = []
                for i in s:
                    d.append(i)
                print("d" + str(d))
                if d not in store_lst:
                    print('added')
                    store_lst.append(s)

    print(store_lst)
    '''
    for i in store_lst:
        calculate(i)
        '''


calculate(lst)





        #print(index)




'''
if people > 2 and pieces > int(people/2) * people + 1:
    counter += math.pow(int(people/2), pieces - people * int(people/2) - int(people/2))
'''
print(store_lst, counter)





