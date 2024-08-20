now_hour, now_min, now_sec = map(int, input().split(':'))
start_hour, start_min, start_sec = map(int, input().split(':'))

if(start_hour < now_hour):
  start_hour += 24
  
differ_sec = 3600 * (start_hour - now_hour) + 60 * (start_min - now_min) + start_sec - now_sec
differ_hour = differ_sec // 3600
differ_sec %= 3600
differ_min = differ_sec // 60
differ_sec = differ_sec % 60

if(differ_hour // 10 == 0):
  differ_hour = '0' + str(differ_hour)
if(differ_min // 10 == 0):
  differ_min = '0' + str(differ_min)
if(differ_sec // 10 == 0):
  differ_sec = '0' + str(differ_sec)
print(f"{differ_hour}:{differ_min}:{differ_sec}")