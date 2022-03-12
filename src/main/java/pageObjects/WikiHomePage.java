package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiHomePage {
	@FindBy(id = "searchInput")
	WebElement searchInput;

	private WebDriver driver = null;

	public WikiHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean searchInputEsVisible() {
		return this.searchInput.isDisplayed();

	}

	public WikiResultsPage tituloResultado(String text) {
		this.searchInput.sendKeys(text);
		searchInput.submit();
		return new WikiResultsPage(this.driver);
	}
}
