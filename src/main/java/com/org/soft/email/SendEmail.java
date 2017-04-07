package com.org.soft.email;
/**
 * Compose and To Send hidden files to mail
 */
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;

public class SendEmail
{
	public static void main(String[] args) throws ServletException, IOException {
		
		/**
		 * Purpose : Insert the records based on the 
		 */
		
		
		
		/**
		 * Purpose: Mailing Properties
		 */
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("gowri.jtjjtj@gmail.com","appaappa");
				}
			});
		
		try {
			
			/**
			 * Purpose : Add multiple recipients for the sending mail
			 */
			
			String toList = "gowri.jtj@gmail.com,gs8227@gmail.com";
			String to[] = toList.split(",");
			InternetAddress[] addresses = new InternetAddress[to.length];
			for(int n = 0 ; n < to.length ; n++)
				addresses[n] = new InternetAddress(to[n]);

			Message message = new MimeMessage(session);

			/**
			 * Purpose : Send Single recipients 
			 */
			//message.setRecipients(Message.RecipientType.TO , InternetAddress.parse("gs8227@gmail.com"));
			
			
			/**
			 * Purpoes :Send multiple recipients 
			 */
			message.setRecipients(Message.RecipientType.TO, addresses);
			message.setFrom(new InternetAddress("gowri.jtjjtj@gmail.com"));
			message.setSubject("Snow Storm Alert");
			message.setContent("Snow Storm Coming. Please take necessary precaution.", "text/html");
			Transport.send(message);

			System.out.println("Mail Sent Successfully.");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}