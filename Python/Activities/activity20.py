import pandas as pd

data = pd.read_excel('userData.xlsx')
print(data)

print("===== Number of rows and columns =====")
print(data.shape)

print("===== Data in the Email column =====")
print(data["Email"])

print("===== Sorting the data based on First name =====")
print(data.sort_values("FirstName"))