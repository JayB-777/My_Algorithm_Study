N = int(input())
count_like = 0
count_dislike = 0
for i in range(0,N):
  input_num = int(input())
  if(input_num == 1):
    count_like += 1
  elif(input_num == 0):
    count_dislike += 1

if(count_like > count_dislike):
  print("Junhee is cute!")
else:
  print("Junhee is not cute!")