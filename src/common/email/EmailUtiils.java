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

	private final static String FROM = "2529787379@qq.com";// 配置好的发件人地址
	private final static String HOST_KEY = "mail.smtp.host";
	private final static String HOST = "smtp.qq.com";// QQ 邮件服务器
	private final static String TOKEN = "ebkugqfsaeafebdi";
	private final static String AUTH = "mail.smtp.auth";
	private final static String AUTH_VALUE = "true";
	private final static String SUECCESS_LOG = " >>> Sent message successfully.";

	public static void sendEmail(String address, String head, String content) {

		// 获取系统属性
		Properties properties = System.getProperties();

		// 设置邮件服务器
		properties.setProperty(HOST_KEY, HOST);
		properties.put(AUTH, AUTH_VALUE);
		// 获取默认session对象
		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(FROM, TOKEN);
			}
		});

		try {
			// 创建默认的 MimeMessage 对象
			MimeMessage message = new MimeMessage(session);

			// Set From: 头部头字段
			message.setFrom(new InternetAddress(FROM));

			// Set To: 头部头字段
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(address));

			// Set Subject: 头部头字段
			message.setSubject(head);

			// 设置消息体
			message.setText(content);

			// 发送消息
			Transport.send(message);
			System.out.println(SUECCESS_LOG);
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
