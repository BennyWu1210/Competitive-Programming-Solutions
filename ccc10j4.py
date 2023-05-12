

def calculate():

    while True:
        looped = False
        lst = list(input().split())
        n = lst[0]
        lst.pop(0)

        if n == "0":
            return

        for num in range(len(lst)):
            lst[num] = int(lst[num])

        index = 0
        diff_list = []

        while index+1 < len(lst):
            diff_list.append(lst[index+1]-lst[index])
            index += 1

        for i in range(1, len(lst)-1):
            if diff_list[i] == diff_list[0] and not looped:
                if 2*i < len(diff_list):
                    if diff_list[2*i] == diff_list[i]:
                        looped = True
                        print(i)

                else:
                    looped = True
                    print(i)
                break
        if not looped:
            print(len(diff_list))

        print(diff_list)




calculate()


