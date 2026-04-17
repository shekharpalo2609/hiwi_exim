package com.hiwi.exim.utils;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailReportSender {
	
	public static void sendReport(String filePath, String recipientEmail) throws AddressException, MessagingException, IOException {
		
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		
		
		Session session = Session.getInstance(properties, new Authenticator() {
			
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("clienttradetesting123@gmail.com", "Client@123");
			}
		});
		
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("clienttradetesting123@gmail.com"));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));		
		message.setSubject("Test Automation Report");
		
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setText("Hi, please find attached the latest automation test report !");
		
		MimeBodyPart attachment = new MimeBodyPart();
		attachment.attachFile(filePath);
		
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		multipart.addBodyPart(attachment);
		
		message.setContent(multipart);
		
		Transport.send(message);
		System.out.println("Email sent successfully to " + recipientEmail);
	}

}
