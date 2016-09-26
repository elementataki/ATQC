package DriverTesting;

import org.junit.*;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Comments {
	WebDriver browser;
	
	@Before
	public void OpenChrome(){
		System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");
		browser = new ChromeDriver();		
	}
	
	@Test
	public void CommentsCustomPopUpTest() {
		browser.get("http://comments.azurewebsites.net/");
		
		WebElement deleteButton = browser.findElement(By.cssSelector(".buttonAsLink[value=Delete]"));
		deleteButton.click();		
		
		WebElement popup = browser.findElement(By.className("ui-dialog"));
		String msg = popup.findElement(By.id("msgText")).getText();
		
		/*String text;
		
		try {
		    Alert alert = browser.switchTo().alert();
		    text = alert.getText();
		} catch (Exception e) {
		    text = "Alert not found";
		}*/
		
		Assert.assertEquals("Please select at least one comment", msg);
	}
	
	@After
	public void CloseChrome() {
		browser.close();
	}
}