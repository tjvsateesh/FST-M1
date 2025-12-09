user_input = input("Enter a list of numbers seperated by space: ")
numbers = list(map(int, user_input.split()))

def sumOfNumbers(numbers):
    sum = 0
    for num in numbers:
        sum += num
    return sum

result = sumOfNumbers(numbers)

print(f"Sum of given numbers is: {result}")