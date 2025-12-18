from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select

with webdriver.Firefox() as driver:

    driver.get("https://training-support.net/webelements/selects")

    print("Title of the page: ", driver.title)

    dropdown = driver.find_element(By.XPATH, "//select[contains(@class, 'h-10 ')]")

    select = Select(dropdown)

    select.select_by_visible_text("Two")
    select.select_by_index(3)
    select.select_by_value("four")

    allOptions = select.options
    print("All the options are:")
    for option in allOptions: 
        print(option.text)