from math import factorial
# n = int(input())
n = 100000000
count = 0
while n != 0:
   n = (n//5)
   count+=n
print(count)
