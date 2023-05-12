T1 = input().split(":")
T2 = input().split(":")

Total1 = int(T1[0])*3600 + int(T1[1])*60 + int(T1[2])*1
Total2 = int(T2[0])*3600 + int(T2[1])*60 + int(T2[2])*1

print(Total2-Total1)