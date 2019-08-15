import numpy as np

f = open(r'../files/day-3/input-3')

lines = f.readlines()

#lines = ["1 @ 1,3: 4x4", "2 @ 3,1: 4x4", "3 @ 5,5: 2x2"]

visited = []
def add(pos):
  visited.append(pos)

def check(pos):
  modify = False
  found_idx = 0
  for i in range(0,len(visited)):
    for elem in pos:
      if elem in visited[i]:
        modify = True
        found_idx = i
        break
    else:
      continue
    break
  if modify:
    pos.append(0)
    add(pos)
    visited[found_idx].append('not')
  else:
    add(pos)



moves = []
for idx, l in enumerate(lines):
  aux = []
  print('Checking line', idx, 'of', len(lines))
  #print('Visited has size', len(visited))
  pos = l.split("@ ")[1]
  #add_value_field(pos, idx)


  a, b = pos.split(": ")
  start_pos_left, start_pos_top = a.split(",")
  start_pos_left = int(start_pos_left)
  start_pos_top = int(start_pos_top)

  width, height = b.split("x")
  width = int(width)
  height = int(height)


  for hei in range(start_pos_top, start_pos_top+height):
    for wid in range(start_pos_left, start_pos_left+width):
      pos = str(hei+1)+'x'+ str(wid+1)
      aux.append(pos) 
  moves.append(aux)
    

print(moves)
print(len(moves))
print(len(lines))
"""
a = ['751x92', '751x93', '751x94', '751x95', '751x96', '751x97', '751x98', '751x99', '751x100', '751x101', '751x102', '751x103', '751x104', '751x105', '752x92', '752x93', '752x94', '752x95', '752x96', '752x97', '752x98', '752x99', '752x100', '752x101', '752x102', '752x103', '752x104', '752x105', '753x92', '753x93', '753x94', '753x95', '753x96', '753x97', '753x98', '753x99', '753x100', '753x101', '753x102', '753x103', '753x104', '753x105', '754x92', '754x93', '754x94', '754x95', '754x96', '754x97', '754x98', '754x99', '754x100', '754x101', '754x102', '754x103', '754x104', '754x105', '755x92', '755x93', '755x94', '755x95', '755x96', '755x97', '755x98', '755x99', '755x100', '755x101', '755x102', '755x103', '755x104', '755x105', '756x92', '756x93', '756x94', '756x95', '756x96', '756x97', '756x98', '756x99', '756x100', '756x101', '756x102', '756x103', '756x104', '756x105', '757x92', '757x93', '757x94', '757x95', '757x96', '757x97', '757x98', '757x99', '757x100', '757x101', '757x102', '757x103', '757x104', '757x105', '758x92', '758x93', '758x94', '758x95', '758x96', '758x97', '758x98', '758x99', '758x100', '758x101', '758x102', '758x103', '758x104', '758x105', '759x92', '759x93', '759x94', '759x95', '759x96', '759x97', '759x98', '759x99', '759x100', '759x101', '759x102', '759x103', '759x104', '759x105', '760x92', '760x93', '760x94', '760x95', '760x96', '760x97', '760x98', '760x99', '760x100', '760x101', '760x102', '760x103', '760x104', '760x105', '761x92', '761x93', '761x94', '761x95', '761x96', '761x97', '761x98', '761x99', '761x100', '761x101', '761x102', '761x103', '761x104', '761x105', '762x92', '762x93', '762x94', '762x95', '762x96', '762x97', '762x98', '762x99', '762x100', '762x101', '762x102', '762x103', '762x104', '762x105', '763x92', '763x93', '763x94', '763x95', '763x96', '763x97', '763x98', '763x99', '763x100', '763x101', '763x102', '763x103', '763x104', '763x105', '764x92', '764x93', '764x94', '764x95', '764x96', '764x97', '764x98', '764x99', '764x100', '764x101', '764x102', '764x103', '764x104', '764x105', '765x92', '765x93', '765x94', '765x95', '765x96', '765x97', '765x98', '765x99', '765x100', '765x101', '765x102', '765x103', '765x104', '765x105', '766x92', '766x93', '766x94', '766x95', '766x96', '766x97', '766x98', '766x99', '766x100', '766x101', '766x102', '766x103', '766x104', '766x105', '767x92', '767x93', '767x94', '767x95', '767x96', '767x97', '767x98', '767x99', '767x100', '767x101', '767x102', '767x103', '767x104', '767x105', '768x92', '768x93', '768x94', '768x95', '768x96', '768x97', '768x98', '768x99', '768x100', '768x101', '768x102', '768x103', '768x104', '768x105', '769x92', '769x93', '769x94', '769x95', '769x96', '769x97', '769x98', '769x99', '769x100', '769x101', '769x102', '769x103', '769x104', '769x105', '770x92', '770x93', '770x94', '770x95', '770x96', '770x97', '770x98', '770x99', '770x100', '770x101', '770x102', '770x103', '770x104', '770x105', '771x92', '771x93', '771x94', '771x95', '771x96', '771x97', '771x98', '771x99', '771x100', '771x101', '771x102', '771x103', '771x104', '771x105']



for idx, move in enumerate(moves):
  if move == a:
    print("000=",idx)
"""





for l in lines:
  pos = l.split("@ ")[1]
  #add_value_field(pos, idx)


  a, b = pos.split(": ")
  start_pos_left, start_pos_top = a.split(",")
  start_pos_left = int(start_pos_left)
  start_pos_top = int(start_pos_top)

  width, height = b.split("x")
  width = int(width)
  height = int(height)
  moves_1 = []
  aux = []
  for hei in range(start_pos_top, start_pos_top+height):
    for wid in range(start_pos_left, start_pos_left+width):
      pos = str(hei+1)+'x'+ str(wid+1)
      aux.append(pos) 
  moves_1.append(aux)

  print("AAAA= ", len(moves_1[0]))
  print("BBBB= ", len(moves[0]))
  break
  for idx, move_1 in enumerate(moves_1):
    for idx1, move in enumerate(moves):
      if idx != idx1:
        if move_1 not in move:
          print(move_1)
          break
    else:
      continue
    break











"""

print('-----------')
print('Numero de lineas', len(lines))
print('Visited lines', len(visited))
print('----------')
print(visited)

#print(visited)
for idx, l in enumerate(visited):
  print('----------')
  if 0 not in l:
    print('Index', idx)
    print('Claims not found', l)
  print('----------')
"""