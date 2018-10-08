package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;
import settings.WebDriverSettings;

public class OpenNewTicket extends WebDriverSettings{
	
static By emailAddressLocator = By.xpath("//input[@type='email']");
static By fullNameLocator = By.xpath("//input[@type='text'][@maxlength='64']");
static By phoneNumberLocator = By.xpath("//input[@type='tel']");
static By phoneNumberExtLocator = By.cssSelector("[name$='-ext']");
static By ddlHelpTopicLocator = By.cssSelector("#topicId");
static By optionDefectLocator = By.cssSelector("[value='12']");
By optionQuestionLocator = By.cssSelector("[value='13']");
static By issueSummaryLocator = By.cssSelector("[type='text'][maxlength='50']");
static By detailsLocator = By.cssSelector("[dir='ltr']");
static By submitlsLocator = By.cssSelector("[type='submit']");
By resetlsLocator = By.cssSelector("[type='reset']");
static By cancellsLocator = By.cssSelector("[name='cancel']");
static By ticketCreated = By.linkText("Support ticket request created");
static By testLocator = By.cssSelector("[class='form-header']");
static By assertTicketLocator = By.cssSelector("#msg_notice");


public static String emailAddressCorrect = "geler_test@ukr.net";
public static String fullNameCorrect = "Test-VK";
public static String phoneNumberCorrect = "1234567";
public static String phoneNumberExtCorrect = "380";
//public static String issueSummaryCorrect = "Test: 11228393428878";
public static String issueSummaryCorrect = "Test: " +String.valueOf(System.nanoTime());
static String detailsCorrect = "details is ok";

public static void fillNewTicket() {
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

public static void assertTicketCreated() {
	Assert.assertEquals("Support ticket request created", driver.findElement(assertTicketLocator).getText());
	//Assert.assertEquals("Contact Information", driver.findElement(testLocator).getText());
	System.out.println("Ticket is created on UI");
	
}


}
