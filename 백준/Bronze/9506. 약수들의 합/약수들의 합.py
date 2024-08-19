while(True):
  arr = []

  n = int(input())
  if(n == -1):
    break

  for i in range(1, n//2 + 1):
    if(n % i == 0):
      arr.append(i)

  sum_arr = 0
  for i in arr:
    sum_arr += i

  if sum_arr == n:
    print(f"{n} =", " + ".join(map(str, arr)))
  else:
    print(f"{n} is NOT perfect.")