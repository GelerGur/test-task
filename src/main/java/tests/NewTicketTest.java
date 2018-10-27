package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Login;
import pages.OpenNewTicket;
import pages.OpenTicketTab;
import pages.WelcomePage;
import settings.scriptSQL;


public class NewTicketTest {
	
	
	public	static WebDriver driver;
	 
	 
	 @BeforeClass
	  public void setUp() {
		 driver= settings.WebDriverSettings.getWebDriver();

		  driver.get("http://safebreach-qa-test.dev.sbops.com/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.findElement(By.cssSelector("[href='open.php']"));
		 	  
		  
	  }

	 
	
	@Test(priority =1)
  public void addNewTicket() throws IOException {
		WelcomePage newTicket = new WelcomePage();
		OpenNewTicket openNewTicket = new OpenNewTicket();
		newTicket.clickNewTicket();
		openNewTicket.fillNewTicket();
		openNewTicket.assertTicketCreated();
	}
	
	@Test (priority =2)
	  public void checkNewTicketUI() throws IOException {
		
		driver.get("http://safebreach-qa-test.dev.sbops.com/scp/login.php");
		
		Login login = new Login();
		login.login();
		OpenTicketTab openTicketTab = new OpenTicketTab();
		openTicketTab.findTicet();
	}
	
	@Test(priority =3)
	  public void checkIssueSummaryDB() throws IOException {
		scriptSQL sql = new scriptSQL();	
		sql.checkIssueSummary();
	}
	
	@Test(priority =4)
	  public void checkEmailDB() throws IOException {
		scriptSQL sql = new scriptSQL();	
		sql.checkEmail();
	}
	@Test(priority =5)
	  public void checkfullNameDB() throws IOException {
		scriptSQL sql = new scriptSQL();	
		sql.checkfullName();
	}
	
	@Test(priority =6)
	  public void checkPhoneDB() throws IOException {
		scriptSQL sql = new scriptSQL();			
		sql.checkPhone();
		
  }
	
	 @AfterClass
	  public void closeWindow () {
		 driver.close();
		 //Need to add a clear test data.
		  
	  }
	
}
