from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait

with webdriver.Firefox() as driver:
    wait = WebDriverWait(driver, timeout=5)

    driver.get("https://training-support.net/webelements/dynamic-controls")

    print("Title of the page: ", driver.title)

    checkbox = driver.find_element(By.CSS_SELECTOR, "#checkbox")
    print("Is checkbox present? ", checkbox.is_displayed())

    toggle_btn = driver.find_element(By.XPATH, "//button[text()='Toggle Checkbox']")
    toggle_btn.click()

    wait.until(EC.invisibility_of_element(checkbox))
    print("Is checkbox present after toggling off? ", checkbox.is_displayed())

    toggle_btn.click()
    wait.until(EC.element_to_be_clickable(checkbox))
    checkbox.click()

    print("Is checkbox selected after clicking? ", checkbox.is_selected())

    driver.quit()