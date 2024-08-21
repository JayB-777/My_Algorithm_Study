t = int(input())
for i in range(t):
    V, E = map(int, input().split())
    result = E - V + 2
    print(result)