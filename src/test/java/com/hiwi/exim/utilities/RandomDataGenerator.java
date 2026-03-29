package com.hiwi.exim.utilities;

import java.util.Random;

public class RandomDataGenerator {

	private static final Random RANDOM = new Random();
	private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz";

	// Random string (1–7 characters)
	public static String randomString() {
		int length = RANDOM.nextInt(7) + 1;
		return RANDOM.ints(length, 0, CHARACTERS.length()).mapToObj(i -> String.valueOf(CHARACTERS.charAt(i)))
				.reduce("", String::concat);
	}

	public static String firstName() {
		String[] names = { "Amit", "Rahul", "Arjun", "Rohit", "Vikas", "Neha", "Priya", "Sneha", "Kiran", "Anita",
				"Swapnil", "Paresh" };
		return names[RANDOM.nextInt(names.length)];
	}

	public static String lastName() {
		String[] names = { "Sharma", "Patel", "Gupta", "Verma", "Nair", "Kapoor", "Joshi", "Reddy", "Pal", "Jain",
				"Yadav" };
		return names[RANDOM.nextInt(names.length)];
	}

	public static String email(String firstName) {
		int randomNumber = 10000 + RANDOM.nextInt(90000);
		return firstName.toLowerCase() + randomNumber + "@automation.com";
	}

	public static String indianMobile() {

		int[] startDigits = { 7, 8, 9 };

		StringBuilder mobile = new StringBuilder();
		mobile.append(startDigits[RANDOM.nextInt(startDigits.length)]);

		for (int i = 0; i < 9; i++) {
			mobile.append(RANDOM.nextInt(10));
		}

		return mobile.toString();
	}

	public static String businessLegalName() {
		return randomString() + " Business";
	}

	public static String addressLine1() {
		String[] names = { "C 2 Wagle Industrial Estate", "Electronic Complex", "Kota-Jaipur National Highway No.12",
				"Bongaon Jhowdanga", "Bus Stand Rd", "Sector 17", "Mangal Complex", "Mumbai-Delhi highway", "Goa highway", "Naman Mid town" };
		return names[RANDOM.nextInt(names.length)];
	}

	public static String addressLine2() {
		String[] names = { "Padwal Nagar", "Indraprastha Industrial Area", "Near Baroni (21km away from Baroni)",
				"Panchpota Rd", "Budhwar peth", "Vashi" };
		return names[RANDOM.nextInt(names.length)];
	}

	public static String city() {
		String[] names = { "Thane", "Kota", "Shiwar", "Shashadanga", "Karad", "Navi Mumbai" };
		return names[RANDOM.nextInt(names.length)];
	}

	public static String state() {
		String[] names = { "Maharashtra", "Rajasthan", "West Bengal", "Karnataka", "Goa" };
		return names[RANDOM.nextInt(names.length)];
	}

	public static String zip() {
		String[] names = { "400604", "324005", "322704", "743273", "415110", "487725", "772541", "455289" };
		return names[RANDOM.nextInt(names.length)];
	}

	public static String website() {
		String[] names = { "www.example.com", "www.testbusiness.in", "www.mycompany.org", "www.randomshop.net",
				"www.demoenterprise.co", "www.fakesite.biz" };
		return names[RANDOM.nextInt(names.length)];
	}

	public static String monthlyShipment() {
		String[] names = { "3", "4", "2", "8", "7", "9", "1", "5", "6", };
		return names[RANDOM.nextInt(names.length)];
	}

	public static String monthlyVolume() {
		String[] names = { "1000", "2000", "3000", "4000", "5000", "6000" };
		return names[RANDOM.nextInt(names.length)];
	}

	public static String businessDescription() {
		String[] names = { "We specialize in providing high‑quality textile exports to international markets.",
				"A growing e‑commerce platform delivering electronics and household goods across India.",
				"Manufacturer of eco‑friendly packaging solutions for food and beverage companies.",
				"Local logistics provider offering reliable shipment services for small businesses.",
				"Startup focused on digital marketing and social media strategy for SMEs.",
				"Supplier of automotive spare parts with nationwide distribution network.",
				"Retail chain offering affordable fashion and lifestyle products." };
		return names[RANDOM.nextInt(names.length)];
	}
}