import numpy as np

f = open(r'../files/day-3/input-3')

lines = f.readlines()

# 1000 x 1000 field
high = [0]*1000
field = []
for i in range(1, 1001):
  field.append(high)
x = np.array(field)


def add_value_field(pos):
  #print("Position to be modified", pos)
  a, b = pos.split(": ")
  start_pos_left, start_pos_top = a.split(",")
  start_pos_left = int(start_pos_left)
  start_pos_top = int(start_pos_top)

  width, height = b.split("x")
  width = int(width)
  height = int(height)

  for hei in range(start_pos_top, start_pos_top+height):
    for wid in range(start_pos_left, start_pos_left+width):
      last_value = x[hei, wid]
      x[hei, wid] = last_value + 1
  return x

for idx, l in enumerate(lines):
  pos = l.split("@ ")[1]
  new_field = add_value_field(pos)
  x = new_field


result = 0
for weight in range(1, x.shape[0]):
  for height in range(1, x.shape[1]):
    if x[weight, height] > 1:
      result += 1
print(result)