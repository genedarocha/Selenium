
//File:         $[voxstarexcel.java]
//Created:      $[05.09.2018]
//Last Changed:
//    Date: $[10.09.2018]
//Author:       $Gene Da Rocha
//
//Standard Template example to read data from a data source : excel and used within Selenium
//
//History:
//$Log: 
//Revision 1.0
//


package excel;

//Standard import for Selenium and Java Libraries
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.Select;
import jxl.*;
import java.io.*;


//Class for Excel file
public class voxstarexcel {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  
  // Before the Test.
  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.gecko.driver", "/Users/genedarocha/Downloads/selenium/geckodriver");
     driver = new FirefoxDriver();
    baseUrl = "http://www.google.com";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  
  
  @Test
  // During the Test
  public void testAmazon() throws Exception {
   
    FileInputStream fi = new FileInputStream("/Users/genedarocha/Downloads/selenium/excelbook.xls");
	Workbook w = Workbook.getWorkbook(fi);
	Sheet s= w.getSheet(0); 
	String kw= s.getCell(0,0).getContents(); 
	

	  
    driver.get(baseUrl);
    driver.findElement(By.name("q")).sendKeys(kw);
    driver.findElement(By.name("q")).submit();

    
 
  }

  // After the test including closing the browser.
  @After
  public void CloseDown() throws Exception {
 //   driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  
}

 


