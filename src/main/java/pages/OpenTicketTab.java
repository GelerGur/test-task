package pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import settings.WebDriverSettings;

public class OpenTicketTab extends WebDriverSettings{

	
	static String userName;
	static By ticetElementLocator = By. xpath("//tbody//tr");
	static By subjectLocator = By.cssSelector("[class$='link truncate']");
//	static By emaiLocator = By.cssSelector("#"+ticket_id+">td[title='"+OpenNewTicket.emailAddressCorrect+"']");
	static By userNameLocator = By.cssSelector("[class='truncate']");
	public static String ticket_id;
	
	
	public static void findTicet() {	
		
		
		List <WebElement> list = driver.findElements(ticetElementLocator);
		Iterator <WebElement> iterator = list.iterator();
	
		while(iterator.hasNext()) {				
			WebElement element = iterator.next();
			List <WebElement> subjectTicket = element.findElements(subjectLocator);
			String subject = subjectTicket.get(0).getText();
			System.out.println(subject);
			if (subject.equals(OpenNewTicket.issueSummaryCorrect)) {
				System.out.println("Ticket created and found");
				ticket_id = element.getAttribute("id");
				System.out.println("ticket_id="+ticket_id);
				System.out.println(element.findElement(userNameLocator).getText());
				// Add check for all attributes 
				break;
			}
			
			
			
		
		}	
	}
	
	
	
	
}
