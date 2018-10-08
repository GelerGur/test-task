package pages;

import org.openqa.selenium.By;
import settings.WebDriverSettings;



public class WelcomePage extends WebDriverSettings{

		
	static By buttonNewTicketLocator = By.cssSelector("[href='open.php']");
	
	public static void clickNewTicket() {
		driver.findElement(buttonNewTicketLocator).click();
		
		  
	}
	
	
	
}
