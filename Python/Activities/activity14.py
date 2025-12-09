number = int(input("Ebter a number: "))
series = []

def fibonacci(num):
    if(num <= 1):
        return num
    else:
        return (fibonacci(num - 1)+ fibonacci(num - 2))

if(number <= 0):
    print("Enter a number > 0")
else:
    for i in range(number):
        series.append(fibonacci(i))

print("Fibonacci sequence: ", series)



