xArr = []
yArr = []

for i in range(3):
    x, y = map(int, input().split())
    xArr.append(x)
    yArr.append(y)

resultX = 0
resultY = 0

for x in xArr:
    if xArr.count(x) == 1:
        resultX = x
        break

for y in yArr:
    if yArr.count(y) == 1:
        resultY = y
        break

print(resultX, resultY)