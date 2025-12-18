from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait

with webdriver.Firefox() as driver:

    wait = WebDriverWait(driver, timeout=5)

    driver.get("https://training-support.net/webelements/alerts")

    print("Title of the page: ", driver.title)

    driver.find_element(By.ID, "simple").click()

    alert = wait.until(EC.alert_is_present())
    print("Text of the Alert: ", alert.text)

    alert.accept()
