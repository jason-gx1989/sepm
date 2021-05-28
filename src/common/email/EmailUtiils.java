package common.email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtiils {

//	public static void main(String[] args) {
//
//		EmailUtiils.sendEmail("xxxx@qq.com", "this is the head ! ", "this is the content!");
//
//	}

	private final static String FROM = "2529787379@qq.com";		// receiver address
	private final static String HOST_KEY = "mail.smtp.host";
	private final static String HOST = "smtp.qq.com";			// email server
	private final static String TOKEN = "ebkugqfsaeafebdi";
	private final static String AUTH = "mail.smtp.auth";
	private final static String AUTH_VALUE = "true";
	private final static String SUECCESS_LOG = " >>> Sent message successfully.";

	public static void sendEmail(String address, String head, String content) {

		Properties properties = System.getProperties();

		// configure email server
		properties.setProperty(HOST_KEY, HOST);
		properties.put(AUTH, AUTH_VALUE);
		
		// Get default session object
		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(FROM, TOKEN);
			}
		});

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(FROM));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(address));
			message.setSubject(head);
			message.setText(content);
			Transport.send(message);
			System.out.println(SUECCESS_LOG);
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
