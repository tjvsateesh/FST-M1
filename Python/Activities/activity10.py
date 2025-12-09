numbers = eval(input("Enter a tuple with numbers: "))

for num in numbers:
    if(num%5 == 0):
        print(f"{num} is divisible by 5")