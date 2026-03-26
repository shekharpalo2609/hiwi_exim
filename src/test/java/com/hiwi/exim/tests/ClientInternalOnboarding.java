package com.hiwi.exim.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hiwi.exim.base.Base;
import com.hiwi.exim.pages.admin.AdminDashboardPage;
import com.hiwi.exim.pages.admin.AdminUsersPage;
import com.hiwi.exim.pages.admin.ClientOnboardingPage;
import com.hiwi.exim.pages.common.BusinessDetailsPage;
import com.hiwi.exim.pages.common.PersonalDetailsPage;
import com.hiwi.exim.utilities.AdminFlows;
import com.hiwi.exim.utilities.RandomDataGenerator;

public class ClientInternalOnboarding extends Base {

	@Test
	public void goodsExporterOnboarding() throws InterruptedException {

		AdminDashboardPage dashboardPage = new AdminDashboardPage(driver);
		dashboardPage.navigateToUsersScreen();

		AdminUsersPage usersPage = new AdminUsersPage(driver);

		String generatedEmail = AdminFlows.addGoodsExporter(driver, usersPage);
		String businessLegalName = RandomDataGenerator.businessLegalName();
		String addressLine1 = RandomDataGenerator.addressLine1();
		String addressLine2 = RandomDataGenerator.addressLine2();
		String city = RandomDataGenerator.city();
		String pincode = RandomDataGenerator.zip();
		String website = RandomDataGenerator.website();
		String shipment = RandomDataGenerator.monthlyShipment();
		String description = RandomDataGenerator.businessDescription();

		dashboardPage.navigateToClientOnboardingScreen();
		ClientOnboardingPage onboardingPage = new ClientOnboardingPage(driver);
		onboardingPage.searchClientEmail(generatedEmail);
		onboardingPage.startOnboarding();
		
		PersonalDetailsPage personalDetail = new PersonalDetailsPage(driver);
		Assert.assertEquals(personalDetail.verifyPersonalDetailsLabel(), "Personal Details");
		personalDetail.clickNextPersonalDetails();
		
		BusinessDetailsPage businessDetails = new BusinessDetailsPage(driver);
		businessDetails.enterBusinessLegalName(businessLegalName);
		businessDetails.selectMerchant();
		businessDetails.selectSoleProprietor();
		businessDetails.addressDetails(addressLine1, addressLine2, city, pincode);
		businessDetails.enterWebsite(website);
		businessDetails.selectIndustry();
		businessDetails.enterMonthlyVolume();
		businessDetails.enterTotalShipment(shipment);
		businessDetails.enterBusinessDescription(description);
		businessDetails.uploadGST();
		businessDetails.uploadIEC();
		businessDetails.uploadEFIRA();
		businessDetails.uploadInvoice();
		businessDetails.clickNext();
	}

}