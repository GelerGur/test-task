package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;
import settings.WebDriverSettings;

public class OpenNewTicket extends WebDriverSettings{
	
 By emailAddressLocator = By.xpath("//input[@type='email']");
 By fullNameLocator = By.xpath("//input[@type='text'][@maxlength='64']");
 By phoneNumberLocator = By.xpath("//input[@type='tel']");
 By phoneNumberExtLocator = By.cssSelector("[name$='-ext']");
 By ddlHelpTopicLocator = By.cssSelector("#topicId");
 By optionDefectLocator = By.cssSelector("[value='12']");
By optionQuestionLocator = By.cssSelector("[value='13']");
 By issueSummaryLocator = By.cssSelector("[type='text'][maxlength='50']");
 By detailsLocator = By.cssSelector("[dir='ltr']");
 By submitlsLocator = By.cssSelector("[type='submit']");
By resetlsLocator = By.cssSelector("[type='reset']");
 By cancellsLocator = By.cssSelector("[name='cancel']");
 By ticketCreated = By.linkText("Support ticket request created");
 By testLocator = By.cssSelector("[class='form-header']");
 By assertTicketLocator = By.cssSelector("#msg_notice");


public  String emailAddressCorrect = "geler_test@ukr.net";
public  String fullNameCorrect = "Test-VK";
public  String phoneNumberCorrect = "1234567";
public  String phoneNumberExtCorrect = "380";
//public static String issueSummaryCorrect = "Test: 11228393428878";
public  String issueSummaryCorrect = "Test: " +String.valueOf(System.nanoTime());
 String detailsCorrect = "details is ok";

public  void fillNewTicket() {
	WebElement email = driver.findElement(emailAddressLocator);
	email.click();
	email.clear();
	email.sendKeys(emailAddressCorrect);
	
	WebElement fullName = driver.findElement(fullNameLocator);
	fullName.click();
	fullName.clear();
	fullName.sendKeys(fullNameCorrect);
	
	driver.findElement(phoneNumberLocator).click();
	driver.findElement(phoneNumberLocator).clear();
	driver.findElement(phoneNumberLocator).sendKeys(phoneNumberCorrect);
	
	driver.findElement(phoneNumberExtLocator).click();
	driver.findElement(phoneNumberExtLocator).clear();
	driver.findElement(phoneNumberExtLocator).sendKeys(phoneNumberExtCorrect);
	
	driver.findElement(ddlHelpTopicLocator).click();
	driver.findElement(optionDefectLocator).click();
	
	driver.findElement(issueSummaryLocator).click();
	driver.findElement(issueSummaryLocator).clear();
	driver.findElement(issueSummaryLocator).sendKeys(issueSummaryCorrect);
	
	driver.findElement(detailsLocator).click();
	driver.findElement(detailsLocator).clear();
	driver.findElement(detailsLocator).sendKeys(detailsCorrect);
	
	driver.findElement(submitlsLocator).click();	
		
}

public  void assertTicketCreated() {
	
	
	Assert.assertEquals("Support ticket request created", driver.findElement(assertTicketLocator).getText());
	//Assert.assertEquals("Contact Information", driver.findElement(testLocator).getText());
	System.out.println("Ticket is created on UI");
	
}


}
