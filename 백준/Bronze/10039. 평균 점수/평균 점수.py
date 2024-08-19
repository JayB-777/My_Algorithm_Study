arr=[0]*5
for i in range(0,5):
  score = int(input())
  if(score<40):
    score = 40
  arr[i] = score

sum = 0
for i in arr:
  sum += i

avg = int(sum / 5)
print(avg)  