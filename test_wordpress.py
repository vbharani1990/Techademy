import time
import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager

# Fixture to setup and teardown the browser
@pytest.fixture(scope="module")
def driver():
    # Setup: Initialize the WebDriver (Chrome in this case)
    driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()))
    driver.maximize_window()
    yield driver
    # Teardown: Close the WebDriver
    driver.quit()

# Test Case 1: Launch the URL and verify the title of the page
@pytest.mark.parametrize("url", ["https://wordpress.org/"])
def test_verify_page_title(driver, url):
    driver.get(url)
    assert driver.title == "Blog Tool, Publishing Platform, and CMS – WordPress.org"
    print(f"Title of the page: {driver.title}")

# Test Case 2: Mouse over on Download & Extend and click on Themes
def test_mouseover_and_click_themes(driver):
    driver.get("https://wordpress.org/")

    # Find the "Download & Extend" section and hover over it
    download_extend_element = driver.find_element(By.XPATH, "//span[contains(text(),'Extend')]")
    download_extend_element.click()
    # Find and click on the "Themes" option
    themes_option = driver.find_element(By.XPATH, "//span[contains(text(),'Themes')]")
    themes_option.click()

    # Wait for the page to load
    time.sleep(3)

    # Verify we are on the Themes page
    assert "WordPress Theme Directory | WordPress.org" in driver.title
    print(f"Page Title after click: {driver.title}")

# Test Case 3: Search for a theme and verify the themes are displayed with titles
@pytest.mark.parametrize("theme_name", ["Sports"])
def test_search_for_theme(driver, theme_name):
    driver.get("https://wordpress.org/themes/")

    # Find the search box and search for the theme
    search_box = driver.find_element(By.XPATH, "//input[@class='wp-block-search__input'][@placeholder='Search themes']")
    search_box.send_keys(theme_name)
    search_button=  driver.find_element(By.XPATH,"(//button[@type='submit'])[2]")
    search_button.click()

    # Wait for results to load
    time.sleep(3)

    # Verify that themes are displayed
    theme_elements = driver.find_elements(By.XPATH, "//figure[@class='wp-block-post-featured-image']")

    assert len(theme_elements) > 0
    print(f"The themes displayed with the title: {theme_name}")
