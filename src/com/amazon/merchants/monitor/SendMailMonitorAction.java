package com.amazon.merchants.monitor;

import javax.mail.MessagingException;

import org.apache.commons.lang.Validate;
import org.apache.commons.logging.*;

import com.amazon.merchants.mail.SMTPMailer;

public class SendMailMonitorAction extends MonitorAction
{
	private String fromAddress;
	private String toAddress;
	private SMTPMailer mailer;

	private static final String IS_ALIVE_MESSAGE = "Amazon Merchant Transport Tool Service Is Running";
	private static final String IS_DEAD_MESSAGE = "Amazon Merchant Transport Tool Service Has Stopped";
	private static final Log log =
		LogFactory.getLog(SendMailMonitorAction.class);

	public SendMailMonitorAction(
		String smtpServer,
		String fromAddress,
		String toAddress)
	{
		Validate.notEmpty(smtpServer);
		Validate.notEmpty(fromAddress);
		Validate.notEmpty(toAddress);
		
		this.mailer = new SMTPMailer(smtpServer);
		this.fromAddress = fromAddress;
		this.toAddress = toAddress;
	}

	protected void warnOnStateChange()
	{
		try
		{
			mailer.sendMail(
				fromAddress,
				toAddress,
				isAlive() ? IS_ALIVE_MESSAGE : IS_DEAD_MESSAGE,
				isAlive() ? IS_ALIVE_MESSAGE : IS_DEAD_MESSAGE);
		} catch (MessagingException e)
		{
			log.error("Error sending email to " + toAddress, e);
		}
	}

}
