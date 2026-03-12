package com.hiwi.exim.pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashboardPage {

	WebDriver driver;

	@FindBy(xpath = "//button/span[normalize-space()='Users']")
	WebElement usersMenu;

	@FindBy(xpath = "//span[normalize-space()='Onboarding']")
	WebElement onboardingMenu;

	@FindBy(xpath = "//span[normalize-space()='Client']")
	WebElement clientOnboardingMenu;

	public void navigateToUsersPage() {

		usersMenu.click();
	}

	public AdminDashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
