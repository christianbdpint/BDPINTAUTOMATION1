package BDP;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class test2 {
  private WebDriver Driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	 
	System.setProperty("webDriver.gecko.Driver","C:\\Users\\cmabila\\Downloads\\geckoDriver-v0.19.1-win64\\geckoDriver.exe");
    Driver = new FirefoxDriver();
    
    //URL
    baseUrl = "https://www.google.com/";
    Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void test1() throws Exception {
    Driver.get(baseUrl + "/");
    Driver.findElement(By.id("lst-ib")).clear();
    Driver.findElement(By.id("lst-ib")).sendKeys("bdp international");
    Thread.sleep(4500);
    Thread.sleep(4000);
    
    //ADding time
    Thread.sleep(7650);
    Thread.sleep(9000);
  }

  @After
  public void tearDown() throws Exception {
    Driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      Driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      Driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = Driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
