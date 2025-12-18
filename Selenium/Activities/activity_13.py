from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:

    driver.get("https://training-support.net/webelements/tables")

    print("Title of the page: ", driver.title)

    rows = driver.find_elements(By.XPATH, "//table[@class='w-full table-auto border-separate border-spacing-y-1 text-center']/tbody/tr")
    columns = driver.find_elements(By.XPATH, "//table[@class='w-full table-auto border-separate border-spacing-y-1 text-center']/thead//th")
    third_row = driver.find_element(By.XPATH, "//table[@class='w-full table-auto border-separate border-spacing-y-1 text-center']/tbody//tr[3]")
    second_row_second_column = driver.find_element(By.XPATH, "//table[@class='w-full table-auto border-separate border-spacing-y-1 text-center']/tbody//tr[2]/td[2]")

    print("Number of rows are: ", len(rows))
    print("Number of columns are: ", len(columns))

    print("Values in the 3rd row are: ", third_row.text)

    print("Value at second row-second column is: ", second_row_second_column.text)
