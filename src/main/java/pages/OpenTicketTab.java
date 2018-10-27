package pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import settings.WebDriverSettings;

public class OpenTicketTab extends WebDriverSettings{

	
	 String userName;
	 By ticetElementLocator = By. xpath("//tbody//tr");
	 By subjectLocator = By.cssSelector("[class$='link truncate']");
//	 By emaiLocator = By.cssSelector("#"+ticket_id+">td[title='"+OpenNewTicket.emailAddressCorrect+"']");
	 By userNameLocator = By.cssSelector("[class='truncate']");
	public  String ticket_id;
	
	
	public  void findTicet() {	
		
		
		List <WebElement> list = driver.findElements(ticetElementLocator);
		Iterator <WebElement> iterator = list.iterator();
	
		while(iterator.hasNext()) {				
			WebElement element = iterator.next();
			List <WebElement> subjectTicket = element.findElements(subjectLocator);
			OpenNewTicket open = new OpenNewTicket();
			String subject = subjectTicket.get(0).getText();
			System.out.println(subject);
			if (subject.equals(open.issueSummaryCorrect)) {
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
