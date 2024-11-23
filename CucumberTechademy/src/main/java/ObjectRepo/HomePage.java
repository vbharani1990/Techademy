package ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageFactoryRepository.PageFactoryRepository;

public class HomePage extends PageFactoryRepository {
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//private WebDriver driver;

	// Page elements
	// private By downloadExtendMenu = By.linkText("Download & Extend");
	public By getWordPressOption = By.xpath("(//a[@href='https://wordpress.org/download/'])[2]");
	public By communityMenu = By.xpath("//button[@aria-label='Community submenu']");
	public By photoDirectoryLink = By.xpath("//span[text()='Photo Directory']");

	
	public WebElement getGetWordPressOptionAction() {
		return driver.findElement(getWordPressOption);
	}

	public WebElement getCommunityMenu() {
		return driver.findElement(communityMenu);
	}

	public WebElement getPhotoDirectoryLink() {
		return driver.findElement(photoDirectoryLink);
	}

	// Action methods
	public void hoverOverDownloadExtendAndClickGetWordPress() throws InterruptedException {
		// driver.findElement(downloadExtendMenu).click();
		//wait.until(ExpectedConditions.elementToBeClickable(getWordPressOption));
		Thread.sleep(3000);
		driver.findElement(getWordPressOption).click();
	}

	public void clickCommunityMenu() {
		driver.findElement(communityMenu).click();
	}

	public void clickPhotoDirectoryLink() {
		//wait.until(ExpectedConditions.elementToBeClickable(photoDirectoryLink));
		driver.findElement(photoDirectoryLink).click();
	}
}
