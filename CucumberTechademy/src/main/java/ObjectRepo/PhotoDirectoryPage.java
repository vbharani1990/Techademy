package ObjectRepo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageFactoryRepository.PageFactoryRepository;

public class PhotoDirectoryPage extends PageFactoryRepository {

	

	public PhotoDirectoryPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	// Page elements
	public By searchBox = By.xpath("//input[@type='search'][@placeholder=\"Search photos\"]");
	public By searchButton = By.cssSelector("button[type='submit']");
	public By firstImage = By.cssSelector("img.wporg-gallery-item__image");
	public By nextButton = By.xpath("//a[@class='next page-numbers']");

	// Methods for page interactions
	public WebElement getSearchBox() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
		return driver.findElement(searchBox);
	}

	public WebElement getSearchButton() {
		return driver.findElement(searchButton);
	}

	public WebElement getFirstImage() {
		return driver.findElement(firstImage);
	}

	public WebElement getNextButton() {
		return driver.findElement(nextButton);
	}

	// Action methods
	public void searchForPicture(String pictureName) {
		getSearchBox().sendKeys(pictureName);
		getSearchBox().sendKeys(Keys.ENTER);
	}

	public boolean isNextButtonDisplayed() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(nextButton));
		return getNextButton().isDisplayed();
	}
}
