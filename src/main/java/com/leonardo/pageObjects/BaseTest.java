package com.leonardo.pageObjects;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class BaseTest {
	public static void goToMainPage (WebDriver driver) {
		driver.get("http://wikipedia.org");
	}
	public static void despegarInicio (WebDriver driver) {
		driver.get("http://despegar.com.ar");
	}
	public static WebDriver iniciarDriver(String browserName) {
		WebDriver driver = null;
		switch (browserName) {
		case "CHROME" :
		{
			System.setProperty("webdriver.chrome.driver", "src\\main\\java\\Recursos\\chromedriver.exe");
			Reporter.log("Abro browser");
			driver = new ChromeDriver();
			break;
		}
		case "FIREFOX":
		{
			System.setProperty("webdriver.gecko.driver", "src\\main\\java\\Recursos\\geckodriver.exe");
			Reporter.log("Abro browser");
			driver = new FirefoxDriver();
			break;
		}
		default :
			Reporter.log("no selecciono ningun browser correcto , se le asigna Chrome");
			System.setProperty("webdriver.chrome.driver", "src\\main\\java\\Recursos\\chromedriver.exe");
			Reporter.log("Abro browser");
			driver = new ChromeDriver();
			break;			
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript ("window.scrollBy(0,350)","");
		driver.manage().window().maximize();		
		return driver;	
		
	}

}
