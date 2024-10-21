package tests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Automation_Anywhere;

import java.time.Duration;

public class TestNG_Tests extends BaseTest {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    Automation_Anywhere a_a = new Automation_Anywhere();

    public void Base() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        driver.get("https://www.automationanywhere.com/");
        String parentWindow = driver.getWindowHandle();
        Thread.sleep(5000);
        if (driver.findElement(a_a.accept_Cookies_button).isDisplayed()) {
            driver.findElement(a_a.accept_Cookies_button).click();
        }
        driver.switchTo().window(parentWindow);
    }

    @Test(priority = 1, enabled = true, timeOut = 25000)
    public void TestHomePageValidation() throws InterruptedException {
        Base();

        //a.	Automation Anywhere logo should be present
        Assert.assertTrue(driver.findElement(a_a.logo).isDisplayed());

        //b.	Verify Request demo button is present and verify if it is clickable or not
        WebElement requestDemo_button = driver.findElement(a_a.requestDemo_button);
        wait.until(ExpectedConditions.elementToBeClickable(requestDemo_button));
        Assert.assertTrue(requestDemo_button.isDisplayed());
    }

    @Test(priority = 2, enabled = true, timeOut = 250000)
    public void TestLinksValidation() throws InterruptedException {
        /*Verify below list is present on home page and click on each and every link and verify that it is navigating to the proper page
        a.	Products
        b.	Solutions
        c.	Resources
        d.	Beyond RPA - No such links available
        e.	Company
         */

        //a.	Products
        driver.findElement(a_a.products_link).click();
        waitForCondition(a_a.products_page);
        Assert.assertTrue(driver.findElement(a_a.products_page).isDisplayed());

        //b.	Solutions
        driver.findElement(a_a.solutions_link).click();
        waitForCondition(a_a.solutions_page);
        Assert.assertTrue(driver.findElement(a_a.solutions_page).isDisplayed());

        //c.	Resources
        driver.findElement(a_a.resources_link).click();
        waitForCondition(a_a.resources_page);
        Assert.assertTrue(driver.findElement(a_a.resources_page).isDisplayed());

        //d. Customers
        driver.findElement(a_a.customers_link).click();
        waitForCondition(a_a.customers_page);
        Assert.assertTrue(driver.findElement(a_a.customers_page).isDisplayed());

        //e.	Company
        driver.findElement(a_a.company_link).click();
        waitForCondition(a_a.company_page);
        Assert.assertTrue(driver.findElement(a_a.company_page).isDisplayed());
    }
}
