N = int(input())
result = [0] * N

for i in range(N):
    A, B, C = map(int, input().split())
    arr = [A, B, C]
    arr.sort()
    
    if arr[0] != arr[1] and arr[1] != arr[2] and arr[0] != arr[2]:  
        result[i] = 100 * arr[2]
    elif arr[0] == arr[1] == arr[2]:  
        result[i] = 10000 + arr[0] * 1000
    else: 
        result[i] = 1000 + arr[1] * 100
        
result.sort()
print(result[N-1])