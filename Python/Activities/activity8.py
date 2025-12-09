list = input("Enter multiple numbers seperated by spcae: ").split(" ")
size = len(list)
firstNum = list[0]
lastNum = list[size - 1]

if(firstNum == lastNum):
    print("First and Last numbers are equal")
else:
    print("First and Last numbers are not equal")