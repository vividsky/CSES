t = int(input())
while t:
    a, b = map(int, input().split())
    if (a+b) % 3 == 0 and abs(a-b) <= min(a, b):
        print('YES')
    else:
        print('NO')
    t -= 1
