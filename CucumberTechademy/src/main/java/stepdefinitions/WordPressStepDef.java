package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Base.BaseTest;
import ObjectRepo.GetWordPressPage;
import ObjectRepo.HomePage;
import ObjectRepo.PhotoDirectoryPage;
import PageFactoryRepository.PageFactoryRepository;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WordPressStepDef extends BaseTest {
	WebDriver driver = new ChromeDriver();
	private PageFactoryRepository pageFactory;

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	// HomePage homePage = pageFactory.getHomePage();
	// PhotoDirectoryPage photoDirectoryPage = pageFactory.getphotoDirectoryPage();
	// GetWordPressPage getWordPressPage = pageFactory.getWordPressPage();

	@Given("I launch the WordPress homepage")
	public void launchWordPressHomepage() {
		// driver = new ChromeDriver();
		driver.get("https://wordpress.org/");
		driver.manage().window().maximize();

		pageFactory = new PageFactoryRepository(driver);
	}

	@Then("I verify the title of the page is {string}")
	public void verifyPageTitle(String expectedTitle) {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Title did not match!");
	}

	@When("I click on {string}")
	public void hoverAndClick(String subMenuText) throws InterruptedException {
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		HomePage homePage = pageFactory.getHomePage();
		homePage.hoverOverDownloadExtendAndClickGetWordPress();
	}

	@Then("I verify the text in the middle of the page is {string}")
	public void verifyMiddleText(String expectedText) throws InterruptedException {
		GetWordPressPage getWordPressPage = pageFactory.getWordPressPage();
		getWordPressPage.SearchGetWordPressTextBox();
		String actualText = getWordPressPage.searchGetWordPressTextBox().getText();
		Assert.assertEquals(actualText, expectedText, "Middle text did not match!");
	}

	@When("I click on {string} and then click on {string}")
	public void clickOnCommunityAndPhotoDirectory(String menuText, String subMenuText) {
		HomePage homePage = pageFactory.getHomePage();
		homePage.clickCommunityMenu();
		homePage.clickPhotoDirectoryLink();
	}

	@Then("I verify the search box is displayed in the Photo Directory")
	public void verifySearchBox() {
		PhotoDirectoryPage photoDirectoryPage = pageFactory.getphotoDirectoryPage();
		Assert.assertTrue(photoDirectoryPage.getSearchBox().isDisplayed(), "Search box is not displayed!");
	}

	@When("I search for a picture by name {string}")
	public void searchForPicture(String pictureName) {
		PhotoDirectoryPage photoDirectoryPage = pageFactory.getphotoDirectoryPage();
		photoDirectoryPage.searchForPicture(pictureName);
		photoDirectoryPage.getSearchBox().sendKeys(Keys.ENTER);

	}

	@Then("I verify pictures are displayed in the search results")
	public void verifyPicturesDisplayed() {
		PhotoDirectoryPage photoDirectoryPage = pageFactory.getphotoDirectoryPage();
		photoDirectoryPage.isNextButtonDisplayed();
		Assert.assertTrue(photoDirectoryPage.getNextButton().isDisplayed(), "Pictures are not displayed!");
	}
	
	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
