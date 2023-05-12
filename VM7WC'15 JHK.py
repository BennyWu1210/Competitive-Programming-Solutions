
def SieveOfEratosthenes(n, prime):
    # Create a boolean array "prime[0..n]" and initialize
    # all entries it as true. A value in prime[i] will
    # finally be false if i is Not a prime, else true.
    p = 2
    while p * p <= n:

        # If prime[p] is not changed, then it is a prime
        if prime[p]:
            # Update all multiples of p
            for i in range(p * 2, n + 1, p):
                prime[i] = False
        p += 1
    prime[0] = False
    prime[1] = False
    counter = 0
    for num in prime:
        if num:
            counter += 1

    return counter


ipt = input().split()
N = int(ipt[0])
K = int(ipt[1])
lst = [True for i in range(N + 1)]

counter = SieveOfEratosthenes(N, lst)
if K == 1:
    print(counter)
elif K == 2:
    counter2 = 0
    for i in range(4, N+1):
        if not lst[i] and (i % 2 == 0 or lst[i-2]):
            counter2 += 1
    print(counter2)
elif K == 3:
    counter2 = 0
    for i in range(N+1):
        if not lst[i] and (i % 2 == 0 or lst[i-2]):
            counter2 += 1
    print(N - counter - counter2)

else:
    print(0)







