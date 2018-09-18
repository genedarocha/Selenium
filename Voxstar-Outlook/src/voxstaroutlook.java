
//File:         $[voxstaroutlook.java]
//Created:      $[05.09.2018]
//Last Changed:
//    Date: $[05.09.2018]
//Author:       $Gene Da Rocha
//
//Standard Template example to hit the hotmail / outlook web site and perform a login 
//
//History:
//$Log: 
//Revision 1.0
//

//Standard import for Selenium and Java Libraries


//Standard import for Selenium and Java Libraries


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.Select;

//Class for Outlook
public class voxstaroutlook {
private WebDriver driver;
private String baseUrl;
private boolean acceptNextAlert = true;
private StringBuffer verificationErrors = new StringBuffer();


// Before the test , do some stuff 
@Before
public void setUp() throws Exception {
  System.setProperty("webdriver.gecko.driver", "/Users/genedarocha/Downloads/selenium/geckodriver");
   driver = new FirefoxDriver();
  baseUrl = "http://www.hotmail.com";
  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}


// At the Test
@Test
public void testhotmail() throws Exception {
 
	   
	// get the current baseurl address 
  driver.get(baseUrl);
  driver.findElement(By.xpath(" /html/body/section/div/div/div[2]/a[2]")).click();

  // find field element using by name and sending data email
  driver.findElement(By.name("loginfmt")).sendKeys( "genedarocha@gmail.com"); 
  
  // find element by id button and click it
  driver.findElement(By.id("idSIButton9")).click();
  
  // sleep for 2 seconds
  Thread.sleep(2000);
  
  // find element by name password and enter a password 
  driver.findElement(By.name("passwd")).sendKeys("password");
  
  // find element by id and click 
  driver.findElement(By.id("idSIButton9")).click();
 
  
  
  
}

// after the test , clean up, close browser 
@After
public void Conclude() throws Exception {
  driver.quit();
  String verificationErrorString = verificationErrors.toString();
  if (!"".equals(verificationErrorString)) {
    fail(verificationErrorString);
  }
}


}
