from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:

    driver.get("https://training-support.net/webelements/tables")

    print("Title of the page: ", driver.title)

    rows = driver.find_elements(By.XPATH, "//table[@class='w-full table-auto border-separate border-spacing-y-1 text-center']/tbody/tr")
    columns = driver.find_elements(By.XPATH, "//table[@class='w-full table-auto border-separate border-spacing-y-1 text-center']/thead//th")
    fifth_row_book_name = driver.find_element(By.XPATH, "//table[@class='w-full table-auto border-separate border-spacing-y-1 text-center']/tbody//tr[5]/child::td[2]")
    price = driver.find_element(By.XPATH, "//table[@class='w-full table-auto border-separate border-spacing-y-1 text-center']/thead//th[5]")

    print("Number of rows are: ", len(rows))
    print("Number of columns are: ", len(columns))

    print("Fifth row book name: ", fifth_row_book_name.text)

    price.click()

    fifth_row_book_name = driver.find_element(By.XPATH, "//table[@class='w-full table-auto border-separate border-spacing-y-1 text-center']/tbody//tr[5]/child::td[2]")

    print("Fifth row book name after sorting price in ascending order: ", fifth_row_book_name.text)
