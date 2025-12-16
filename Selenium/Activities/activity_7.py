from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:

    driver.get("https://training-support.net/webelements/dynamic-controls")

    print("Title of the page: ", driver.title)

    textBox = driver.find_element(By.CSS_SELECTOR, "#textInput")

    print("Is text box enabled? ", textBox.is_enabled())

    driver.find_element(By.CSS_SELECTOR, "#textInputButton").click()

    print("Is text box enabled after enabling? ", textBox.is_enabled())

    driver.quit()
