from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:

    driver.get("https://training-support.net/webelements/login-form/")

    print("Title of the page:", driver.title)

    driver.find_element(By.ID, "username").send_keys("admin")

    driver.find_element(By.ID, "password").send_keys("password")

    driver.find_element(By.CSS_SELECTOR, "button.svelte-1pdjkmx").click()

    driver.quit()