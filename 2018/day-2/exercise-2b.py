f = open('files/input-2')

all_lines = f.readlines()


for x in all_lines:
  for y in all_lines:
    diff = 0
    for i in range(len(x)):
      if x[i] != y[i]:
          diff += 1
    if diff == 1:
      ans = []
      for i in range(len(x)):
          if x[i] == y[i]:
              ans.append(x[i])
      print('Result = ', ''.join(ans))
      print('Found similarities:\n', x,'\n', y)
      break
  else:
    continue
  break



  