from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait

with webdriver.Firefox() as driver:

    wait = WebDriverWait(driver, timeout=5)

    driver.get("https://training-support.net/webelements/tabs")

    print("Title of the page: ", driver.title)

    driver.find_element(By.CSS_SELECTOR, ".bg-purple-200.svelte-1bfwg86").click()

    wait.until(EC.number_of_windows_to_be(2))

    print("All open windows: ", driver.window_handles)

    driver.switch_to.window(driver.window_handles[1])

    print("New window's title: " + driver.title)

    message = driver.find_element(By.CSS_SELECTOR, ".mt-5").text
    print("New window's messgage: ", message)

    driver.find_element(By.XPATH, "//button[text()='Open Another One']").click()
    
    wait.until(EC.number_of_windows_to_be(3))

    print("All open windows: ", driver.window_handles)

    driver.switch_to.window(driver.window_handles[2])

    print("Another new window's messgage: " + driver.find_element(By.CSS_SELECTOR, ".mt-5").text)
