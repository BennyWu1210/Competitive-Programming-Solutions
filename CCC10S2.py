#lst = "abcdefg"
#print(lst[5:2])
import time
import sys

k = int(input())
dic = {}

for i in range(k):
    ipt = input().split(" ")
    dic[ipt[1]] = ipt[0]


code = input()
store = ""
length = 1
index = 0

start_t = time.time()
while index < len(code):
    string = code[index:length]
    #print(string + ": ---> " + str(index) + " " + str(length))

    if string in dic:
        store += dic[string]
        length = index + 1
        index += len(string)

    else:
        if time.time() - start_t > 1.9:
            print("ended")
            sys.exit()
        length += 1


print(store)

