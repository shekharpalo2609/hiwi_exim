package com.hiwi.exim.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.hiwi.exim.pages.admin.AdminUsersPage;

public class AdminFlows {
	
	public static String addGoodsExporter(WebDriver driver, AdminUsersPage usersPage) throws InterruptedException {
        String firstName = RandomDataGenerator.firstName();
        String lastName = RandomDataGenerator.lastName();
        String email = RandomDataGenerator.email(firstName);
        String mobile = RandomDataGenerator.indianMobile();

        usersPage.addClientAdminUser(firstName, lastName, email, mobile);

        String toastText = usersPage.waitForUserAddedToastMessage(driver);
        Assert.assertTrue(toastText.contains("successfully"), "Toast message not displayed!");
        Thread.sleep(1000);
        usersPage.searchAddedUser(email);
        return email;
    }
}
