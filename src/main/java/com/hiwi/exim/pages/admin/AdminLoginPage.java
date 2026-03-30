package com.hiwi.exim.pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {

	WebDriver driver;
	
	@FindBy(id ="email")
	WebElement email;
	
	@FindBy(css = "button[type='submit']")
	WebElement NextButon;
	
	@FindBy(xpath = "//input[@formcontrolname='otp1']")
	WebElement otp1;
	
	@FindBy(xpath = "//input[@formcontrolname='otp2']")
	WebElement otp2;
	
	@FindBy(xpath = "//input[@formcontrolname='otp3']")
	WebElement otp3;
	
	@FindBy(xpath = "//input[@formcontrolname='otp4']")
	WebElement otp4;
	
	@FindBy(css = "button[type='submit']")
	WebElement signInButton;
	
	public void adminLogin(String adminEmail, String OTP1, String OTP2, String OTP3, String OTP4) {
		
		email.sendKeys(adminEmail);
		NextButon.click();
		otp1.sendKeys(OTP1);
		otp2.sendKeys(OTP2);
		otp3.sendKeys(OTP3);
		otp4.sendKeys(OTP4);
		signInButton.click();
	}
	
	 public AdminLoginPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
}
