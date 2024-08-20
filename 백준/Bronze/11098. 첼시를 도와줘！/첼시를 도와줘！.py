n = int(input())
for i in range(0, n):
  p = int(input())
  arr = []
  for j in range(0, p):
    price_input, player_input = input().split()
    arr.append((int(price_input), player_input))

  print(max(arr)[1])
