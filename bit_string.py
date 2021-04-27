n = int(input())
k = 10**9 + 7
if 2**n < k:
   print(2**n)
else:
   print(2**n % k)
