package com.amazon.merchants.timer;

import javax.management.*;


public class NotificationFilter implements NotificationListener
{
	private NotificationListener filtered;
	private String typeToLetThrough;
	
	public NotificationFilter(NotificationListener filtered, String typeToLetThrough)
	{
		this.filtered = filtered;
		this.typeToLetThrough = typeToLetThrough;
	}
	
	public void handleNotification(Notification notification, Object userData)
	{
		if (notification.getType().equals(typeToLetThrough)) {
			filtered.handleNotification(notification, userData);
		}
	}

}
