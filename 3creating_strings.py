from itertools import permutations
n = input()
x = sorted(list(set(permutations(n))))
print(len(x))
for i in x:
    print(''.join(i))
