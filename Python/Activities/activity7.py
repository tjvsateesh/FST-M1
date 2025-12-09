list = input("Enter multiple numbers seperated by spcae: ").split(" ")
 
sum = 0
for number in list:
  sum += int(number)
 
print(sum)