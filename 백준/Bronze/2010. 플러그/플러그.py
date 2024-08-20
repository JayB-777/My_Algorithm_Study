import sys
N = int(sys.stdin.readline().rstrip())
total = int(sys.stdin.readline().rstrip())
for i in range(N - 1):
    total += int(sys.stdin.readline().rstrip()) - 1
print(total)