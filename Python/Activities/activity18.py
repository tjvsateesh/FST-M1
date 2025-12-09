import pandas as pd

user_data = pd.read_csv("userData.csv")
print(user_data)

print("===== Usernames =====")
print(user_data["Usernames"])

print("===== Second row data =====")
print("Username: " + user_data["Usernames"][1], "\nPassword: " + user_data["Passwords"][1])

print("===== Sorting Usernames in ascending order =====")
print(user_data["Usernames"].sort_values())

print("===== Sorting Passwords in descending order =====")
print(user_data["Passwords"].sort_values(ascending=False))