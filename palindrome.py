ele = input().strip()
elts = dict()
for i in ele:
    if i in elts:
        elts[i] += 1
    else:
        elts[i] = 1


def valid(elts):
    count = 0
    i = 0
    j = len(ele) - 1
    string = [0 for i in range(len(ele))]
    for val in elts.values():
        if val % 2 != 0:
            count += 1
            if count > 1:
                return 'NO SOLUTION'
    for key, val in elts.items():
        while val != 0:
            if val % 2 != 0:
                string[(len(string)+1)//2 - 1] = key
                val -= 1
            else:
                string[i] = key
                string[j] = key
                val -= 2
                i += 1
                j -= 1
    return ''.join(string)


print(valid(elts))
