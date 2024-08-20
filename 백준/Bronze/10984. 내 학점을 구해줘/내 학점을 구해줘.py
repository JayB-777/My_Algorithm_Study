T = int(input())
for i in range(T):
    credit_sum = 0
    grade_sum = 0
    N = int(input())
    for j in range(N):
        credit, grade = map(float, input().split())
        credit_sum += int(credit)
        grade_sum += grade * credit
    print(credit_sum, f'{grade_sum/credit_sum:.1f}')