from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver import ActionChains

with webdriver.Firefox() as driver:

    actions = ActionChains(driver)

    driver.get("https://training-support.net/webelements/keyboard-events")

    print("Title of the page: ", driver.title)

    text_element = driver.find_element(By.CSS_SELECTOR, ".mt-3.text-center.text-4xl.font-semibold.text-black")

    actions.send_keys("Hello World!").perform()

    print("Entered text: ", text_element.text)

    driver.quit()