	
fruitShop = {
    "apple": 120,
    "banana": 28,
    "pomegranate": 150,
    "kiwi": 130
}
 
fruitIsPresent = input("What are you looking for? ").lower()
 
if(fruitIsPresent in fruitShop):
    print(f"Yes, it's available: {fruitShop.get(fruitIsPresent)}/kg")
else:
    print("Sorry!, at the moment it's not available")