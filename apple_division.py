n = int(input())
arr = sorted(list(map(int, input().split())))
if n > 1:
   initial = 1
   final = n-2
   list1 = arr[0]
   list2 = arr[-1]
   while initial < final:
      x = min(list1, list2) 
      y = max(list1, list2)
      x += arr[final] 
      y += arr[initial]
      initial+=1
      final-=1
   if n%2 != 0:
      z = min(list1, list2) 
      z += arr[final]
   print(abs(list1 - list2))
else:
   print(arr[0])

