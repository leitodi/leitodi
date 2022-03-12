package Wikipedia;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BaseTest;
import pageObjects.WikiHomePage;
import pageObjects.WikiResultsPage;


public class WikiTest2 extends BaseTest {
  @Test(description= "validar busqueda")
  public void validarBusquedaWikipedia() throws Exception {
	  WebDriver driver= BaseTest.iniciarDriver("CHROME");
	  BaseTest.goToMainPage(driver);
	  WikiHomePage homePage=new WikiHomePage (driver);
	  Assert.assertTrue(homePage.searchInputEsVisible(),"No esta visible");
	  WikiResultsPage resultPage = homePage.tituloResultado("Selenium");
	  Assert.assertTrue(resultPage.tituloEsVisible(),"es visible");
	  driver.close();	  
  }
}