package ObjectRepo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageFactoryRepository.PageFactoryRepository;

public class GetWordPressPage extends PageFactoryRepository {
	
	

	public GetWordPressPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	// Page elements
	public By searchGetWordPressTextBox = By.xpath("//h1[text()='Get WordPress']");

	// Methods for page interactions
	public WebElement searchGetWordPressTextBox() {
		return driver.findElement(searchGetWordPressTextBox);
	}

	// Action methods
	public void SearchGetWordPressTextBox() throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(searchGetWordPressTextBox));
		searchGetWordPressTextBox().isDisplayed();
	}
}
