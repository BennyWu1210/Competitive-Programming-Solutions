w = int(input())
lst = ["WELCOME", "TO", "CCC", "GOOD", "LUCK", "TODAY"]
index = 0
calculating = True
total_words = 0


while index < len(lst):
    string = lst[index]

    while (index + 1) < len(lst) and len(string+lst[index+1])+1 < w:
        string += lst[index+1] + " "
        total_words += 1
        print(string)
        print(index)
        index += 1







