package com.hiwi.exim.pages.admin;

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

public class FeesSetupPage {

	WebDriver driver;

	@FindBy(xpath = "//*[normalize-space()='Add Fees & FX']")
	WebElement addFeesAndFxButton;

	@FindBy(xpath = "//label[normalize-space()='Payout Fees']")
	WebElement payoutFeesRadioButton;

	@FindBy(xpath = "//mat-label[.='Source Currency']")
	WebElement sourceCurrencyDropdown;

	// mat-option[normalize-space(.)='ANY']
	@FindBy(xpath = "//mat-option[normalize-space(.)='ANY']")
	WebElement anyCurrency;

	@FindBy(xpath = "//mat-label[.='Destination Currency']")
	WebElement destinationCurrencyDropdown;

	@FindBy(xpath = "//input[@formcontrolname='fixed']")
	WebElement fixed;

	@FindBy(xpath = "//input[@formcontrolname='minimum']")
	WebElement minimum;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement saveButton;

	@FindBy(xpath = "//label[normalize-space()='Payout FX']")
	WebElement payoutFxRadioButton;

	@FindBy(xpath = "//input[@formcontrolname='variable']")
	WebElement variable;

	@FindBy(xpath = "//label[normalize-space()='Reference Rate']")
	WebElement referenceRateDropdown;

	@FindBy(xpath = "//button[normalize-space()='Submit']")
	WebElement submitButton;

	public void addFees() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int i = 0; i < 5; i++) {
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(addFeesAndFxButton)).click();

		payoutFeesRadioButton.click();
		sourceCurrencyDropdown.click();
		anyCurrency.click();
		destinationCurrencyDropdown.click();
		anyCurrency.click();
		fixed.sendKeys("5");
		minimum.sendKeys("2");
		saveButton.click();

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.elementToBeClickable(addFeesAndFxButton)).click();

		payoutFxRadioButton.click();
		sourceCurrencyDropdown.click();
		anyCurrency.click();
		destinationCurrencyDropdown.click();
		anyCurrency.click();
		variable.sendKeys("0.5");
		referenceRateDropdown.click();
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		saveButton.click();
		submitButton.click();

	}

	public FeesSetupPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}