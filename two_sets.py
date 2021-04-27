n = int(input())
if sum(i for i in range(1, n+1))%2 == 0:
   if n%4 != 0:
      one = ['1', '2']
      two = ['3']
      for i in range(4, n, 4):
         one.extend([str(i), str(i+3)])
         two.extend([str(i+1), str(i+2)])
      print('YES')
      print(len(one))
      print(' '.join(one))
      print(len(two))
      print(' '.join(two))
   else:
      print('YES')
      print(n//2)
      print(' '.join([str(i) for i in range(1, n//4 + 1)] + [str(i) for i in range(n - n//4 + 1, n+1)]))
      print(n//2)
      print(' '.join([str(i) for i in range(n//4 + 1, n-n//4+1)]))
else:   
   print('NO')   