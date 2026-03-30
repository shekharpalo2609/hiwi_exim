package com.hiwi.exim.tests;

import org.testng.annotations.Test;

import com.hiwi.exim.pages.admin.AdminDashboardPage;
import com.hiwi.exim.pages.admin.AdminUsersPage;
import com.hiwi.exim.utils.AdminFlows;

public class AdminAddUser extends com.hiwi.exim.base.Base {

	@Test
	public void addGoodsExporter() throws InterruptedException {

		AdminDashboardPage dashboardPage = new AdminDashboardPage(driver);
		dashboardPage.navigateToUsersScreen();

		AdminUsersPage usersPage = new AdminUsersPage(driver);

		AdminFlows.addGoodsExporter(driver, usersPage);
		System.out.println("User added");
	}

}