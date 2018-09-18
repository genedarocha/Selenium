//File:         $[amazonvoxstar.java]
//Created:      $[05.09.2018]
//Last Changed:
//      Date: $[05.09.2018]
//Author:       $Gene Da Rocha
//
//Standard Template example to hit the amazon.co.uk web site and perform a search for 4K TV's 
//
//History:
//$Log: 
//Revision 1.0
//

// Standard import for Selenium and Java Libraries
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.Select;

// Public class for AmazonVoxstar
public class AmazonVoxstar{

// Setup variables
private WebDriver driver;
private String baseUrl;
private boolean acceptNextAlert = true;
private StringBuffer verificationErrors = new StringBuffer();

@Before

// operations setup before test 
public void setUp() throws Exception {

// message to set property to source directory
	System.setProperty("webdriver.gecko.driver", "/Users/genedarocha/Downloads/selenium/geckodriver");

// setup new call to Firefox Driver 
driver = new FirefoxDriver();

// setup a base url as Amazon.co.uk site 
 baseUrl = "http://www.amazon.co.uk";
 
 // setup a timer as required 
 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
}



@Test
// During the actual test 
public void testAmazon() throws Exception {
	
// Webdriver variable driver to get/use the base url as defined above
	    driver.get(baseUrl);
	    
// Using Webdriver variable driver to find search box name by id and sending the field an input text of field 
	    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("4k TV");
	   
// Using Webdriver variable driver to use xpath to find specific variable and submit the request
	    driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[3]/div/form/div[2]/div/input")).submit();
}

@After
// After the test using this class 
public void AfterTest() throws Exception {
	
// ask the driver to close 
driver.quit(); 

// setup string to hold verifications errors 
 String verificationErrorString = verificationErrors.toString();
 if (!"".equals(verificationErrorString)) {
   fail(verificationErrorString);
 }
}
}





