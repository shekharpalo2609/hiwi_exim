package com.hiwi.exim.tests;

import org.testng.annotations.Test;

import com.hiwi.exim.base.Base;
import com.hiwi.exim.pages.admin.AdminDashboardPage;
import com.hiwi.exim.pages.admin.AdminLoginPage;
import com.hiwi.exim.pages.admin.AdminUsersPage;
import com.hiwi.exim.utilities.ConfigReader;
import com.hiwi.exim.utilities.RandomDataGenerator;

public class AdminAddUser extends Base {

	@Test
	public void addGoodsExporter() throws InterruptedException {
		
		driver.get(ConfigReader.getAdminSigninUrl());
		AdminLoginPage login = new AdminLoginPage(driver);
        login.adminLogin(
                ConfigReader.getProperty("admin.email"),
                ConfigReader.getProperty("otp1"),
                ConfigReader.getProperty("otp2"),
                ConfigReader.getProperty("otp3"),
                ConfigReader.getProperty("otp4")
        );
        
        AdminDashboardPage dashboardPage = new AdminDashboardPage(driver);
		dashboardPage.navigateToUsersPage();
        
        
        AdminUsersPage usersPage = new AdminUsersPage(driver);
		
        String firstName = RandomDataGenerator.firstName();
        String lastName = RandomDataGenerator.lastName();
        String email = RandomDataGenerator.email(firstName);
        String mobile = RandomDataGenerator.indianMobile();
        
        usersPage.addClientAdminUser(firstName, lastName, email, mobile);
       // Thread.sleep(2000);
       // driver.navigate().refresh();
        //Thread.sleep(2000);
       // usersPage.searchAddedUser(email);
        System.out.println("User added");
	}
	
}	
