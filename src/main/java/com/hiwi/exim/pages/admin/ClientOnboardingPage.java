package com.hiwi.exim.pages.admin;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClientOnboardingPage {

	WebDriver driver;

	@FindBy(css = "input[placeholder='Search']")
	WebElement searchTextBox;

	@FindBy(xpath = "(//mat-icon[normalize-space()='more_vert'])[1]")
	WebElement actionsToggle;
	
	@FindBy(xpath = "//*[@class='mat-mdc-menu-item-text' and text()='Onboarding']")
	WebElement onboardingAction;
	
	//@FindBy(xpath = "//*[@ng-reflect-label='Client Status']//*[@role='combobox']")
	@FindBy(xpath = "//label[normalize-space() = 'Client Status']")
	WebElement clientStatusDropdown;
	
	@FindBy(xpath = "//span[normalize-space()= 'Approval In Progress']")
	WebElement approvalInProgress;
	
	@FindBy(xpath = "//*[text()='View/Edit']")
	WebElement ViewEditAction;
	
	
	

	public void searchClientEmail(String email) {
		By locator = By.cssSelector("input[placeholder='Search']");
		
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(10)).ignoring(StaleElementReferenceException.class)
				.ignoring(NoSuchElementException.class);
		
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loading-spinner")));

		WebElement searchbox = fluentWait.until(driver -> driver.findElement(locator));
		searchbox.clear();
		searchbox.sendKeys(email);
	}
	
	public void startOnboarding() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.elementToBeClickable(actionsToggle));
		actionsToggle.click();
		onboardingAction.click();
	}
	
	public void searchWithApprovalInProgress() {
		clientStatusDropdown.click();
		approvalInProgress.click();
	}
	
	public void feesSetUp() {
		actionsToggle.click();
		ViewEditAction.click();
		
	}
	

	public ClientOnboardingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
