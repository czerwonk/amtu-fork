package com.amazon.merchants.monitor;

import java.util.*;
import java.util.Observer;

import org.apache.commons.logging.*;

public class MonitorAction implements Observer
{
	private static final Log log = LogFactory.getLog(MonitorAction.class);
	private boolean isAlive;
	private String name;
	
	/**
	 * Default constructor - sets name to "Monitored Object"
	 */
	public MonitorAction()
	{
		name = "Monitored Object";
	}
	
	public MonitorAction(String name)
	{
		this.name = name;
	}

	/**
	 * This method is called whenever the monitored object transitions
	 * state from alive to dead or back again.
	 * 
	 * @param monitor - HeartbeatMonitor this action is observing.
	 * @param isAlive - A Boolean that indicates current state of monitored object.
	 * 
	 */
	public void update(Observable monitor, Object isAlive)
	{
		this.isAlive = ((Boolean)isAlive).booleanValue();
		warnOnStateChange();
	}

	public boolean isAlive()
	{
		return isAlive;
	}

	/**
	 * Override this method to change the behavior of the action on
	 *  state change.  Called from update following setting of isAlive
	 *  to new value.
	 * 
	 * Default behavior is to log.warn the current state.
	 */
	protected void warnOnStateChange()
	{
		if (this.isAlive)
		{
			log.warn(name + " is alive");
		} else
		{
			log.warn(name + " is dead");
		}		
	}
	
}
