package com.hiwi.exim.pages.common;

import java.io.File;
import java.nio.file.Paths;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KYCDetailsPage {

	WebDriver driver;
	String KYCFilePath = "src/test/resources/testdata/files/kyc";
	String filePath;

	@FindBy(id = "stakeholders-owner-add-button")
	WebElement addOwnerButton;

	@FindBy(xpath = "//*[@id='owner-pan']//button/../input")
	WebElement uploadOwnerPan;

	@FindBy(xpath = "//*[contains(text(),'Proof of Address Type')]")
	WebElement proofTypeDropdown;

	@FindBy(xpath = "//MAT-OPTION[normalize-space(.)='Passport']")
	WebElement passportOption;

	@FindBy(xpath = "(//*[@id='owner-poa']//button/../input)[1]")
	WebElement passportFront;

	@FindBy(xpath = "(//*[@id='owner-poa']//button/../input)[2]")
	WebElement passportBack;

	@FindBy(xpath = "//*[@id='stakeholders-owner-save-button']")
	WebElement saveOwnerButton;

	@FindBy(xpath = "//*[@id='stakeholders-next-button']")
	WebElement nextButton;

	private void uploadKYCFile(WebElement element, String fileName) {
		String filePath = Paths.get(KYCFilePath, fileName).toAbsolutePath().toString();
		File file = new File(filePath);
		if (!file.exists()) {
			throw new RuntimeException("File not found: " + filePath);
		}
		element.sendKeys(filePath);
	}

	public void uploadOwnerPAN() {
		uploadKYCFile(uploadOwnerPan, "pan-verification-personal.png");
	}

	public void uploadPassportFront() {
		uploadKYCFile(passportFront, "Passport_front.jpg");
	}

	public void uploadPassportBack() {
		uploadKYCFile(passportBack, "Passport_back.jpg");
	}

	public void saveKYCDetailsSoleProprietor() {

		addOwnerButton.click();
		uploadOwnerPAN();

		proofTypeDropdown.click();
		passportOption.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", nextButton);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		uploadPassportFront();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		uploadPassportBack();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		saveOwnerButton.click();
		nextButton.click();
	}

	public KYCDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
