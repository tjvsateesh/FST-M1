name = input("Enter your name to print in Uppercase: ")
try:
    print(f"Your name is {upperCase_name}")
except NameError:
    print("upperCase_name hasn't been defined yet.")