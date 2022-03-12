package Despegar;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BaseTest;
import pageObjects.DespegarAlojamientoPage;
import pageObjects.DespegarHomePage;
import pageObjects.DespegarResultadosPage;

public class DespegarTest4 extends BaseTest {
  @Test(description = "Validar Alojamiento")
  public void validarAlojamientoDespegar () throws Exception {
	  WebDriver driver= BaseTest.iniciarDriver("CHROME");
	  BaseTest.despegarInicio(driver);
	  DespegarHomePage inicio = new DespegarHomePage (driver);
	  Assert.assertTrue(inicio.alojamientoEsVisible(),"Es Visible");
	  DespegarAlojamientoPage alojamiento = inicio.seleccionAlojamiento(); 
	  Assert.assertTrue(alojamiento.destinoEsVisible(),"Es Visible");
	  alojamiento.seleccionDestino(" Bariloche"); 
	  alojamiento.elejirFechas();	
	  alojamiento.elejirPasajeros();
	  DespegarResultadosPage resultados = alojamiento.buscarAlojamiento();	  
	  Assert.assertTrue(resultados.cuadroBusqueda(),"es visible");
	  driver.close();
	  }
}
