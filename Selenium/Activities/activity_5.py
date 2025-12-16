from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:

    driver.get("https://training-support.net/webelements/dynamic-controls")

    print("Title of the page: ", driver.title)

    checkbox = driver.find_element(By.CSS_SELECTOR, "#checkbox")

    print("Is checkbox present? ", checkbox.is_displayed())

    driver.find_element(By.XPATH, "//button[text()='Toggle Checkbox']").click()

    print("Is checkbox present after toggling off? ", checkbox.is_displayed())

    driver.quit()
