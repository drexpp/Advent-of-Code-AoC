acc = 0 
with open('../files/day-1/input-1', 'r') as file:
    for line in file:
        sign = line[:1]
        value = line[1:]
        if sign == '+':
            acc += int(value)
        else:
            acc -= int(value)
print(acc)