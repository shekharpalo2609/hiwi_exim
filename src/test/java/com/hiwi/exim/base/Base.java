package com.hiwi.exim.base;

import java.io.IOException;
import java.time.Duration
;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.hiwi.exim.pages.admin.AdminLoginPage;
import com.hiwi.exim.utils.ConfigReader;
import com.hiwi.exim.utils.DriverManager;
import com.hiwi.exim.utils.EmailReportSender;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	protected WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();

		String headless = System.getProperty("headless");

		if ("true".equalsIgnoreCase(headless)) {
			options.addArguments("--headless=new");
			options.addArguments("--window-size=1920,1080");
		}

		options.addArguments("--disable-notifications");
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-gpu");
		options.addArguments("--no-sandbox");

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		DriverManager.setDriver(driver);

		// Perform login once browser is launched
		driver.get(ConfigReader.getAdminSigninUrl());
		AdminLoginPage login = new AdminLoginPage(driver);
		login.adminLogin(ConfigReader.getProperty("admin.email"), ConfigReader.getProperty("otp1"),
				ConfigReader.getProperty("otp2"), ConfigReader.getProperty("otp3"), ConfigReader.getProperty("otp4"));
	}

	// @AfterMethod
	public void closeBrowser() {
		if (DriverManager.getDriver() != null) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
	
	//@AfterSuite
	public void sendReport() throws AddressException, MessagingException, IOException {
		
		String reportPath = "test-output/emailable-report.html";
		String managerEmail = "paloskrqa@gmail.com";
		EmailReportSender.sendReport(reportPath, managerEmail);
	}
}