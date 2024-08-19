xArr = [0]*3
yArr = [0]*3

for i in range(0,3):
  x,y = map(int, input().split())
  xArr[i] = x
  yArr[i] = y

resultX = 0
resultY = 0

xArr.sort()
yArr.sort()

if(xArr[0] == xArr[1]):
  resultX = xArr[2]
else:
  resultX = xArr[0]

if(yArr[0] == yArr[1]):
  resultY = yArr[2]
else:
  resultY = yArr[0]

print(resultX, resultY)