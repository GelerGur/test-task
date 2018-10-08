package settings;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebDriverSettings {

	
 public	static WebDriver driver;
 
 public static WebDriver getWebDriver() {
	 driver = new FirefoxDriver();
	  System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
	 return driver;
 }
 

}
