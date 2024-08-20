N = int(input())
leftover_apple = 0
for i in range(N):
    stu_num, apple_num = map(int, input().split())
    leftover_apple += apple_num % stu_num
print(leftover_apple)
