package com.leonardo.despegar;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.leonardo.pageObjects.BaseTest;
import com.leonardo.pageObjects.DespegarAlojamientoPage;
import com.leonardo.pageObjects.DespegarHomePage;
import com.leonardo.pageObjects.DespegarResultadosPage;

public class DespegarTest4 extends BaseTest {
	
	WebDriver driver=null;
	JavascriptExecutor js = null; 
  
  @BeforeMethod(alwaysRun=true)
  public void iniciarTest(ITestContext context) {
	  String suitBrowser = context.getCurrentXmlTest().getParameter("NAVEGADOR");
	  String browser = suitBrowser != null ? suitBrowser : "CHROME";
	  driver= BaseTest.iniciarDriver(browser);
	  BaseTest.despegarInicio(driver);
	  js= (JavascriptExecutor) driver;
  }
  @Test(groups={"DespegarTest"}, description = "Validar Alojamiento")
  public void validarAlojamientoDespegar () throws Exception {	  
	  DespegarHomePage inicio = new DespegarHomePage (driver);
	  Assert.assertTrue(inicio.alojamientoEsVisible(),"Es Visible");
	  DespegarAlojamientoPage alojamiento = inicio.seleccionAlojamiento(); 
	  Assert.assertTrue(alojamiento.destinoEsVisible(),"Es Visible");
	  alojamiento.seleccionDestino("Bariloche"); 
	  //hacer en un metodo
	  js.executeScript ("window.scrollBy(0,350)","");
	  alojamiento.elejirFechas();	
	  alojamiento.elejirPasajeros();
	  DespegarResultadosPage resultados = alojamiento.buscarAlojamiento();	  
	  Assert.assertTrue(resultados.cuadroBusqueda(),"Es visible");	  
	  }
  
  @AfterMethod(alwaysRun=true)
  public void finalTest () {
	  driver.close();
  }
}

