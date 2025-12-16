from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:

    driver.get("https://training-support.net/webelements/target-practice")

    print("Title of the page: ", driver.title)

    third_header_text = driver.find_element(By.XPATH, "//h3[@class='text-3xl font-bold text-orange-600']").text
    print("Text of 3rd header: ", third_header_text)

    fifth_heading_color = driver.find_element(By.XPATH, "//h5[@class='text-3xl font-bold text-purple-600']").value_of_css_property("color")
    print("Color of 5th heading: ", fifth_heading_color)

    purple_button_class = driver.find_element(By.CSS_SELECTOR, "button.rounded-xl.bg-purple-200.p-2.text-3xl.font-bold.text-purple-900.svelte-2hb4ib").get_attribute("class")
    print("Purple button classes: ", purple_button_class)

    slate_button_text = driver.find_element(By.XPATH, "//div//button[contains(text(), 'Slate')]").text
    print("Slate button text: ", slate_button_text)

    driver.quit()
