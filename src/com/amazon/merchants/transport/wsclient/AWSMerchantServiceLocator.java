/**
 * AWSMerchantServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.amazon.merchants.transport.wsclient;

public class AWSMerchantServiceLocator extends org.apache.axis.client.Service implements com.amazon.merchants.transport.wsclient.AWSMerchantService {

    // Use to get a proxy class for AWSMerchantServicePort
    private final java.lang.String AWSMerchantServicePort_address = "http://merchant-beta.amazon.com/onca/soap?Service=AWSMerchantService";

    public java.lang.String getAWSMerchantServicePortAddress() {
        return AWSMerchantServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AWSMerchantServicePortWSDDServiceName = "AWSMerchantServicePort";

    public java.lang.String getAWSMerchantServicePortWSDDServiceName() {
        return AWSMerchantServicePortWSDDServiceName;
    }

    public void setAWSMerchantServicePortWSDDServiceName(java.lang.String name) {
        AWSMerchantServicePortWSDDServiceName = name;
    }

    public com.amazon.merchants.transport.wsclient.AWSMerchantServicePortType getAWSMerchantServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AWSMerchantServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAWSMerchantServicePort(endpoint);
    }

    public com.amazon.merchants.transport.wsclient.AWSMerchantServicePortType getAWSMerchantServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.amazon.merchants.transport.wsclient.AWSMerchantServiceBindingStub _stub = new com.amazon.merchants.transport.wsclient.AWSMerchantServiceBindingStub(portAddress, this);
            _stub.setPortName(getAWSMerchantServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.amazon.merchants.transport.wsclient.AWSMerchantServicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.amazon.merchants.transport.wsclient.AWSMerchantServiceBindingStub _stub = new com.amazon.merchants.transport.wsclient.AWSMerchantServiceBindingStub(new java.net.URL(AWSMerchantServicePort_address), this);
                _stub.setPortName(getAWSMerchantServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        String inputPortName = portName.getLocalPart();
        if ("AWSMerchantServicePort".equals(inputPortName)) {
            return getAWSMerchantServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "AWSMerchantService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("AWSMerchantServicePort"));
        }
        return ports.iterator();
    }

}
