/**
 * MerchantInterface_getDocumentInterfaceConformance_orgIdooxWaspSoapFaultException_Fault.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.amazon.merchants.transport.soapclient;

public class MerchantInterface_getDocumentInterfaceConformance_orgIdooxWaspSoapFaultException_Fault extends org.apache.axis.AxisFault {
    public java.lang.String idooxJavaMappingOrgIdooxWaspSoapFaultException;
    public java.lang.String getIdooxJavaMappingOrgIdooxWaspSoapFaultException() {
        return this.idooxJavaMappingOrgIdooxWaspSoapFaultException;
    }

    public MerchantInterface_getDocumentInterfaceConformance_orgIdooxWaspSoapFaultException_Fault() {
    }

      public MerchantInterface_getDocumentInterfaceConformance_orgIdooxWaspSoapFaultException_Fault(java.lang.String idooxJavaMappingOrgIdooxWaspSoapFaultException) {
        this.idooxJavaMappingOrgIdooxWaspSoapFaultException = idooxJavaMappingOrgIdooxWaspSoapFaultException;
    }

    /**
     * Writes the exception data to the faultDetails
     */
    public void writeDetails(javax.xml.namespace.QName qname, org.apache.axis.encoding.SerializationContext context) throws java.io.IOException {
        context.serialize(qname, null, idooxJavaMappingOrgIdooxWaspSoapFaultException);
    }
}
