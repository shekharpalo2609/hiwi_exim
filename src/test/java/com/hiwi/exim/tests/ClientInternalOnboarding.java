package com.hiwi.exim.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hiwi.exim.base.Base;
import com.hiwi.exim.pages.admin.AdminDashboardPage;
import com.hiwi.exim.pages.admin.AdminUsersPage;
import com.hiwi.exim.pages.admin.ClientOnboardingPage;
import com.hiwi.exim.pages.common.PersonalDetailsPage;
import com.hiwi.exim.utilities.AdminFlows;

public class ClientInternalOnboarding extends Base {

	@Test
	public void goodsExporterOnboarding() throws InterruptedException {

		AdminDashboardPage dashboardPage = new AdminDashboardPage(driver);
		dashboardPage.navigateToUsersScreen();

		AdminUsersPage usersPage = new AdminUsersPage(driver);

		String generatedEmail = AdminFlows.addGoodsExporter(driver, usersPage);

		dashboardPage.navigateToClientOnboardingScreen();
		ClientOnboardingPage onboardingPage = new ClientOnboardingPage(driver);
		onboardingPage.searchClientEmail(generatedEmail);
		onboardingPage.startOnboarding();
		
		PersonalDetailsPage personalDetail = new PersonalDetailsPage(driver);
		Assert.assertEquals(personalDetail.verifyPersonalDetailsLabel(), "Personal Details");
		personalDetail.clickNextPersonalDetails();
	}

}