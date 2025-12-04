user1 = input("Enter Player1 name: ")
user2 = input("Enter Player2 name: ")

print("Choose: Rock! Paper! Scissor!")

user1_answer = input(user1 + "'s pick: ").lower()
user2_answer = input(user2 + "'s pick ").lower()

if user1_answer == user2_answer:
    print("Oh no! It's a tie")

elif user1_answer == 'rock':
    if user2_answer == 'scissor':
        print(f"{user1} wins!")
    else:
        print(f"{user2} wins!")

elif user1_answer == 'scissor':
    if user2_answer == 'paper':
        print(f"{user1} wins!")
    else:
        print(f"{user2} wins!")

elif user1_answer == 'paper':
    if user2_answer == 'rock':
        print(f"{user1} wins!")
    else:
        print(f"{user2} win!")
else:
    print("Invalid input! Choose one of Rock! Paper! Scissor! ")