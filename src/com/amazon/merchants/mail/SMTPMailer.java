package com.amazon.merchants.mail;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

import org.apache.commons.logging.*;


public class SMTPMailer
{
	private String smtpServer;
	private Session session;

	private static final String SMTP_SERVER_PROPERTY = "mail.smtp.host";
	private static final Log log = LogFactory.getLog(SMTPMailer.class);

	public SMTPMailer(String smtpServer)
	{
		this.smtpServer = smtpServer;
	}
	
	public void sendMail(
		String fromAddress,
		String toAddress,
		String subject,
		String messageText)
		throws MessagingException
	{
		MimeMessage message = new MimeMessage(session());
		message.setFrom(new InternetAddress(fromAddress));
		message.addRecipients(Message.RecipientType.TO, toAddress);
		message.setSubject(subject);

		message.setText(messageText);

		Transport.send(message);
	}

	private Session session()
	{
		if (session == null)
		{
			Properties sessionProperties = System.getProperties();
			if (!sessionProperties.containsKey(SMTP_SERVER_PROPERTY))
			{
				sessionProperties.setProperty(
					SMTP_SERVER_PROPERTY,
					this.smtpServer);
			}
			session = Session.getDefaultInstance(sessionProperties, null);
		}
		return session;
	}
}
