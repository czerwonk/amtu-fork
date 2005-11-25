package com.amazon.merchants.remote;

import java.io.IOException;

import javax.management.AttributeNotFoundException;
import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;

/**
 * This class exists to parallel the design of TimerService. This class is a
 * wrapper around an MBean whose job it is to be touched and to broadcast that
 * it has been touched. This MBean will be registered with the MBeanServer which
 * will be listening for remote contact. When this service is touched, it will
 * broadcast to all interested listeners that it has been touched.
 * 
 * @author smarkle
 * 
 */
public class EmitterService {
    private ObjectName objName;
    private MBeanServer mbeanServer;
    private static EmitterService _instance;

    private EmitterService()
    {}

    public static EmitterService instance(MBeanServer mbs)
            throws MalformedObjectNameException,
            InstanceAlreadyExistsException, MBeanRegistrationException,
            NotCompliantMBeanException, ReflectionException, MBeanException, 
            IOException, InstanceNotFoundException, AttributeNotFoundException
    {
        if (_instance == null)
        {
            _instance = new EmitterService();
            _instance.selfRegister(mbs);
        }
        return _instance;
    }

    public static EmitterService instance()
    {
        if (_instance == null)
        {
            throw new IllegalArgumentException("Error. EmitterService not initialized with MBeanServer.  Cannot invoke.");
        }
        return _instance;
    }

    public ObjectName objName()
    {
        return this.objName;
    }

    private void selfRegister(MBeanServer mbs)
        throws
            MalformedObjectNameException,
            InstanceAlreadyExistsException,
            MBeanRegistrationException,
            NotCompliantMBeanException,
            ReflectionException,
            MBeanException,
            InstanceNotFoundException,
            IOException,
            AttributeNotFoundException
    {
        this.mbeanServer = mbs;
        this.objName = new ObjectName("testing:id=amazonEmitterService");
        mbs.createMBean("com.amazon.merchants.remote.Emitter", objName);

        // Register and start the rmiregistry MBean, needed by JSR 160 RMIConnectorServer
        ObjectName namingName = ObjectName.getInstance("naming:type=rmiregistry");
        mbs.createMBean("mx4j.tools.naming.NamingService", namingName, null);
        mbs.invoke(namingName, "start", null, null);

        int namingPort = ((Integer) mbs.getAttribute(namingName, "Port")).intValue();
        String jndiPath = "/jmxconnector";
        String url = "service:jmx:rmi://localhost/jndi/rmi://localhost:" + namingPort + jndiPath;
        JMXServiceURL address = new JMXServiceURL(url);

        // Create and start the RMIConnectorServer
        JMXConnectorServer connectorServer = JMXConnectorServerFactory.newJMXConnectorServer(address, null, mbs);
        connectorServer.start();

    }

}
