year = int(input())

if year % 4 == 0 and not (year % 100 == 0 and year % 400 != 0):
    print("true")
else:
    print("false")