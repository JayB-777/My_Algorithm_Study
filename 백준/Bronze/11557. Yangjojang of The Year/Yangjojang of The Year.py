T = int(input())
for i in range(0, T):
  univ = []
  alcohol = []
  N = int(input())
  for j in range(0, N):
    univ_input, alcohol_input = input().split()
    univ.append(univ_input)
    alcohol.append(int(alcohol_input))
  flag_index = 0
  for k in range(0, N-1):
    if(alcohol[k] < alcohol[k+1]):
      flag_index = k+1
  print(univ[flag_index])