package com.hiwi.exim.pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalDetailsPage {

	WebDriver driver;
	
	@FindBy(xpath ="//h2[normalize-space()='Personal Details']")
	WebElement personalDetailsLabel;
	
	@FindBy(id ="clientFirstName")
	WebElement clientFirstName;
	
	@FindBy(id ="clientLastName")
	WebElement clientLastName;
	
	@FindBy(id ="clientMobileNumber")
	WebElement mobileNumber;
	
	@FindBy(xpath ="//button[@id='basic-details-next-button']")
	WebElement nextButton;
	
	
	public String verifyPersonalDetailsLabel() {
		return personalDetailsLabel.getText();
	}
	
	public void clickNextPersonalDetails() {
		nextButton.click();
	}
	
	 public PersonalDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
