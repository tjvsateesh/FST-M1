from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:

    driver.get("https://training-support.net/webelements/dynamic-controls")

    print("Title of the page: ", driver.title)

    checkbox = driver.find_element(By.CSS_SELECTOR, "#checkbox")

    print("Is checkbox selected? ", checkbox.is_selected())

    checkbox.click()

    print("Is checkbox selected after clicking? ", checkbox.is_selected())

    driver.quit()
