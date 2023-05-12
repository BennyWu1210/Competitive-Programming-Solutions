import string
a_lst, K, code, string = list(string.ascii_uppercase),  int(input()), list(input()), ''

for index in range(len(code)):
    string += a_lst[(a_lst.index(code[index]) - (3*(index+1) + K)) % 26]

print(string)




