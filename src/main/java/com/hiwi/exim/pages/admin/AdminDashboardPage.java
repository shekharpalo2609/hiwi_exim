package com.hiwi.exim.pages.admin;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminDashboardPage {

	WebDriver driver;

	@FindBy(xpath = "//span[normalize-space()='Users']")
	WebElement usersMenu;

	@FindBy(xpath = "//span[normalize-space()='Onboarding']")
	WebElement onboardingMenu;

	@FindBy(xpath = "//span[normalize-space()='Client']")
	WebElement clientOnboardingMenu;

	public void navigateToUsersScreen() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(usersMenu));
		usersMenu.click();
	}

	public void navigateToClientOnboardingScreen() {
		onboardingMenu.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(clientOnboardingMenu));
		clientOnboardingMenu.click();
	}

	public AdminDashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}