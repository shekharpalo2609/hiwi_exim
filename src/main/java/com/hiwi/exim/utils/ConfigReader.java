package com.hiwi.exim.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

	private static Properties prop;

	static {
		try {
			InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties");

			prop = new Properties();
			prop.load(input);
		} catch (IOException e) {
			throw new RuntimeException("Failed to load config.properties file", e);
		}
	}

	public static String getProperty(String key) {
		return prop.getProperty(key);
	}

	 public static String getAdminSigninUrl() {

	        String env = prop.getProperty("env");

	        return prop.getProperty(env + ".adminSignin.url");
	    }
}
