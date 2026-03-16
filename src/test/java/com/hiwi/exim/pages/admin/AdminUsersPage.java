package com.hiwi.exim.pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminUsersPage {

	WebDriver driver;
	
	@FindBy(xpath =  "//span[normalize-space()='Add User']")
	WebElement addUserButton;
	
	@FindBy(id =  "first-name")
	WebElement firstName;
	
	
	@FindBy(id =  "last-name")
	WebElement lastName;
	
	@FindBy(id =  "email")
	WebElement email;
	
	@FindBy(id =  "mobile")
	WebElement mobile;
	
	
	@FindBy(xpath =  "//mat-label[normalize-space()='Role']")
	WebElement role;
	
	@FindBy(xpath =  "//mat-option[@ng-reflect-value='CAdmin']")
	WebElement clientAdminRole;
	
	@FindBy(xpath =  "//button[normalize-space()='Save']")
	WebElement saveButton;
	
	@FindBy(css = "input[placeholder='Search']")
	WebElement searchUserTextField;
	
	
	public void addClientAdminUser(String firstName, String lastName, String email, String mobile) {
		
		addUserButton.click();
		this.firstName.sendKeys(firstName);
		this.lastName.sendKeys(lastName);
		this.email.sendKeys(email);
		this.mobile.sendKeys(mobile);
		role.click();
		clientAdminRole.click();
		saveButton.click();
	}
	
	public void searchAddedUser(String email) {
		searchUserTextField.sendKeys(email);
	}
	
	 public AdminUsersPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	
}
