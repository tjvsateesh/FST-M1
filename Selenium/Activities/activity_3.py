from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:

    driver.get("https://training-support.net/webelements/login-form/")

    print("Title of the page:", driver.title)

    driver.find_element(By.XPATH, "//input[@id='username']name").send_keys("admin")

    driver.find_element(By.XPATH, "//input[@name='password']").send_keys("password")

    driver.find_element(By.XPATH, "//button[contains(text(),'Submit')]").click()

    driver.quit()