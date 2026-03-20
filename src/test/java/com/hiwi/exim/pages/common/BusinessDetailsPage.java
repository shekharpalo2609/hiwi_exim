package com.hiwi.exim.pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BusinessDetailsPage {

	WebDriver driver;

	@FindBy(id = "businessBusinessLegalName")
	WebElement businessLegalName;
	
	//@FindBy()

	@FindBy(id = "businessAddress1")
	WebElement addressLine1;

	@FindBy(id = "businessAddress2")
	WebElement addressLine2;

	@FindBy(xpath = "//*[@id='businessState']//input")
	WebElement state;

	@FindBy(css = "input[placeholder='Search state']")
	WebElement selectState;

	@FindBy(css = "input[id='businessCity']")
	WebElement city;

	@FindBy(css = "input[id='businessPinCode']")
	WebElement zipCode;

	@FindBy(xpath = "//input[@id='businessWebSite']")
	WebElement website;

	@FindBy(xpath = "//input[@id='businessEstimatedMonthlyVolume']")
	WebElement monthlyVolume;

	@FindBy(xpath = "//input[@id='businessEstimatedTotalShipments']")
	WebElement totalShipment;
	
	@FindBy(xpath = "//*[@id='gstin-upload-btn']/button")
	WebElement uploadGST;
	
	@FindBy(xpath = "//*[@id='iec-upload-btn']/button")
	WebElement uploadIEC;
	
	@FindBy(xpath = "//*[@id='efira-upload-btn']/button")
	WebElement uploadEfira;

	@FindBy(xpath = "//*[@id='inv-upload-btn']/button")
	WebElement uploadInvoice;

	@FindBy(xpath = "//button[@id='business-next-button']")
	WebElement nextButton;
	
	

	public void enterBusinessLegalName(String businessName) {
		businessLegalName.sendKeys(businessName);
	}

	public void enterAddressLine1(String address1) {
		addressLine1.sendKeys(address1);
	}

	public void enterAddressLine2(String address2) {
		addressLine2.sendKeys(address2);
	}

	public void selectState() {
		state.click();
	}

	public void enterCity(String city) {
		this.city.sendKeys(city);
	}

	public void enterZipcode(String zip) {
		zipCode.sendKeys(zip);
	}

	public void enterWebsite(String website) {
		this.website.sendKeys(website);
	}

	public void enterMonthlyVolume(String volume) {
		monthlyVolume.sendKeys(volume);
	}

	public void enterTotalShipment(String shipment) {
		totalShipment.sendKeys(shipment);
	}
	
	public void uploadGSTFile(String gstFile) {
		uploadGST.sendKeys(gstFile);
	}
	
	
	
	
	

	public BusinessDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
