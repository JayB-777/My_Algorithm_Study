n = int(input())
Qn = [0]*4
axis = 0
for i in range(0, n):
  x, y = map(int, input().split())
  if(x == 0 or y == 0):
    axis += 1
  elif(x > 0):
    if(y > 0):
      Qn[0] += 1
    elif(y < 0):
      Qn[3] += 1
  elif(x < 0):
    if(y > 0):
      Qn[1] += 1
    elif(y < 0):
      Qn[2] += 1

for i in range(0, 4):
  print(f"Q{i+1}:", Qn[i])
print("AXIS:", axis)
  