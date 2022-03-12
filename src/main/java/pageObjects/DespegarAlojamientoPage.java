package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DespegarAlojamientoPage {
	private WebDriver driver = null;
	private WebDriverWait wait = null;
	
	
	
	@FindBy(css = "div#searchbox-sbox-box-hotels div.sbox-places-destination--1xd0k input") WebElement destino; //elejir ciudad
	@FindBy(css = "div.sbox5-box-dates-checkbox-container div.sbox5-dates-input1") WebElement boxFecha; //elejir fecha
	@FindBy(css = "div.sbox5-floating-tooltip-opened div.calendar-container div.-today") WebElement fechaSalida;//fecha de salida
	@FindBy(css = "div.sbox5-box-dates-checkbox-container div.sbox5-dates-input2")WebElement boxFechaRegreso; //elgir fecha de vuelta
	@FindBy(css= "div.sbox5-floating-tooltip-opened div.calendar-container div.-today+div")WebElement fechaRegreso; //fecha de vuelta
	@FindBy(css = "div.sbox5-floating-tooltip-opened div.calendar-footer em.btn-text") WebElement aplicar ; //aplicar fechas seleccionada
	@FindBy(css="div.sbox5-distributionPassengers div.sbox5-3-double-input") WebElement pasajeros; //elejir pasajeros
	@FindBy(css="div.sbox5-floating-tooltip-opened div.stepper__distribution_container>div:nth-child(1) button.steppers-icon-right")WebElement mayores; //mayores edad
	@FindBy(css="div.sbox5-floating-tooltip-opened div.stepper__distribution_container>div:nth-child(2) button.steppers-icon-right")WebElement menores;//menores edad
	@FindBy(css="div.stepper__distribution_container>div:nth-child(3) div.sbox5-select")WebElement menuEdad; //elejir edad
	@FindBy(css=".select-option[value='4']")WebElement edad;//elejir edad
	@FindBy(css="div.sbox5-floating-tooltip-opened a.-primary em.btn-text")WebElement AplicarPasajeros;
	@FindBy(css="div.sbox5-box-container button.sbox5-box-button-ovr")WebElement buscar;//buscar
	
	public DespegarAlojamientoPage (WebDriver driver) {//consutructor
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait (driver,5);		
	}
	public boolean destinoEsVisible () {
		return destino.isDisplayed();
	}	
	public void  seleccionDestino (String busqueda) throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(destino));
		destino.click();
		Thread.sleep(2000);
		destino.sendKeys(busqueda);
		Thread.sleep(1000);
		destino.sendKeys(Keys.ENTER);
	}	
	public void elejirFechas () {		
		wait.until(ExpectedConditions.elementToBeClickable(boxFecha));
		boxFecha.click();
		wait.until(ExpectedConditions.elementToBeClickable(fechaSalida));
		fechaSalida.click();
		boxFechaRegreso.click();
		wait.until(ExpectedConditions.elementToBeClickable(fechaRegreso));
		fechaRegreso.click();
		wait.until(ExpectedConditions.elementToBeClickable(aplicar));
		aplicar.click();
	}
	public void elejirPasajeros () {
		pasajeros.click();
		wait.until(ExpectedConditions.elementToBeClickable(mayores));
		mayores.click();
		mayores.click();
		wait.until(ExpectedConditions.elementToBeClickable(menores));
		menores.click();
		wait.until(ExpectedConditions.elementToBeClickable(menuEdad));
		menuEdad.click();
		edad.click();
		AplicarPasajeros.click();		
	}
	public DespegarResultadosPage buscarAlojamiento () {
		buscar.click();
		return new DespegarResultadosPage (this.driver);
	}
}