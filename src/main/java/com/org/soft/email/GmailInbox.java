/**
 * 
 */
package com.org.soft.email;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

public class GmailInbox {

	public static void check(String host, String storeType, String user,
		      String password) 
		   {
		      try {

		      //create properties field
		      Properties properties = new Properties();

		      properties.put("mail.pop3.host", host);
		      properties.put("mail.pop3.port", "995");
		      properties.put("mail.pop3.starttls.enable", "true");
		      
		      /**
		       * 	Session emailSession = Session.getInstance(props, new javax.mail.Authenticator() {
    				protected PasswordAuthentication getPasswordAuthentication() {
        			return new PasswordAuthentication(userName, password);
    }
});
		       */
		      Session emailSession = Session.getDefaultInstance(properties);
		  
		      //create the POP3 store object and connect with the pop server
		      Store store = emailSession.getStore("pop3s");

		      store.connect(host, user, password);

		      //create the folder object and open it
		      Folder emailFolder = store.getFolder("INBOX");
		      emailFolder.open(Folder.READ_ONLY);

		      // retrieve the messages from the folder in an array and print it
		      Message[] messages = emailFolder.getMessages();
		      System.out.println("messages.length---" + messages.length);

		      for (int i = 0, n = messages.length; i < n; i++) {
		         Message message = messages[i];
		         System.out.println("---------------------------------");
		         System.out.println("Email Number " + (i + 1));
		         System.out.println("Subject: " + message.getSubject());
		         System.out.println("From: " + message.getFrom()[0]);
		         System.out.println("Text: " + message.getContent().toString());
		         Multipart multipart = (Multipart) message.getContent();
		         for(int j = 0; j<multipart.getCount(); j++ ){
		        	 BodyPart bodyPart = multipart.getBodyPart(j);
		        	 String disPosition = bodyPart.getDisposition();
		        	 
		        	 if(disPosition != null && disPosition.equalsIgnoreCase("ATTACHMENT")){
		        		 System.out.println("Mail have some attachment");
		        		 
		        		 DataHandler handler = bodyPart.getDataHandler();
		        		 System.out.println("File Name : " + handler.getName());
		        	 }else{
		        		 System.out.println("Body1 :"+bodyPart.getContent());
		        		 String content = bodyPart.getContent().toString();
		        		 System.out.println("Content1 : "+ content);
		        	 }
		         }
		         //System.out.println("Text: " + message.getContent().toString());

		      }

		      //close the store and folder objects
		      emailFolder.close(false);
		      store.close();

		      } catch (NoSuchProviderException e) {
		         e.printStackTrace();
		      } catch (MessagingException e) {
		         e.printStackTrace();
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		   }

		   public static void main(String[] args) {

		      String host = "pop.gmail.com";// change accordingly
		      String mailStoreType = "pop3";
		      String username = "gowri.jtjjtj@gmail.com";// change accordingly
		      String password = "appaappa";// change accordingly

		      check(host, mailStoreType, username, password);

		   }

		}