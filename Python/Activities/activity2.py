num = int( input( "Enter a number: " ) )
if(num == 0):
    print("Please enter a number greater than 0")
elif(num%2 == 0):
    print(f"Provided number {num} is Even")
else:
    print(f"Provided number {num} is Odd")