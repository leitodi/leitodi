package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DespegarHomePage {
	@FindBy(css = "div.header-products-container>ul>li>a[title='Alojamientos']")
	WebElement alojamiento; 	
	private WebDriver driver = null; 
	
	public DespegarHomePage (WebDriver driver){//constructor
	this.driver = driver ;
	PageFactory.initElements(driver, this);
    }

public boolean alojamientoEsVisible() {
	return alojamiento.isDisplayed();
}
public DespegarAlojamientoPage seleccionAlojamiento() {
	alojamiento.click();	
	return new DespegarAlojamientoPage (this.driver);
}
}

