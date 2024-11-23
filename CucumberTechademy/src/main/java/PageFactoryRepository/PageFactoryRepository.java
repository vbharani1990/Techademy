package PageFactoryRepository;

import org.openqa.selenium.WebDriver;

import ObjectRepo.GetWordPressPage;
import ObjectRepo.HomePage;
import ObjectRepo.PhotoDirectoryPage;

public class PageFactoryRepository {

	protected WebDriver driver;

	public PageFactoryRepository(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage getHomePage() {
		return new HomePage(driver);
	}

	public GetWordPressPage getWordPressPage() {
		return new GetWordPressPage(driver);
	}

	public PhotoDirectoryPage getphotoDirectoryPage() {
		return new PhotoDirectoryPage(driver);
	}
}
