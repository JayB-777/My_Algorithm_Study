import math

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

t = int(input())
input_num = input()
total = 0
arr = list(input_num.split())
for i in range(t):
    target_num = int(arr[i])
    if is_prime(target_num):
        total += 1
print(total)