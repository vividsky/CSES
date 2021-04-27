n = int(input())
odd = []
even = []
if 1 < n < 4:
   print('NO SOLUTION')
else:
   for i in range(1, n+1):
      if not i%2:
         even.append(str(i))
      else:
         odd.append(str(i))
print(' '.join(even + odd))
