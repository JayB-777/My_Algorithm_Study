def is_prime(n):
    if n <= 1:
        return False
    if n == 2 or n == 3:
        return True
    if n % 2 == 0 or n % 3 == 0:
        return False
    i = 5
    while i * i <= n:
        if n % i == 0 or n % (i + 2) == 0:
            return False
        i += 6
    return True

N = int(input())
M = int(input())
result_sum = 0
result_min = None

for i in range(N, M+1):
    if is_prime(i):
        result_sum += i
        if result_min is None or i < result_min:
            result_min = i

if result_sum == 0:
    print(-1)
else:
    print(result_sum)
    print(result_min)

