arr = input().split()

m1 = int(arr[0])
e1 = int(arr[1])

arr = input().split()

m2 = int(arr[0])
e2 = int(arr[1])

if m1 > m2 and e1 > e2:
    print(1)
else:
    print(0)