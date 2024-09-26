arr = input().split()

s1 = int(arr[0])
s2 = int(arr[1])

if s1 >= 90:
    if s2 >= 95:
        print(10)
    elif s2 >= 90:
        print(5)
else:
    print(0)