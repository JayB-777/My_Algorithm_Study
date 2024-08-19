N = int(input())
arr = list(input())
countA = 0
countB = 0
for i in arr:
  if(i == 'A'):
    countA += 1
  elif(i == 'B'):
    countB += 1

if(countA > countB):
  print("A")
elif(countB > countA):
  print("B")
else:
  print("Tie")