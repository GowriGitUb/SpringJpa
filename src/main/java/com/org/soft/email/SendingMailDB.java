package com.org.soft.email;
/**
 * Compose and To Send hidden files to mail
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;

public class SendingMailDB
{
	public static void main(String[] args) throws ServletException, IOException {
		
		/**
		 * Purpose : DB configuration
		 */
		JdbcConnection jdbcConnection = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = null;
	
		
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
			
			String from = "gowri.jtjtjt@gmail.com";
			String subject = "Snow Storm Alert";
			String content = "Snow Storm Coming. Please take necessary precaution.";
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
			message.setFrom(new InternetAddress(from));
			message.setSubject(subject);
			message.setContent(content, "text/html");
			Transport.send(message);

			System.out.println("Mail Sent Successfully.");
			
			connection = jdbcConnection.getConnection();
			/*sql = "INSERT INTO user(userid, userName, preferedLang, phoneNo, emailId, password, userCode, imagePath, "
					+ "createdby, createdOn, modifiedby, modifiedOn) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";*/
			Date date = new Date();
			sql = "INSERT INTO sendMail(formAddress , toAddress , subject , content , dateOfSend) values (?,?,?,?,?)";
			try {
				
				preparedStatement = connection.prepareStatement(sql);
				
				preparedStatement.setString(1, from);
				preparedStatement.setString(2, addresses.toString());
				preparedStatement.setString(3, subject);
				preparedStatement.setString(4, content);
				preparedStatement.setDate(5, (java.sql.Date) date);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}