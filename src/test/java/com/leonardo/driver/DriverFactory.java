package com.leonardo.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class DriverFactory {

	private enum  browsers {
		EXPLORER, SAFARI,FIREFOX,CHROME 
	};
	
	public static WebDriver Levantarbrowser (WebDriver driver, String browserName, String URL)
	{
		switch (browsers.valueOf(browserName)) {
		case CHROME :
		{
			System.setProperty("webdriver.chrome.driver", "src\\main\\java\\Recursos\\chromedriver.exe");
			Reporter.log("Abro browser");
			driver = new ChromeDriver();
			break;
		}
		case FIREFOX:
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
		
		driver.manage().window().maximize();
		driver.get(URL);
		return driver;
	}
}
