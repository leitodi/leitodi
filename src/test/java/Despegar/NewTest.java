package Despegar;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.bcel.generic.JSR;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class NewTest {
	@DataProvider (name = "Data provider despegar")
	public Object [][]datadespegar(){
		return new Object [][] {{" Barcelona"},{" Bariloche"},{" Carlos Paz"}};
	}
	
	@Test(dataProvider = "Data provider despegar",description = "Validar busqueda de alojamiento")
	public void ValidarBusquedaDespegar(String Busqueda) throws Exception {
	System.setProperty("webdriver.chrome.driver","C:/driver/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("http://despegar.com.ar");
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript ("window.scrollBy(0,250)","");
	driver.manage().window().maximize();
	
	//seleccionar alojamiento
	
	WebElement alojamiento = driver.findElement(By.cssSelector("div.header-products-container>ul>li>a[title='Alojamientos']"));
	alojamiento.click();
	
	//seleccionar destino
	WebElement destino = driver.findElement(By.cssSelector("div#searchbox-sbox-box-hotels div.sbox-places-destination--1xd0k input"));
	Assert.assertTrue(destino.isDisplayed());
	destino.click();
	Thread.sleep(1000);
	destino.sendKeys(Busqueda);
	
	Thread.sleep(3000);
	destino.sendKeys(Keys.ENTER);	
	System.out.println("Texto encontrado "+ destino.getText());
	//seleccionar fechas
	
	WebElement fecha = driver.findElement(By.cssSelector("div#searchbox-sbox-box-hotels div.sbox5-box-dates-checkbox-container div.sbox5-dates-input1"));
	fecha.click();
	WebElement salida = driver.findElement(By.cssSelector("div.sbox5-floating-tooltip-opened div.calendar-container div.-today"));
	Thread.sleep(2000);
	salida.click();	
	WebElement vuelta = driver.findElement(By.cssSelector("div.sbox5-floating-tooltip-opened div.calendar-container div.-today+div"));
	vuelta.click();
	//seleccionar pasajeros
	WebElement personas = driver.findElement(By.cssSelector("div.sbox5-3-double-input"));
	personas.click();
	Thread.sleep(2000);
	WebElement cantPersonas = driver.findElement(By.cssSelector("div.sbox5-floating-tooltip-opened div.stepper__distribution_container>div:nth-child(1) button.steppers-icon-right"));
	cantPersonas.click();	
	WebElement cantNiños = driver.findElement(By.cssSelector("div.sbox5-floating-tooltip-opened div.stepper__distribution_container>div:nth-child(2) button.steppers-icon-right"));
	cantNiños.click();	
	WebElement menores = driver.findElement(By.cssSelector(".stepper__room .stepper__room__row:nth-child(3) .select-container"));
	menores.click();
	System.out.println("Clickeando edad minima");
	WebElement edadmin = menores.findElement(By.cssSelector(".select-option[value='4']"));
	edadmin.click();
	Thread.sleep(2000);
	WebElement aplicar = driver.findElement(By.cssSelector("div.sbox5-floating-tooltip-opened div.stepper__room__footer>a:nth-child(1)"));	
	aplicar.click();
	Assert.assertTrue(menores.isDisplayed());
	WebElement buscar = driver.findElement(By.cssSelector("div.sbox5-box-container div.sbox5-box-content button"));
	buscar.click();
	WebElement elejir = driver.findElement(By.cssSelector("div.results-cluster-container:nth-child(1) em.btn-text"));
	Assert.assertTrue(elejir.isDisplayed());
	WebElement busqueda = driver.findElement(By.cssSelector("div.sbox-wrapper"));
	System.out.println("Cuadro de busqueda  "+busqueda.isDisplayed());
	
	
	driver.close();
	}
	}
