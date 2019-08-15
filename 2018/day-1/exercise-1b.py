def repeat_test(acc):
    if acc in repeated:
        print('The frencuency repeated is =>', acc)
        file.close()
        condition = False
    repeated.add(acc)

acc = 0
repeated = set() 
condition = True
while condition:
    try:
        with open('../files/day-1/input-1', 'r') as file:
            for line in file:
                sign = line[:1]
                value = line[1:]
                if sign == '+':
                    acc += int(value)
                    repeat_test(acc) 
                else:
                    acc -= int(value)
                    repeat_test(acc)      
    except Exception as e:
        break 
