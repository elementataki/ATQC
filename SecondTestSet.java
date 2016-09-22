package DriverTesting;

import org.junit.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SecondTestSet {
	WebDriver browser;
	
	@Before
	public void OpenIE() {
		System.setProperty("webdriver.ie.driver", "C:/selenium/IE/IEDriverServer.exe");
		browser = new InternetExplorerDriver();
	}
	
	@Test
	public void IETest() {
				
		browser.get("https://www.google.com.ua");
		
		WebElement div = browser.findElement(By.id("hplogo"));
		String title = div.getAttribute("title");
		
		Assert.assertEquals("Google", title);
	}
	
	@Test
	public void IESearchTest() throws InterruptedException {
				
		browser.get("https://www.google.com.ua");
		
		WebElement input = browser.findElement(By.id("lst-ib"));
		input.sendKeys("SoftServe");
		
		Thread.sleep(1000);
		
		WebElement link = browser.findElement(By.partialLinkText("SoftServe"));
		String linkText = link.getText();
	
		Assert.assertTrue(linkText.contains("SoftServe"));
	}
	
	@After
	public void CloseIE() {
		browser.close();
	}
}