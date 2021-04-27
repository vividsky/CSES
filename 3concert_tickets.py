t, c = map(int, input().split())
ticket = list(map(int, input().split()))
price = list(map(int, input().split()))
flag = [False for _ in range(t)]
for ele in price:
    l = 0
    h = t-1
    ans = -1
    while l <= h:
        mid = (l + h)//2
        if ticket[mid] == ele:
            ans = ticket[mid]
            break
        else:
            if ticket[mid] > ele:
                h = mid - 1
                mid-=1
            else:
                ans = ticket[mid]
                l = mid + 1
    while mid>=0 and flag[mid] :
        mid-=1
    if mid>=0:
        flag[mid] = True
        print(ans)
    else:
        print("-1")