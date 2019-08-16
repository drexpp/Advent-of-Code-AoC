f = open('../files/day-5/input-5', 'r').read()

m = [x for x in f.rstrip('\n')]

# Part 1
def polymer_length(m):
  p_a = 0
  p_b = p_a + 1
  while(p_b < len(m)):
    if ((m[p_a].islower() and m[p_b].isupper()) and (m[p_a] == m[p_b].lower())) or ((m[p_a].isupper() and m[p_b].islower()) and (m[p_a].lower() == m[p_b])):
      del m[p_a]
      del m[p_a]
      if (p_a - 1) < 0:
        pass
      elif ((p_a - 1) == 0) or ((p_a - 1) > 0):
        p_a -= 1
        p_b -= 1
    else:
      p_a += 1
      p_b += 1

  return len(m)
print('Shortest polymer length', polymer_length(m))

# Part 2
for idx, c in enumerate([c for c in "abcdefghijklmnopqrstuvwxyz"]):
  filtered = [e for e in m if e.lower() != c]
  if idx == 0:
    compare = polymer_length(filtered)
  else:
    if len(filtered) > compare: 
      filtered_length = polymer_length(filtered)
      if filtered_length < compare:
        compare = filtered_length
print('Lowest length value', compare)
