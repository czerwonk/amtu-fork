package com.amazon.merchants.timer;

import javax.management.*;


public class NotifyTest implements NotificationListener
{

	public void handleNotification(Notification arg0, Object arg1)
	{
		System.out.println("Notified: " + arg0.getType());
	}

}
