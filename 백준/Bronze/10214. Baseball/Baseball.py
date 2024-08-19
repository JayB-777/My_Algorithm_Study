T = int(input())
for i in range(0,T):
  score_y = 0 
  score_k = 0
  for j in range(0, 9):
    input_score_y, input_score_k = map(int, input().split())
    score_y += input_score_y
    score_k += input_score_k
  
  if(score_y > score_k):
    print("Yonsei")
  elif(score_y < score_k):
    print("Korea")
  else:
    print("Draw")

