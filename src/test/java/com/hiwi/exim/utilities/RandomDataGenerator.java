package com.hiwi.exim.utilities;

import java.util.Random;

public class RandomDataGenerator {

    private static final Random RANDOM = new Random();
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz";

    // Random string (1–7 characters)
    public static String randomString() {
        int length = RANDOM.nextInt(7) + 1;
        return RANDOM.ints(length, 0, CHARACTERS.length())
                .mapToObj(i -> String.valueOf(CHARACTERS.charAt(i)))
                .reduce("", String::concat);
    }

    public static String firstName() {
        String[] names = {"Amit","Rahul","Arjun","Rohit","Vikas","Neha","Priya","Sneha","Kiran","Anita"};
        return names[RANDOM.nextInt(names.length)];
    }

    public static String lastName() {
        String[] names = {"Sharma","Patel","Gupta","Verma","Nair","Kapoor","Joshi","Reddy"};
        return names[RANDOM.nextInt(names.length)];
    }

    public static String email(String firstName) {
    	int randomNumber = 1000 + RANDOM.nextInt(9000); 
        return firstName.toLowerCase() + randomNumber + "@automation.com";
    }

    public static String indianMobile() {

        int[] startDigits = {7,8,9};

        StringBuilder mobile = new StringBuilder();
        mobile.append(startDigits[RANDOM.nextInt(startDigits.length)]);

        for(int i=0;i<9;i++){
            mobile.append(RANDOM.nextInt(10));
        }

        return mobile.toString();
    }

    public static String company() {
        return "Automation" + randomString();
    }
}