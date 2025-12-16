from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver import ActionChains

with webdriver.Firefox() as driver:

    actions = ActionChains(driver)

    driver.get("https://training-support.net/webelements/drag-drop")

    print("Title of the page: ", driver.title)

    ball = driver.find_element(By.ID, "ball")
    dropzone_1 = driver.find_element(By.ID, "dropzone1")
    dropzone_2 = driver.find_element(By.ID, "dropzone2")

    actions.drag_and_drop(ball, dropzone_1)
    print("Ball ", dropzone_1.text, " in dropzone1")

    actions.drag_and_drop(ball, dropzone_2)
    print("Ball ", dropzone_1.text, " in dropzone2")

    driver.quit()
