package com.hiwi.exim.pages.common;

import java.io.File;
import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.By;
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
	String filePath;

	@FindBy(id = "businessBusinessLegalName")
	WebElement businessLegalName;

	public void enterBusinessLegalName(String businessName) {
		businessLegalName.sendKeys(businessName);
	}

	@FindBy(xpath = "//*[@ng-reflect-label='Business Type']")
	WebElement businessType;

	@FindBy(xpath = "//*[@ng-reflect-value='Merchant']")
	WebElement merchant;

	public void selectBusinessType(String type) {
		businessType.click();
		WebElement option = driver.findElement(By.xpath("//*[@ng-reflect-value='" + type + "']"));
		option.click();
	}

	@FindBy(xpath = "//app-select-dropdown[@ng-reflect-label='Company Type']")
	WebElement companyType;

	@FindBy(xpath = "//SPAN[normalize-space(.)='Sole Proprietor']")
	WebElement soleProprietor;

	public void selectCompanyType(String type) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(companyType)).click();

		WebElement option = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space(.)='" + type + "']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
		option.click();
	}

	@FindBy(id = "businessAddress1")
	WebElement addressLine1;

	@FindBy(id = "businessAddress2")
	WebElement addressLine2;

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

	public void addressDetails(String addressLine1, String addressLine2, String city, String zip) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(this.addressLine1));
		this.addressLine1.sendKeys(addressLine1);
		this.addressLine2.sendKeys(addressLine2);

		WebDriverWait waitStateView = new WebDriverWait(driver, Duration.ofSeconds(10));
		waitStateView.until(ExpectedConditions.visibilityOf(stateTextField));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", stateTextField);

		WebDriverWait waitState = new WebDriverWait(driver, Duration.ofSeconds(30));
		waitState.until(ExpectedConditions.elementToBeClickable(stateTextField));
		stateTextField.click();

		WebDriverWait waitStateSearch = new WebDriverWait(driver, Duration.ofSeconds(10));
		waitStateSearch.until(ExpectedConditions.elementToBeClickable(searchState));
		searchState.sendKeys("Maha");
		searchState.sendKeys(Keys.ENTER);

		this.city.sendKeys(city);

		zipCode.sendKeys(zip);
	}

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
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOf(businessDescription));
		industry.click();
		Actions actions = new Actions(driver);
		for (int i = 0; i < 5; i++) {
			actions.sendKeys(Keys.ENTER).sendKeys(Keys.ARROW_DOWN).perform();
		}
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

	@FindBy(xpath = "//*[@id='iec-upload-btn']/button/../input")
	WebElement uploadIEC;

	@FindBy(xpath = "//*[@id='efira-upload-btn']/button/../input")
	WebElement uploadEfira;

	@FindBy(xpath = "//*[@id='inv-upload-btn']/button/../input")
	WebElement uploadInvoice;

	private void uploadBusinessFile(WebElement element, String fileName) {
		String filePath = Paths.get(businessFilePath, fileName).toAbsolutePath().toString();
		File file = new File(filePath);
		if (!file.exists()) {
			throw new RuntimeException("File not found: " + filePath);
		}
		element.sendKeys(filePath);
	}

	public void uploadGST() {
		uploadBusinessFile(uploadGST, "GST_certificate.pdf");
	}

	public void uploadIEC() {
		uploadBusinessFile(uploadIEC, "IEC_certificate.pdf");
	}

	public void uploadEFIRA() {
		uploadBusinessFile(uploadEfira, "eFira.pdf");
	}

	public void uploadInvoice() {
		uploadBusinessFile(uploadInvoice, "Invoice_Template.pdf");
	}

	public void uploadBusinessFilesForSoleProprietor() {
		uploadGST();
		uploadIEC();
		uploadEFIRA();
		uploadInvoice();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
