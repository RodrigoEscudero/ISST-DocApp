package util;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailHandler {

	private Properties props = new Properties();
	private static EmailHandler instance;
	public EmailHandler() {
		String host="localhost";
		props.put("mail.smtp.host",host);
		props.put("mail.smtp.port","2500");
	}

	public void sendEmail(String from, String to, String subject, String body) {
		System.out.println(props);
		Session session = Session.getDefaultInstance(props,null);
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
			message.setSubject(subject);
			message.setText(body);
			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
