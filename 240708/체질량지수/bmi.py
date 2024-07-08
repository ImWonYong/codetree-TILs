h, w = input().split()

h = int(h)
w = int(w)

b = (10000 * w) // (h * h)

print(f"{b}")
if b >= 25:
    print("Obesity")