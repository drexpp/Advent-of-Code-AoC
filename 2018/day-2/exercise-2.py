f = open('files/input-2')

all_lines = f.readlines()

a_count = 0
b_count = 0
for line in all_lines:
  dictionary = {}
  for char in line:
    if char not in dictionary:
      dictionary[char] = 1
    else:
      aux = dictionary[char]
      dictionary[char] = aux + 1

  ocurrences_2 = 0
  ocurrences_3 = 0
  for a in dictionary.values():
    if a == 2:
      ocurrences_2 += 1
    if a == 3:
      ocurrences_3 += 1
  if ocurrences_2 > 0 and ocurrences_3 == 0:
    a_count += 1
  if ocurrences_3 > 0 and ocurrences_2 == 0:
    b_count += 1
  if ocurrences_2 > 0 and ocurrences_3 > 0:
    a_count += 1
    b_count += 1

print(a_count*b_count)