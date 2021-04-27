n = int(input())
arr = list(map(int, input().split()))
count = dict()
val = 0
for ele in arr:
   if ele in count:
      count[ele]+=1
   else:
      count[ele] = 1
      val+=1
print(val)
