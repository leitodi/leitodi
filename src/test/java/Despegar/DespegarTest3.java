package Despegar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.driver.DriverFactory;

public class DespegarTest3 {
	  @DataProvider (name = "diferentesdestinos" )
	  public Object[][] dataProviderTest (){
		  return new Object [][] {{" Madrid"}, {" Bariloche"}};
	  }
	  
	  @Test(dataProvider= "diferentesdestinos",description = "Validar botones seleccion")
		public void Validarbotonesseleccion(String ciudades) throws Exception {		
		WebDriver driver = null ;
		driver = DriverFactory.Levantarbrowser (driver, "CHROME","http://despegar.com.ar");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript ("window.scrollBy(0,350)","");
		
		WebDriverWait wait = new WebDriverWait (driver,30);
		
		//Controlar con listas que aparezcan los botones 
		WebElement alojamiento = driver.findElement(By.cssSelector("div.header-products-container ul.header-list-products li"));		
		alojamiento.click();	
		
		//elejir ciudad
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div#searchbox-sbox-box-hotels div.sbox-places-destination--1xd0k input")));
		WebElement ciudad = driver.findElement(By.cssSelector("div#searchbox-sbox-box-hotels div.sbox-places-destination--1xd0k input"));		
		ciudad.click();	
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div#searchbox-sbox-box-hotels div.sbox-places-destination--1xd0k input")));
		Thread.sleep(2000);
		ciudad.sendKeys(ciudades);	
		ciudad.sendKeys(Keys.ENTER);				
		Thread.sleep(2000);
		ciudad.sendKeys(Keys.ENTER);
		//elejir noches		
		WebElement elegir = driver.findElement(By.cssSelector("div.sbox5-box-dates-checkbox-container div.sbox5-dates-input1"));
		elegir.click();	
		WebElement fechasalida = driver.findElement(By.cssSelector("div.sbox5-floating-tooltip-opened div.calendar-container div.-today"));			
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.sbox5-floating-tooltip-opened div.calendar-container div.-today")));
		fechasalida.click();	
		WebElement elegirSalida = driver.findElement(By.cssSelector("div.sbox5-box-dates-checkbox-container div.sbox5-dates-input2"));
		elegirSalida.click();
		WebElement fecharegreso = driver.findElement(By.cssSelector("div.sbox5-floating-tooltip-opened div.calendar-container div.-today+div"));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.sbox5-floating-tooltip-opened div.calendar-container div.-today+div")));
		fecharegreso.click();		
		WebElement aplicar = driver.findElement(By.cssSelector("div.sbox5-floating-tooltip-opened div.calendar-footer em.btn-text"));
		aplicar.click();		
		//seleccion pasajeros
		WebElement pasajeros = driver.findElement(By.cssSelector("div.sbox5-distributionPassengers div.sbox5-3-double-input"));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.sbox5-distributionPassengers div.sbox5-3-double-input")));
		pasajeros.click();		
		WebElement mayor = driver.findElement(By.cssSelector("div.sbox5-floating-tooltip-opened div.stepper__distribution_container>div:nth-child(1) button.steppers-icon-right"));	
		wait.until(ExpectedConditions.elementToBeClickable(mayor));				
		mayor.click();		
		WebElement menor = driver.findElement(By.cssSelector("div.sbox5-floating-tooltip-opened div.stepper__distribution_container>div:nth-child(2) button.steppers-icon-right"));
		menor.click();	
		WebElement años = driver.findElement(By.cssSelector("div.stepper__distribution_container>div:nth-child(3) div.sbox5-select"));
		años.click();			
		WebElement edad = driver.findElement(By.cssSelector(".select-option[value='4']"));
		edad.click();		
		System.out.println("Edad elejida es "+ edad.getText());		
		WebElement aplicarPersonas = driver.findElement(By.cssSelector("div.sbox5-floating-tooltip-opened a.-primary em.btn-text"));
		aplicarPersonas.click();
		WebElement buscar = driver.findElement(By.cssSelector("div.sbox5-box-container button.sbox5-box-button-ovr"));
		wait.until(ExpectedConditions.elementToBeClickable(buscar));
		buscar.click();
		WebElement busqueda = driver.findElement(By.cssSelector("div.sbox5-only-mobile"));
		System.out.println("cuadro de busqueda "+busqueda.isDisplayed());		
		
		driver.close();
  }
}
