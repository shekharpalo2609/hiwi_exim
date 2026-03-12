package com.hiwi.exim.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class Base {

	protected WebDriver driver;

	  @BeforeTest
	public void launchBrowser() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	//  @AfterMethod
	public void closeBrowser() {
		 if (driver != null) {
	            driver.quit();
	        }
	}
}
