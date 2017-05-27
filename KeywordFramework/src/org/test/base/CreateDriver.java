package org.test.base;

import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.test.pages.LoginPage;
import org.testng.annotations.BeforeMethod;



public class CreateDriver {
	
	public WebDriver driver;
	public LoginPage login;
	
	@BeforeMethod
	
	public void LaunchDriver(){
		
		ResourceBundle rb = ResourceBundle.getBundle("config");
		
		if (rb.getString("browser").equalsIgnoreCase("chrome")){
			
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if (rb.getString("browser").equalsIgnoreCase("firefox")){
			
			driver = new FirefoxDriver();
		}
		
		else if (rb.getString("browser").equalsIgnoreCase("IE")){
			
			driver = new InternetExplorerDriver();
		}
		
		driver.get(rb.getString("url"));
		
		login = new LoginPage(driver);
		
	}

}
