from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver import ActionChains

with webdriver.Firefox() as driver:
	
    actions = ActionChains(driver)
	
    driver.get("https://training-support.net/webelements/mouse-events")
    
    print("Title of the page: ", driver.title)

    cargo_lock_btn = driver.find_element(By.XPATH, "//h1[.='Cargo.lock']")
    cargo_toml_btn = driver.find_element(By.XPATH, "//h1[.='Cargo.toml']")
    src_btn = driver.find_element(By.XPATH, "//h1[.='src']")
    target_btn = driver.find_element(By.XPATH, "//h1[.='target']")
    result = driver.find_element(By.CSS_SELECTOR, "#result")
	
    actions.click(cargo_lock_btn).move_to_element(cargo_toml_btn).click().perform()
		
    print("Result Text: ", result.text)
		
    actions.double_click(src_btn).context_click(target_btn).click().perform()
		
    open = driver.find_element(By.XPATH, "//button[@class = 'flex w-full p-2']//span[.='Open']")
		
    actions.click(open).pause(2).perform()
		
    print("Result Text: ", result.text)
		
    driver.quit()