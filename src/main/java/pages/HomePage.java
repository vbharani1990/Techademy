package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    // Locators
    private By SwagLabs_Logo = By.xpath("//div[text()=\"Swag Labs\"]");
    private By burgerMenu_button = By.id("react-burger-menu-btn");
    private By loginButton = By.id("login-button");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void checkLogoExstence() {
        driver.findElement(SwagLabs_Logo).isDisplayed();
    }

    public void burgerMenubuttonExistence() {
        driver.findElement(burgerMenu_button).isDisplayed();
    }

    public void clickBurgerMenubutton() {
        driver.findElement(burgerMenu_button).click();
    }
}
