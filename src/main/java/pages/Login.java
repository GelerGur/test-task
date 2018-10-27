package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import settings.WebDriverSettings;

public class Login extends WebDriverSettings{

	
	
	 By loginLocator = By.cssSelector("#name");
	 By passLocator = By.cssSelector("#pass");
	By submitLocator = By.cssSelector("[class='submit button pull-right']");
	
	public  String user = "devops";
	public  String pass = "123456a";
	
	public  void login () {
		
		WebElement login =  driver.findElement(loginLocator);
		login.click();
		login.clear();
		login.sendKeys(user); 
		
		WebElement password = driver.findElement(passLocator);
		password.click();
		password.clear();
		password.sendKeys(pass); 
		
		driver.findElement(submitLocator).click();
		
		
	
	}
	
}
