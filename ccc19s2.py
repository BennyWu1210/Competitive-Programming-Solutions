'''
N = int(input())


def find_num(x):
    a = x
    b = x
    finding = True
    while finding:

        finding = False
        for i in range(2, int(pow(a, 1/2))+1):
            if a % i == 0:
                finding = True
                break
        if not finding:
            for j in range(2, int(pow(a, 1/2))+1):
                if b % j == 0:
                    finding = True
                    break

        if not finding:
            print(a, b)
            return
        a += 1
        b -= 1


for i in range(N):
    ipt = int(input())
    find_num(ipt)



'''

N = int(input())


def calculate(x):
    for b in range(x, 2, -1):
        prime = True
        for j in range(2, (int(pow(b, 1/2))+1)):
            if b % j == 0:
                prime = False
                break
        if prime:
            a = 2*x - b
            prime2 = True
            for k in range(2,(int(pow(a, 1/2))+1)):
                if a % k == 0:
                    prime2 = False
            if prime2:
                print(a, b)
                break


for i in range(N):
    num = int(input())
    calculate(num)
