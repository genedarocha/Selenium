//File:         $[AmazonTestNG.java]
//Created:      $[05.09.2018]
//Last Changed:
//      Date: $[07.09.2018]
//Author:       $Gene Da Rocha
//
//Standard Template example to hit the amazon.co.uk web site and perform a search for 4K TV's 
//
//History:
//$Log: 
//Revision 1.0
//

// Standard import for Selenium and Java Libraries
import org.testng.annotations.Test;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

//Public class for AmazonTestNG
public class AmazonTestNG {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  
  // BeforeClass is the statement used in TestNG before a Test
  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	  
 // Setup gechodriver for Firefox	  
    System.setProperty("webdriver.gecko.driver","/Users/genedarocha/Downloads/selenium/geckodriver");
    driver = new FirefoxDriver();
    
 // Use URL = amazon.co.uk 
    baseUrl = "https://www.amazon.co.uk/"; 
   
 // Setup a default timeout 
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  // Doing the Test 
  public void testNG123() throws Exception {
	  
  // Get the url to Webdriver 
	    driver.get(baseUrl);
	    
  // Driver to find the relevant elements on the page for the text box and add '4K TV' to the Amazon search string
	    driver.findElement(By.id("twotabsearchtextbox")).sendKeys( "4k TV");

  // Driver to find an element using Xpath information and then perform a submit 
	    driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input")).submit();
	    
  }

  // After class to be called and used after Test
  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {

  // stop 
	driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }


}