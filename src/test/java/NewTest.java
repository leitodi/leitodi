import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class NewTest {
	@DataProvider(name= "Data provider Wiki")
	public Object [][] dpMethod(){
		return new Object [][] {{"selenium"},{"java"},{"TestNG"}};
	}
	
	
	@Test(dataProvider= "Data provider Wiki",description = "Validar busqueda")
	public void ValidarBusquedaWikipedia(String searchText) throws Exception {
	    System.setProperty("webdriver.chrome.driver", "C:/driver/chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.get("http://wikipedia.org");
	    WebElement searchInput = driver.findElement(By.id("searchInput"));
	    Assert.assertTrue(searchInput.isDisplayed());
	    searchInput.sendKeys(searchText);
	    searchInput.submit();
	    WebElement tituloResultado = driver.findElement(By.id("firstHeading"));
	    System.out.println("Texto encontrado "+ tituloResultado.getText());
	    Assert.assertTrue(tituloResultado.isDisplayed());
	    driver.close();
	}
}
