arr = input().split()

age1 = int(arr[0])
sex1 = arr[1]

arr = input().split()

age2 = int(arr[0])
sex2 = arr[1]

if (age1 >= 19 and sex1 == "M") or (age2 >= 19 and sex2 == "M"):
    print(1)
else:
    print(0)