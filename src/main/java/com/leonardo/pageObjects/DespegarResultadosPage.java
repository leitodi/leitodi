package com.leonardo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DespegarResultadosPage { //declaracion de la clase
	@FindBy(css="div.sbox5-only-mobile") WebElement buscarAloj;
	private WebDriver driver =null;
	private WebDriverWait wait = null;
	
	public DespegarResultadosPage (WebDriver driver) {//consutructor
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait (driver,5);		
	}

	public boolean cuadroBusqueda () {
		return this.buscarAloj.isDisplayed();
	}
}

