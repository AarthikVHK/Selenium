package com.expedia.flightsbooking;

import org.testng.annotations.Test;
//import org.testng.log4testng.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

//@Listeners(testpackage.SeleniumListeners.class)
public class TestNG_TestCase {
	
	public WebDriver driver;
	
	public WebDriver getDriver() {
        return driver;
	}
	
	public String baseUrl;
	//static Logger log = Logger.getLogger(TestNG_TestCase.class);
  
	@Parameters("browserType")
	@BeforeClass
  public void beforeClass(String browser) {
		//WebDriver driver;
	if(browser.equalsIgnoreCase("firefox")){	
		System.setProperty("webdriver.gecko.driver", "E:\\Aarthik\\geckodriver-v0.10.0-win64\\geckodriver.exe");
		driver =new FirefoxDriver();
	} else if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "E:\\Aarthik\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
	} else if(browser.equalsIgnoreCase("ie")) {
		System.setProperty("webdriver.ie.driver", "E:\\Aarthik\\IEDriverServer_x64_2.53.1\\IEDriverServer.exe");
		driver =new InternetExplorerDriver();
	}	
		
		baseUrl = "http://demostore.x-cart.com/";
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//PropertyConfiguration.configure("log4j.properties");
		driver.get(baseUrl);
  }

	@Test
	  public void testMethod() throws InterruptedException {
			
			driver.findElement(By.className("title")).click();
			Thread.sleep(9000);
			driver.findElement(By.xpath("//*[@id='page']//li[text()='Standard']")).click();
	  }
	
	
	@AfterMethod
  public void afterMethod() {
		
		//driver.quit();
  }
		
	
}
