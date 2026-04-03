package com.hiwi.exim.pages.admin;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class XFlowOnboardingPage {

	WebDriver driver;
	
	@FindBy(xpath ="//input[@placeholder='Search']")
	WebElement searchTextBox;
	
	@FindBy(xpath ="(//div/div/*[normalize-space()='Onboarding'])[1]")
	WebElement onboardingButton;
	
	@FindBy(xpath ="//span[normalize-space(.)='Set up Fee plan']/ancestor::mat-step-header//mat-icon[text()='check_circle']")
	WebElement verifiedIconForSetUpFeePlan;
	
	@FindBy(xpath ="//label[normalize-space()='Interval']")
	WebElement intervalDropdown;
	
	@FindBy(xpath ="//span[normalize-space()='Daily']")
	WebElement daily;
	
	@FindBy(xpath ="//button[normalize-space()='Save']")
	WebElement saveFees;
	
	@FindBy(xpath ="//button[normalize-space()='Done']")
	WebElement doneButton;
	
	
	public void startXflowOnboarding(String email) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(onboardingButton));
		searchTextBox.sendKeys(email);
		onboardingButton.click();
		wait.until(ExpectedConditions.visibilityOf(verifiedIconForSetUpFeePlan));
		intervalDropdown.click();
		wait.until(ExpectedConditions.visibilityOf(daily));
		daily.click();
		saveFees.click();
		wait.until(ExpectedConditions.visibilityOf(doneButton));
		doneButton.click();
	}
	
	public XFlowOnboardingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
