def getSumOf(num):
    if (num >= 0):
        return num + getSumOf(num - 1)
    else:
        return 0
try:  
    sumOfFirst_n_digits = int(input("Enter a number to get sum: "))
except Exception as e:
    print(f"Error!, {e}")
result = getSumOf(sumOfFirst_n_digits)
print(result)