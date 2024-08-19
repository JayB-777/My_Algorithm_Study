arr = list(input())
result = 10
for i in range(0, len(arr)-1):
  if(arr[i] == arr[i+1]):
    result += 5
  else:
    result += 10
print(result)