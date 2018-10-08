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


public class NewTicketTest {
	
	
	public	static WebDriver driver;
	 
	 
	 @BeforeClass
	  public void setUp() {
		 driver= settings.WebDriverSettings.getWebDriver();

		  driver.get("http://safebreach-qa-test.dev.sbops.com/");
		  driver.manage().window().maximize();
		 // System.out.println("1");
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.findElement(By.cssSelector("[href='open.php']"));
		//  System.out.println("2");
		  
		  
	  }

	 
	
	@Test(priority =1)
  public void addNewTicket() throws IOException {
		WelcomePage.clickNewTicket();
		OpenNewTicket.fillNewTicket();
		OpenNewTicket.assertTicketCreated();
	}
	
	@Test (priority =2)
	  public void checkNewTicketUI() throws IOException {
		
		driver.get("http://safebreach-qa-test.dev.sbops.com/scp/login.php");
		Login.login(Login.user, Login.pass);
		OpenTicketTab.findTicet();
	}
	
	@Test(priority =3)
	  public void checkIssueSummaryDB() throws IOException {
		settings.scriptSQL.checkIssueSummary();
	}
	
	@Test(priority =4)
	  public void checkEmailDB() throws IOException {
		settings.scriptSQL.checkEmail();
	}
	@Test(priority =5)
	  public void checkfullNameDB() throws IOException {
		settings.scriptSQL.checkfullName();
	}
	
	@Test(priority =6)
	  public void checkPhoneDB() throws IOException {
		
		settings.scriptSQL.checkPhone();
		
  }
	
	 @AfterClass
	  public void closeWindow () {
		 driver.close();
		 //Need to add a clear test data.
		  
	  }
	
}
