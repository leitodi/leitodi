package NewListasDespegar;

import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.driver.DriverFactory;

public class NewTest {
	  @DataProvider (name = "diferentesdestinos" )
	  public Object[][] dataProviderTest (){
		  return new Object [][] {{" Madrid"}, {" Bariloche"}};
	  }
	  
	  @Test(dataProvider= "diferentesdestinos",description = "Validar botones seleccion")
		public void Validarbotonesseleccion(String ciudades) throws Exception {
		System.setProperty("webdriver.chrome.driver","C:/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://despegar.com.ar");
		
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript ("window.scrollBy(0,350)","");
		driver.manage().window().maximize();
		
		
		//Controlar con listas que aparezcan los botones 
		WebElement alojamiento = null;
		List<WebElement>listaElementos=driver.findElements(By.cssSelector("div.header-products-container ul.header-list-products li"));
		for (WebElement elemento : listaElementos) {
			if(elemento.getText().equals("Alojamientos"))
			alojamiento= elemento;
			System.out.println(elemento.getText());			
		}			
		alojamiento.click();	
		Thread.sleep(1000);
		//elejir ciudad
		WebElement ciudad = driver.findElement(By.cssSelector("div#searchbox-sbox-box-hotels div.sbox-places-destination--1xd0k input"));		
		ciudad.click();	
		Thread.sleep(1000);
		ciudad.sendKeys(ciudades);		
		Thread.sleep(2000);
		ciudad.sendKeys(Keys.ENTER);
		//elejir noches
		WebElement elegir = driver.findElement(By.cssSelector("div.sbox5-box-dates-checkbox-container div.sbox5-dates-input1"));
		elegir.click();	
		WebElement fechasalida = driver.findElement(By.cssSelector("div.sbox5-floating-tooltip-opened div.calendar-container div.-today"));			
		Thread.sleep(2000);
		fechasalida.click();
		Thread.sleep(2000);
		WebElement fecharegreso = driver.findElement(By.cssSelector("div.sbox5-floating-tooltip-opened div.calendar-container div.-today+div"));			
		fecharegreso.click();
		Thread.sleep(2000);
		WebElement aplicar = driver.findElement(By.cssSelector("div.sbox5-floating-tooltip-opened div.calendar-footer em.btn-text"));
		aplicar.click();
		Thread.sleep(2000);
		//seleccion pasajeros
		WebElement pasajeros = driver.findElement(By.cssSelector("div.sbox5-distributionPassengers div.sbox5-3-double-input"));
		pasajeros.click();
		Thread.sleep(2000);
		WebElement mayor = driver.findElement(By.cssSelector("div.sbox5-floating-tooltip-opened div.stepper__distribution_container>div:nth-child(1) button.steppers-icon-right"));		
		mayor.click();		
		WebElement menor = driver.findElement(By.cssSelector("div.sbox5-floating-tooltip-opened div.stepper__distribution_container>div:nth-child(2) button.steppers-icon-right"));
		menor.click();
		//mostrar todas las edades posibles 
		WebElement edad = null;
		List<WebElement> listaDeEdades = driver.findElements(By.cssSelector("div.sbox5-select option.select-option"));
		for (WebElement elemento:listaDeEdades) {
			System.out.println(elemento.getText());
			elemento.isDisplayed();
			if (elemento.getText().equals("4 años"))
				edad=elemento;			
		}		
		System.out.println("Edad elejida es "+ edad.getText());
		edad.click();
		WebElement aplicarPersonas = driver.findElement(By.cssSelector("div.sbox5-floating-tooltip-opened a.-primary em.btn-text"));
		aplicarPersonas.click();
		WebElement buscar = driver.findElement(By.cssSelector("div.sbox5-box-container button.sbox5-box-button-ovr"));
		buscar.click();
		WebElement busqueda = driver.findElement(By.cssSelector("div.sbox5-only-mobile"));
		System.out.println("cuadro de busqueda "+busqueda.isDisplayed());		
		
		driver.close();
  }
}
