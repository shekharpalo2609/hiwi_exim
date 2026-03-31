package com.hiwi.exim.pages.admin;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FeesSetupPage {

	WebDriver driver;

	@FindBy(xpath = "//*[normalize-space()='Add Fees & FX']")
	WebElement addFeesAndFxButton;
	
	@FindBy(xpath ="//label[normalize-space()='Payout Fees']")
	WebElement payoutFeesRadioButton;
	
	
	
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
	}

	public FeesSetupPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}