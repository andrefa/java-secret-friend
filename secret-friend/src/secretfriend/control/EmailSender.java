package secretfriend.control;

import java.util.List;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.mail.HtmlEmail;

import secretfriend.model.Email;
import secretfriend.model.Property;

/**
 * @author andre.almeida
 * 
 */
public class EmailSender {

	/** Instância única */
	private static EmailSender instance;

	/**
	 * @return instance
	 */
	public static EmailSender instance() {
		if (instance == null) {
			instance = new EmailSender();
		}
		return instance;
	}

	/** Nome do host de email */
	private static final String HOST_NAME = "smtp.gmail.com";
	/** Usuário do email */
	private static final String USER_AUTH = "sorteio.amigo.secreto.familia@gmail.com";
	/** Senha do email */
	private static final String PASS_AUTH = "Uytd7BqTPacPMh2SwunTUEUh3fdBULZWrfNNfEnURZ7RjGHkf5sgQhgGSGeGhS8EEEw27cEmkkqrPKt57dDvScgKzztzU6pjKGPbaKmZBL557PkANaDd2TqTVxBhXd3SsBmkkrWEUcnfrujN8mbfaSgP5pSazs7HRqxZXA5SnDr5MLGA4NRgpMSNSM42m9Yg";
	/** Nome do email */
	private static final String NAME = "O Sorteador";

	/**
	 * 
	 */
	private EmailSender() {
	}

	/**
	 * @param emails
	 * @throws Exception exception
	 */
	public void sendEmails(List<Email> emails) throws Exception {
		try {
			for (Email email : emails) {
				sendEmailWithImage(email);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * @param email
	 * @throws Exception exception
	 */
	public void sendEmail(Email email) throws Exception {
		HtmlEmail simpleEmail = new HtmlEmail();
		try {
			simpleEmail.setHostName(HOST_NAME);
			simpleEmail.setAuthentication(USER_AUTH, PASS_AUTH);
			simpleEmail.setSSL(true);
			simpleEmail.setFrom(USER_AUTH, NAME);

			// Em modo de desenvolvimento envia apenas para o email especificado nas propriedades
			if (Property.isDeveloperModeOn()) {
				simpleEmail.addTo(Property.getDeveloperEmail());
			} else {
				simpleEmail.addTo(email.getTo().getEmail());
			}
			simpleEmail.setSubject(email.getSubject());
			simpleEmail.setHtmlMsg(email.getFormattedEmail());

			simpleEmail.setDebug(true);
			simpleEmail.send();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * @param email
	 * @throws Exception exception
	 */
	public void sendEmailWithImage(Email email) throws Exception {
		HtmlEmail simpleEmail = new HtmlEmail();
		try {

			MimeMultipart multipart = new MimeMultipart();

			BodyPart bodyPartHtml = new MimeBodyPart();
			bodyPartHtml.setContent(email.getFormattedEmail(), "text/html");
			multipart.addBodyPart(bodyPartHtml);

			BodyPart bodyPartImage = new MimeBodyPart();
			DataSource ds = new FileDataSource("amigo-secreto-ideias.gif");
			bodyPartImage.setDataHandler(new DataHandler(ds));
			bodyPartImage.setHeader("Content-ID", "<background-image>");

			multipart.addBodyPart(bodyPartImage);

			simpleEmail.setHostName(HOST_NAME);
			simpleEmail.setAuthentication(USER_AUTH, PASS_AUTH);
			simpleEmail.setSSL(true);
			simpleEmail.setFrom(USER_AUTH, NAME);

			// Em modo de desenvolvimento envia apenas para o email especificado nas propriedades
			if (Property.isDeveloperModeOn()) {
				simpleEmail.addTo(Property.getDeveloperEmail());
			} else {
				simpleEmail.addTo(email.getTo().getEmail());
			}

			simpleEmail.setSubject(email.getSubject());
			simpleEmail.addPart(multipart);

			simpleEmail.send();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}