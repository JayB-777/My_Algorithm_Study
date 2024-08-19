import sys

T = int(input())
A = 0 
B = 0 
C = 0

if(T % 10 != 0):
  print(-1)
  sys.exit()
else:
  if(T>=300):
    A = T // 300
    T = T % 300
  if(T>=60):
    B = T // 60
    T = T % 60
  if(T>=10):
    C = T // 10

print(A, B, C)
