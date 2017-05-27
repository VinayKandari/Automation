package org.test.pages;

import java.util.ResourceBundle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	ResourceBundle rb;
	
	public LoginPage(WebDriver driver){
		
		this.driver = driver;
		rb = ResourceBundle.getBundle("Element");
	}
	
	public void enterUserName(String uname){
		
		driver.findElement(By.id(rb.getString("login_username_id"))).sendKeys(uname);
	}

	public void enterPassword(String pass){
		
		driver.findElement(By.id(rb.getString("login_password_id"))).sendKeys(pass);
	}
}
