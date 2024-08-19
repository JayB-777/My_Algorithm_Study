n = int(input())
A_score = 100
B_score = 100
for i in range(0, n):
  A, B = map(int, input().split())
  if(A < B):
    A_score -= B
  elif(A > B):
    B_score -= A
  else:
    continue

print(A_score)
print(B_score)