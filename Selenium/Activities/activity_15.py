from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait

with webdriver.Firefox() as driver:

    wait = WebDriverWait(driver, timeout=10)

    driver.get("https://training-support.net/webelements/dynamic-attributes")

    print("Title of the page: ", driver.title)

    full_name = driver.find_element(By.XPATH, "//input[@placeholder='Full name']")
    email = driver.find_element(By.XPATH, "//input[contains(@placeholder, 'Email')]")
    event_date = driver.find_element(By.XPATH, "//input[@type='date']")
    details = driver.find_element(By.XPATH, "//textarea[contains(@name,  'additional-details')]")
    submit_btn = driver.find_element(By.CSS_SELECTOR, ".font-bold.svelte-7bqce9")

    full_name.send_keys("Y Someone")
    email.send_keys("yone@gmail.com")
    event_date.click()
    event_date.send_keys("18/12/2025")
    details.send_keys("NA")
    submit_btn.click()

    confirmation = message = wait.until(EC.visibility_of_element_located((By.ID, "action-confirmation"))).text
    print("Confirmation messgage: ", confirmation)
