package com.amazon.merchants.remote;

/**
 * Interfaces for an MBean whose only job is to be touched and to tell others when it's touched.
 * @author smarkle
 *
 */
public interface EmitterMBean {

    /**
     * Method to be called to notify listeners of an event.
     * @param the type of the notification to be sent to the listeners
     */
    public void touch(String type);
    
}
