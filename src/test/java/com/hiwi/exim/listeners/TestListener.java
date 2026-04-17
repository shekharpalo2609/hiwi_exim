package com.hiwi.exim.listeners;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.hiwi.exim.utils.DriverManager;

import io.qameta.allure.Allure;

public class TestListener implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver = DriverManager.getDriver();
		if (driver != null) {
			TakesScreenshot sc = (TakesScreenshot) driver;
			File file = sc.getScreenshotAs(OutputType.FILE);
			String testName = result.getName();
			String timeStamp = new java.text.SimpleDateFormat("ddMMyyyy_HHmmss").format(new java.util.Date());
			String destPath = "target/screenshots/failed/" + testName + "_" + timeStamp + ".png";

			try {
				Files.createDirectories(Paths.get("target/screenshots/failed"));
				Files.copy(file.toPath(), Paths.get(destPath));
				System.out.println("Screenshot saved at: " + destPath);
			} catch (IOException e) {
				e.printStackTrace();
			}

			// Attach screenshot to Allure report
			byte[] screenshotBytes = sc.getScreenshotAs(OutputType.BYTES);

			Allure.addAttachment("Failure Screenshot - " + testName, new ByteArrayInputStream(screenshotBytes));
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		WebDriver driver = DriverManager.getDriver();
		if (driver != null) {
			TakesScreenshot sc = (TakesScreenshot) driver;
			File file = sc.getScreenshotAs(OutputType.FILE);
			String testName = result.getName();
			String timeStamp = new java.text.SimpleDateFormat("ddMMyyyy_HHmmss").format(new java.util.Date());
			String destPath = "target/screenshots/pass/" + testName + "_" + timeStamp + ".png";

			try {
				Files.createDirectories(Paths.get("target/screenshots/pass"));
				Files.copy(file.toPath(), Paths.get(destPath));
				System.out.println("Screenshot saved at: " + destPath);
			} catch (IOException e) {
				e.printStackTrace();
			}
			// Attach screenshot to Allure report 
			byte[] screenshotBytes = sc.getScreenshotAs(OutputType.BYTES);

			Allure.addAttachment("Failure Screenshot - " + testName, new ByteArrayInputStream(screenshotBytes));
		}
	}
}