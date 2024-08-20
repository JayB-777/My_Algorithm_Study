n = int(input())
arr = []
for i in range(0, n):
  name, day, month, year = input().split()
  arr.append((int(year)*10000 + int(month)*100 + int(day), name))

print(max(arr)[1]) # 가장 어린
print(min(arr)[1]) # 가장 나이 많은