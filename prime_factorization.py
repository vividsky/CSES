def bruteForce(n):
   elts = []
   for i in range(2, n):
      if n%i == 0:
         count = 0
         while n%i == 0:
            count+=1
            n//=i
         elts.append(f'({i}^{count})')
   print('*'.join(elts))
bruteForce(18)

#if n is a composite number, then there must be a prime divisor
# of n which is less thn sqrt(n)

def optimisedSoln(n):
   pass