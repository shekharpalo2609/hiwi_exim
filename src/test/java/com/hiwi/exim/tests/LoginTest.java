package com.hiwi.exim.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hiwi.exim.base.Base;
import com.hiwi.exim.pages.admin.AdminLoginPage;
import com.hiwi.exim.utils.ConfigReader;

@Listeners(com.hiwi.exim.listeners.TestListener.class)
public class LoginTest extends Base {

	@Test(enabled = true)
	public void adminLogin() {

		driver.get(ConfigReader.getAdminSigninUrl());
		System.out.println("launched");
		AdminLoginPage login = new AdminLoginPage(driver);
		login.adminLogin(ConfigReader.getProperty("admin.email"), ConfigReader.getProperty("otp1"),
				ConfigReader.getProperty("otp2"), ConfigReader.getProperty("otp3"), ConfigReader.getProperty("otp4"));
	}
}
