# n = int(input())
n = 3
b = [0 for _ in range(n)]
for i in range(n):
   b[i] = 1
   print(b)
for i in range(n):
   b[i] = 0
   print(b)