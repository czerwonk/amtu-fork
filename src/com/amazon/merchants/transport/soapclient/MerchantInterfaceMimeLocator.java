/**
 * MerchantInterfaceMimeLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.amazon.merchants.transport.soapclient;

public class MerchantInterfaceMimeLocator extends org.apache.axis.client.Service implements com.amazon.merchants.transport.soapclient.MerchantInterfaceMime {

    // Use to get a proxy class for MerchantInterface
    private final java.lang.String MerchantInterface_address = "http://exn-stage-102:2424/gateway/merchant-interface-mime/";

    public java.lang.String getMerchantInterfaceAddress() {
        return MerchantInterface_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String MerchantInterfaceWSDDServiceName = "MerchantInterface";

    public java.lang.String getMerchantInterfaceWSDDServiceName() {
        return MerchantInterfaceWSDDServiceName;
    }

    public void setMerchantInterfaceWSDDServiceName(java.lang.String name) {
        MerchantInterfaceWSDDServiceName = name;
    }

    public com.amazon.merchants.transport.soapclient.MerchantInterface getMerchantInterface() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(MerchantInterface_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMerchantInterface(endpoint);
    }

    public com.amazon.merchants.transport.soapclient.MerchantInterface getMerchantInterface(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.amazon.merchants.transport.soapclient.MerchantInterfaceStub _stub = new com.amazon.merchants.transport.soapclient.MerchantInterfaceStub(portAddress, this);
            _stub.setPortName(getMerchantInterfaceWSDDServiceName());
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
            if (com.amazon.merchants.transport.soapclient.MerchantInterface.class.isAssignableFrom(serviceEndpointInterface)) {
                com.amazon.merchants.transport.soapclient.MerchantInterfaceStub _stub = new com.amazon.merchants.transport.soapclient.MerchantInterfaceStub(new java.net.URL(MerchantInterface_address), this);
                _stub.setPortName(getMerchantInterfaceWSDDServiceName());
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
        if ("MerchantInterface".equals(inputPortName)) {
            return getMerchantInterface();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.amazon.com/merchants/merchant-interface/", "merchant-interface-mime");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("MerchantInterface"));
        }
        return ports.iterator();
    }

}
