package Wikipedia;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.BaseTest;
import pageObjects.WikiHomePage;
import pageObjects.WikiResultsPage;


public class WikiTest2 extends BaseTest {
	WebDriver driver = null;
	WikiHomePage homePage = null;
	@BeforeMethod
	public void inicioTest (ITestContext context) {
	String suitNavegador = context.getCurrentXmlTest().getParameter("NAVEGADOR");
	String navegador = suitNavegador != null ? suitNavegador : "CHROME";
	driver =BaseTest.iniciarDriver(navegador);
	BaseTest.goToMainPage(driver);
	homePage= new WikiHomePage(driver);	
	}	
  @Test( description= "validar busqueda")
  public void validarBusquedaWikipedia() throws Exception {	  
	  Assert.assertTrue(homePage.searchInputEsVisible(),"No esta visible");
	  WikiResultsPage resultPage = homePage.tituloResultado("Selenium");
	  Assert.assertTrue(resultPage.tituloEsVisible(),"es visible");	    
    }
  @AfterMethod
  public void finTest () {
	  driver.close();	
    }
  }