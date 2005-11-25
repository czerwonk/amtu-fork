package com.amazon.merchants.remote;

import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

/**
 * Connects via RMI to the MBean server listening for remote connections.
 * Sends a message to the Emitter MBean to perform the various actions listed.
 * @author smarkle
 *
 */
public class Client {

    public static void main(String argv[]) throws Throwable {
        // The address of the connector server
        String url = "service:jmx:rmi://localhost/jndi/rmi://localhost:1099/jmxconnector";
        JMXServiceURL address = new JMXServiceURL(url);

        // Create the JMXCconnectorServer
        JMXConnector cntor = JMXConnectorFactory.connect(address, null);

        // Obtain a "stub" for the remote MBeanServer
        MBeanServerConnection mbsc = cntor.getMBeanServerConnection();

        ObjectName delegateName = ObjectName.getInstance("testing:id=amazonEmitterService");
        Object proxy = MBeanServerInvocationHandler.newProxyInstance(mbsc, delegateName, EmitterMBean.class, true);
        
        EmitterMBean delegate = (EmitterMBean) proxy;
        
        // the foloowing strings have to match the values in TransportNotificationRegistry.
        // TODO investigate making those constants public somehow/somewhere.
        delegate.touch("dispatch.feeds");
        delegate.touch("order.reports");
        delegate.touch("processing.reports");
        delegate.touch("settlement.reports");
    }
    
}
