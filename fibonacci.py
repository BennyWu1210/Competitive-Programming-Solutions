import time
import functools
start_time = time.time()

@functools.lru_cache(10)
def fibonacci(n):
    if n-1 == 1 or n-1 == 0:
        return 1
    return fibonacci(n-1) + fibonacci(n-2)


print(fibonacci(400))
print(time.time() - start_time)


