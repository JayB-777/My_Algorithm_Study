n = int(input())
for i in range(n):
    candy_num, person_num = map(int, input().split())
    print(f"You get {candy_num // person_num} piece(s) and your dad gets {candy_num % person_num} piece(s).")