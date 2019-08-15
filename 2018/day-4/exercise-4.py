import numpy as np
import datetime
import operator

f = open(r'../files/day-4/input-4')

lines = f.readlines()

b = []
for l in lines:
  d, t = l.split("] ")
  d = d[1:]
  t = t[:-1]
  b.append((datetime.datetime.strptime(d, '%Y-%m-%d %H:%M'), t))
b = sorted(b, key=lambda x: x[0])

last_date = ""
new = False
sleep_date = ""
wake_date = ""
count = {}
most_sleeping_time = {}
count_2 = {}
for idx, d in enumerate(b):
  if "#" in d[1]:
    pos = d[1].split(" ")[1][1:]
  elif "asleep" in d[1]:
    sleep_date = d[0]
  elif "wakes" in d[1]:
    wake_date = d[0]

  if sleep_date != "" and wake_date != "":
    date_diff = sleep_date - wake_date
    date_minutes = int(divmod(date_diff.total_seconds(), 60)[0])*-1
    for i in range(sleep_date.minute, wake_date.minute):
      try:
        count_2[(pos, i)] += 1
        most_sleeping_time[pos] += i
      except:
        count_2[(pos, i)] = 1
        most_sleeping_time[pos] = i
    sleep_date = ""
    wake_date = ""
    
max_val = 0
res = 0
for f in count_2.keys():
  if f[0] == max(most_sleeping_time, key=most_sleeping_time.get):
    if count_2[f] > max_val:
      max_val = count_2[f]
      res = f[1]

print('The most slept minute =>', ((max(most_sleeping_time, key=most_sleeping_time.get)), res))
print('First star =>', res * int(max(most_sleeping_time, key=most_sleeping_time.get)))
print('---------------------')
result = max(count_2, key=count_2.get)
print('Guard who slept most in same minute =>',  result)
print('Second star =>', int(result[0])*result[1])