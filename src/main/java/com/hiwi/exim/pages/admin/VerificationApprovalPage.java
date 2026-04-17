package com.hiwi.exim.pages.admin;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerificationApprovalPage {

	WebDriver driver;

	@FindBy(xpath = "//span//*[normalize-space()='Verification & Approval']")
	WebElement verificationApprovalTab;

	@FindBy(css = "input[formcontrolname='iecNumber']")
	WebElement iecTextbox;

	@FindBy(xpath = "//button[normalize-space()='Verify']")
	WebElement verifyButton;

	@FindBy(css = "input[formcontrolname='gstNumber']")
	WebElement gstTextbox;

	@FindBy(xpath = "//div[@class='button-wrapper']/i")
	WebElement verifiedIecIcon;

	@FindBy(xpath = "(//div[@class='button-wrapper']/i)[2]")
	WebElement verifiedGstIcon;

	//@FindBy(xpath = "//*[@ng-reflect-name='status']")
	@FindBy(xpath = "//label[normalize-space()='Status']")
	WebElement statusDropdown;

	@FindBy(xpath = "//*[@value='Approved']")
	WebElement approvedStatus;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement saveStatusButton;
	
	@FindBy(xpath = "(//*[normalize-space()='Back to Client Onboarding List'])[2]")
	WebElement backToClientOnboardingListLabel;

	public void settingApprovedStatusForGoodsExporter() {
		verificationApprovalTab.click();
		iecTextbox.sendKeys("3598004842");
		verifyButton.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(verifiedIecIcon));

		gstTextbox.sendKeys("37AAACC1206D2ZE");
		verifyButton.click();

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOf(verifiedGstIcon));

		statusDropdown.click();
		approvedStatus.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

		js.executeScript("arguments[0].scrollIntoView(true);", saveStatusButton);
		wait2.until(ExpectedConditions.elementToBeClickable(saveStatusButton));
		saveStatusButton.click();
		
		wait2.until(ExpectedConditions.visibilityOf(backToClientOnboardingListLabel));
		js.executeScript("window.scrollTo(0, 0);");
		
	}

	public VerificationApprovalPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
