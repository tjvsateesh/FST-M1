from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select

with webdriver.Firefox() as driver:

    driver.get("https://training-support.net/webelements/selects")

    print("Title of the page: ", driver.title)

    multi_select = driver.find_element(By.XPATH, "//select[contains(@class, 'h-80 ')]")

    select = Select(multi_select)

    # selecting option 4, 5 and 6
    select.select_by_index(3)
    select.select_by_index(4)
    select.select_by_index(5)
    select.select_by_value("nodejs")
    
    # de-selecting option 5
    select.deselect_by_index(4)
