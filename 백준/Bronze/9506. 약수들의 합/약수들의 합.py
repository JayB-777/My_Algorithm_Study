while(True):
  arr = []

  n = int(input())
  if(n == -1):
    break

  for i in range(1, n//2 + 1):
    if(n % i == 0):
      arr.append(i)

  sum = 0
  for i in arr:
    sum += i

  if sum == n:
    print(n, "=", end = " ")
    for i in range(0, len(arr)):
      if(i == len(arr) - 1):
        print(arr[i])
      else:
        print(arr[i], "+", end = " ")
  else:
    print(n, "is NOT perfect.")