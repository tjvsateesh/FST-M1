from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:

    driver.get("https://training-support.net/webelements/popups")

    print("Title of the page: ", driver.title)

    driver.find_element(By.ID, "launcher").click()

    username = driver.find_element(By.ID, "username")
    password = driver.find_element(By.ID, "password")
    submit_btn = driver.find_element(By.XPATH, "//button[.='Submit']")

    username.send_keys("admin")
    password.send_keys("password")
    submit_btn.click()

    message = driver.find_element(By.CSS_SELECTOR, "div.flex.flex-col > div > h2").text
    print("Message: ", message)
