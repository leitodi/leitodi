package com.leonardo.wikipedia;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.leonardo.pageObjects.BaseTest;
import com.leonardo.pageObjects.WikiHomePage;
import com.leonardo.pageObjects.WikiResultsPage;


public class WikiTest3 extends BaseTest {
	WebDriver driver = null;
	WikiHomePage homePage = null;
	@BeforeMethod (alwaysRun=true)
	public void inicioTest (ITestContext context) {
	String suitNavegador = context.getCurrentXmlTest().getParameter("NAVEGADOR");
	String navegador = suitNavegador != null ? suitNavegador : "CHROME";
	driver =BaseTest.iniciarDriver(navegador);
	BaseTest.goToMainPage(driver);
	homePage= new WikiHomePage(driver);	
	}	
  @Test(groups= {"grupo_1"}, description= "validar busqueda")
  public void validarBusquedaWikipedia() throws Exception {	  
	  Assert.assertTrue(homePage.searchInputEsVisible(),"No esta visible");
	  WikiResultsPage resultPage = homePage.tituloResultado("Grupo 1");
	  Assert.assertTrue(resultPage.tituloEsVisible(),"Es visible");	    
    }
  @Test(groups= {"grupo_2"}, description= "validar busqueda")
  public void validarBusquedaWikipedia2() throws Exception {	  
	  Assert.assertTrue(homePage.searchInputEsVisible(),"No esta visible");
	  WikiResultsPage resultPage = homePage.tituloResultado("Grupo 2");
	  Assert.assertTrue(resultPage.tituloEsVisible(),"Es visible");	    
    }
  @Test(groups= {"grupo_1, grupo_2"}, description= "validar busqueda")
  public void validarBusquedaWikipedia3() throws Exception {	  
	  Assert.assertTrue(homePage.searchInputEsVisible(),"No esta visible");
	  WikiResultsPage resultPage = homePage.tituloResultado("Grupo 1 y 2");
	  Assert.assertTrue(resultPage.tituloEsVisible(),"Es visible");	    
    }
  @AfterMethod (alwaysRun=true)
  public void finTest () {
	  if (driver !=null) {
	  driver.close();
	  }
    }
  }