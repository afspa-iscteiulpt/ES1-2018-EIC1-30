package email;

import java.io.IOException;
import java.sql.Date;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.SwingUtilities;

import com.sun.mail.smtp.SMTPTransport;

import gui.ReadEmailsGUI;
import gui.SendEmailGUI;

/**
 * This class allows one to read their emails and send emails to other adresses
 * 
 * @author Grupo 30 ES1 2018/19 ISCTE
 *
 */

public class GmailImap {
	/**
	 * Email_id and Password necessary to define the credentials to enter the email
	 * server.
	 */
	private static final String email_id = "es1.grupo30.2018.19@gmail.com";
	private static final String password = "Es1Grupo30!";

	/**
	 * Properties - used to define the properties to access the mail server
	 */
	private static Properties properties = new Properties();
	/**
	 * Session - used to start the session using the defined properties
	 */
	private static Session session = Session.getDefaultInstance(properties, null);

	/**
	 * Method that decodes the message of each email making it possible to be read in the console
	 * @return content.toString()
	 */
	public static String toString(Message message) throws MessagingException, IOException {
		Object content = message.getContent();
		if (content instanceof MimeMultipart) {
			MimeMultipart multipart = (MimeMultipart) content;
			if (multipart.getCount() > 0) {
				BodyPart part = multipart.getBodyPart(0);
				content = part.getContent();
			}
		}
		if (content != null) {
			return content.toString();
		}
		return null;
	}
	
	/**
	 * Method that defines the properties to access the mail server
	 */
	private static void setProperties() {
		// You can use imap or imaps , *s -Secured
		properties.put("mail.store.protocol", "imaps");
		// Host Address of Your Mail
		properties.put("mail.imaps.host", "imap.gmail.com");
		// Port number of your Mail Host
		properties.put("mail.imaps.port", "993");
	}
	
	/**
	 * The main method, firstly sets the server properties, then sends a test
	 * email and finally shows the last messages of the email.
	 * @param args
	 */
	
	/*public void readOrSend(String s) {
		if(s.equals("send")) {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					new SendEmailGUI();
				}
			});
		} else if(s.equals("read")) {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					new ReadEmailsGUI();
				}
			});
		}
	}*/
	public static void main(String[] args) {
		setProperties();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SendEmailGUI();
			}
		});
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ReadEmailsGUI();
			}
		});
		
		/*
		try {
			send_message("Ola sou o André", "es1.grupo30.2018.19@gmail.com", "Importante", "João");
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		messages_appear();
		*/
	}
	
	/**
	 * Method that sends a message to a destiny email, with an header and a subject (title_message)
	 * 
	 *@param message the message to be sent
	 *@param email_desteny the email destiny (address) that will be the receiver of the email
	 *@param header defines the type of message that will be sent
	 *@param title_message the subject of the email
	 */
	private static void send_message(String message, String email_destiny, String header, String title_message)
			throws MessagingException {
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(email_id));
		;
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email_destiny, false));
		msg.setSubject("Title " + title_message);
		msg.setText(message);
		msg.setHeader("Message type:", header);
		msg.setSentDate(new Date(0));
		SMTPTransport t = (SMTPTransport) session.getTransport("smtps");
		t.connect("smtp.gmail.com", email_id, password);
		t.sendMessage(msg, msg.getAllRecipients());
		t.close();
	}
	
	/**
	 * Method that sets the connection and prints the last 10 messages
	 * 
	 */
	private static void messages_appear() {
		try {
			// SET the store for IMAPS
			Store store = session.getStore("imaps");

			System.out.println("Connection initiated......");
			// Trying to connect IMAP server
			store.connect(email_id, password);
			System.out.println("Connection is ready :)");

			// Get inbox folder
			Folder inbox = store.getFolder("inbox");
			// SET readonly format (*You can set read and write)
			inbox.open(Folder.READ_ONLY);

			// Display email Details
			int messageCount = inbox.getMessageCount();

			// Inbox email count

			System.out.println("Total Messages in INBOX: " + messageCount);

			// Print Last 10 email information
			for (int i = 0; i < messageCount && i < 10; i++) {
				System.out.println("Mail Subject:- " + inbox.getMessage(messageCount - i).getSubject());
				System.out.println("Mail From:- " + inbox.getMessage(messageCount - i).getFrom()[0]);
				System.out.println("Mail Content:- " + toString(inbox.getMessage(messageCount - i)));
				System.out.println("------------------------------------------------------------");
			}

			inbox.close(true);
			store.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
