package com.amazon.merchants.timer;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.management.ReflectionException;

public class TimerService
{
	private ObjectName timerObjName;
	private MBeanServer mbeanServer;
	private static TimerService _instance;

	private TimerService()
	{}

	public static TimerService instance(MBeanServer mbs) throws MalformedObjectNameException, InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException, ReflectionException, MBeanException
	{
		if (_instance == null)
		{
			_instance = new TimerService();
			_instance.selfRegister(mbs);
		}
		return _instance;
	}

	public static TimerService instance()
	{
		if (_instance == null)
		{
			throw new IllegalArgumentException("Error. TimerService not initialized with MBeanServer.  Cannot invoke.");
		}
		return _instance;
	}

	public void start()
		throws InstanceNotFoundException, MBeanException, ReflectionException
	{
		mbeanServer.invoke(
			timerObjName,
			"start",
			new Object[] {},
			new String[] {});
	}

	public void stop()
		throws InstanceNotFoundException, MBeanException, ReflectionException
	{
		mbeanServer.invoke(
			timerObjName,
			"stop",
			new Object[] {},
			new String[] {});
	}
	
	public ObjectName timerName()
	{
		return this.timerObjName;
	}

	private void selfRegister(MBeanServer mbs)
		throws
			MalformedObjectNameException,
			InstanceAlreadyExistsException,
			MBeanRegistrationException,
			NotCompliantMBeanException,
			ReflectionException,
			MBeanException
	{
		this.mbeanServer = mbs;
		this.timerObjName = new ObjectName("testing:id=amazonTimerService");
		mbs.createMBean("javax.management.timer.Timer", timerObjName);
	}
}
