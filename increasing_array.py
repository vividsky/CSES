n = int(input())
arr = list(map(int, input().split()))
count = 0
for i in range(len(arr)-1):
   if arr[i+1]< arr[i]:
      count+=(arr[i] - arr[i+1])
      arr[i+1] = arr[i]
print(count)