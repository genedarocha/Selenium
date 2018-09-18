
//File:         $[amazonvoxstar.java]
//Created:      $[05.09.2018]
//Last Changed:
//      Date: $[05.09.2018]
//Author:       $Gene Da Rocha
//
//Standard Template example to hit the skynews web site and perform a search 
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


// Class for Skynews
public class Skynews{
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  // Before the test , do some stuff 
  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.gecko.driver", "/Users/genedarocha/Downloads/selenium/geckodriver");
     driver = new FirefoxDriver();
    baseUrl = "https://news.sky.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  
  // At the Test
  @Test
  public void testAmazon() throws Exception {
   
   // get the current baseurl address
    driver.get(baseUrl);

   // find field element using XPath and add the word news  
   driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div/div/div[2]/div/form/input[1]")).sendKeys("News");
 
   // find the button field, using Xpath and execute 
   driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div/div/div[2]/div/form/button/svg")).submit();
    
   

    
  }

  @After
  
  // After test ,close browser and some checks.
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

}

 


