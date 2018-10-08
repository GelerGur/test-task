package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import settings.WebDriverSettings;

public class Login extends WebDriverSettings{

	
	
	static By loginLocator = By.cssSelector("#name");
	static By passLocator = By.cssSelector("#pass");
	static By submitLocator = By.cssSelector("[class='submit button pull-right']");
	
	public static String user = "devops";
	public static String pass = "123456a";
	
	public static void login (String user, String pass) {
		
		WebElement login = driver.findElement(loginLocator);
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
