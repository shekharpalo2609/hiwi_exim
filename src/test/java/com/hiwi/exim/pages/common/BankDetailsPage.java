package com.hiwi.exim.pages.common;

import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BankDetailsPage {

	WebDriver driver;
	String bankFilePath = "src/test/resources/testdata/files/bank";
	
	@FindBy(xpath = "//label[normalize-space() = 'Bank Account']")
	WebElement bankAccountRadioButton;
	
	@FindBy(xpath = "//*[@id='cheque-upload-btn']/button/../input")
	WebElement uploadChecque;
	
	@FindBy(xpath ="//button[@id='bank-verify-next-button']")
	WebElement nextButton;
	
	public void saveBankDetails() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(bankAccountRadioButton)).click();;
		
		String absolutePath = Paths.get(bankFilePath, "cheque_ICICI.png").toAbsolutePath().toString();
		uploadChecque.sendKeys(absolutePath);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
	}
	
	public BankDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
}
