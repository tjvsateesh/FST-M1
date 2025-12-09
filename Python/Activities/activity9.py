list1 = [10, 20 ,17, 19, 23]
list2 = [3, 8, 9, 10, 14]
resultList = []

for num in list1:
    if(num%2 > 0):
        resultList.append(num)

for num in list2:
    if(num%2 == 0):
        resultList.append(num)
        
print("New list having Odd numbers from list1 and Even nymbers form list2:", resultList)

