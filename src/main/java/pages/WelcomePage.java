package pages;

import org.openqa.selenium.By;
import settings.WebDriverSettings;



public class WelcomePage extends WebDriverSettings{

		
	 By buttonNewTicketLocator = By.cssSelector("[href='open.php']");
	
	public  void clickNewTicket() {
		driver.findElement(buttonNewTicketLocator).click();
		
		  
	}
	
	
	
}
