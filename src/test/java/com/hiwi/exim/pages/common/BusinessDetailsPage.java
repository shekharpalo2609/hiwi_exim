package com.hiwi.exim.pages.common;

import java.io.File;
import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BusinessDetailsPage {

	WebDriver driver;
	String businessFilePath = "src/test/resources/testdata/files/business";

	@FindBy(id = "businessBusinessLegalName")
	WebElement businessLegalName;

	public void enterBusinessLegalName(String businessName) {
		businessLegalName.sendKeys(businessName);
	}

	@FindBy(xpath = "//*[@ng-reflect-label='Business Type']")
	WebElement businessType;

	@FindBy(xpath = "//*[@ng-reflect-value='Merchant']")
	WebElement merchant;

	public void selectMerchant() {
		businessType.click();
		merchant.click();
	}

	@FindBy(xpath = "//app-select-dropdown[@ng-reflect-label='Company Type']")
	WebElement companyType;

	@FindBy(xpath = "//SPAN[normalize-space(.)='Sole Proprietor']")
	WebElement soleProprietor;

	public void selectSoleProprietor() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.elementToBeClickable(companyType)).click();

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", soleProprietor);
		soleProprietor.click();

	}

	@FindBy(id = "businessAddress1")
	WebElement addressLine1;

	@FindBy(id = "businessAddress2")
	WebElement addressLine2;

	public void addressDetails(String addressLine1, String addressLine2, String city, String zip) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(this.addressLine1));
		this.addressLine1.sendKeys(addressLine1);
		this.addressLine2.sendKeys(addressLine2);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", stateTextField);

		WebDriverWait waitState = new WebDriverWait(driver, Duration.ofSeconds(10));
		waitState.until(ExpectedConditions.elementToBeClickable(stateTextField));
		stateTextField.click();

		WebDriverWait waitStateSearch = new WebDriverWait(driver, Duration.ofSeconds(10));
		waitStateSearch.until(ExpectedConditions.elementToBeClickable(searchState));
		searchState.sendKeys("Maha");
		searchState.sendKeys(Keys.ENTER);
		
		this.city.sendKeys(city);
		
		zipCode.sendKeys(zip);
	}


	@FindBy(xpath = "//*[@id='businessState']")
	WebElement stateTextField;

	@FindBy(css = "input[placeholder='Search state']")
	WebElement searchState;

	
	@FindBy(css = "input[id='businessCity']")
	WebElement city;

	public void enterCity(String city) {
		this.city.sendKeys(city);
	}

	@FindBy(css = "input[id='businessPinCode']")
	WebElement zipCode;

	public void enterZipcode(String zip) {
		zipCode.sendKeys(zip);
	}

	@FindBy(xpath = "//input[@id='businessWebSite']")
	WebElement website;

	public void enterWebsite(String website) {
		this.website.sendKeys(website);
	}

	@FindBy(xpath = "//*[@id='businessIndustry']")
	WebElement industry;

	public void selectIndustry() {
		industry.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		actions.sendKeys(Keys.ARROW_DOWN).perform();
		actions.sendKeys(Keys.ENTER).perform();
		actions.sendKeys(Keys.ARROW_DOWN).perform();
		actions.sendKeys(Keys.ENTER).perform();
		actions.sendKeys(Keys.ARROW_DOWN).perform();
		actions.sendKeys(Keys.ENTER).perform();
		actions.sendKeys(Keys.ARROW_DOWN).perform();
		actions.sendKeys(Keys.ENTER).perform();
		actions.sendKeys(Keys.TAB).perform();
	}

	@FindBy(xpath = "//input[@id='businessEstimatedMonthlyVolume']")
	WebElement monthlyVolume;

	public void enterMonthlyVolume() {
		monthlyVolume.sendKeys("10000");
	}

	@FindBy(xpath = "//input[@id='businessTotalShipments']")
	WebElement totalShipment;

	public void enterTotalShipment(String shipment) {
		totalShipment.sendKeys(shipment);
	}

	@FindBy(xpath = "//textarea[@id='businessBusinessDescription']")
	WebElement businessDescription;

	public void enterBusinessDescription(String description) {
		businessDescription.sendKeys(description);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", nextButton);

	}

	@FindBy(xpath = "//*[@id='gstin-upload-btn']/button/../input")
	WebElement uploadGST;

	public void uploadGST() {
		String filePath = Paths.get(businessFilePath + "/GST_certificate.pdf").toAbsolutePath()
				.toString();
		File file = new File(filePath);
		if (!file.exists()) {
			throw new RuntimeException("File not found: " + filePath);
		}
		uploadGST.sendKeys(filePath);
	}

	@FindBy(xpath = "//*[@id='iec-upload-btn']/button/../input")
	WebElement uploadIEC;

	public void uploadIEC() {
		String filePath = Paths.get(businessFilePath + "/IEC_certificate.pdf").toAbsolutePath()
				.toString();
		File file = new File(filePath);
		if (!file.exists()) {
			throw new RuntimeException("File not found: " + filePath);
		}
		uploadIEC.sendKeys(filePath);
	}

	@FindBy(xpath = "//*[@id='efira-upload-btn']/button/../input")
	WebElement uploadEfira;

	public void uploadEFIRA() {
		String filePath = Paths.get(businessFilePath + "/eFira.pdf").toAbsolutePath().toString();
		File file = new File(filePath);
		if (!file.exists()) {
			throw new RuntimeException("File not found: " + filePath);
		}
		uploadEfira.sendKeys(filePath);
	}

	@FindBy(xpath = "//*[@id='inv-upload-btn']/button/../input")
	WebElement uploadInvoice;

	public void uploadInvoice() {
		String filePath = Paths.get(businessFilePath + "/Invoice_Template.pdf").toAbsolutePath()
				.toString();
		File file = new File(filePath);
		if (!file.exists()) {
			throw new RuntimeException("File not found: " + filePath);
		}
		uploadInvoice.sendKeys(filePath);
	}

	@FindBy(xpath = "//button[@id='business-next-button']")
	WebElement nextButton;

	public void clickNext() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
	}

	public BusinessDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
