/**
 * ArrayOfDocumentDownloadAckStatus.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.amazon.merchants.transport.soapclient;

public class ArrayOfDocumentDownloadAckStatus  implements java.io.Serializable {
    private com.amazon.merchants.transport.soapclient.DocumentDownloadAckStatus[] documentDownloadAckStatus;

    public ArrayOfDocumentDownloadAckStatus() {
    }

    public com.amazon.merchants.transport.soapclient.DocumentDownloadAckStatus[] getDocumentDownloadAckStatus() {
        return documentDownloadAckStatus;
    }

    public void setDocumentDownloadAckStatus(com.amazon.merchants.transport.soapclient.DocumentDownloadAckStatus[] documentDownloadAckStatus) {
        this.documentDownloadAckStatus = documentDownloadAckStatus;
    }

    public com.amazon.merchants.transport.soapclient.DocumentDownloadAckStatus getDocumentDownloadAckStatus(int i) {
        return documentDownloadAckStatus[i];
    }

    public void setDocumentDownloadAckStatus(int i, com.amazon.merchants.transport.soapclient.DocumentDownloadAckStatus value) {
        this.documentDownloadAckStatus[i] = value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArrayOfDocumentDownloadAckStatus)) return false;
        ArrayOfDocumentDownloadAckStatus other = (ArrayOfDocumentDownloadAckStatus) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.documentDownloadAckStatus==null && other.getDocumentDownloadAckStatus()==null) || 
             (this.documentDownloadAckStatus!=null &&
              java.util.Arrays.equals(this.documentDownloadAckStatus, other.getDocumentDownloadAckStatus())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getDocumentDownloadAckStatus() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDocumentDownloadAckStatus());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDocumentDownloadAckStatus(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ArrayOfDocumentDownloadAckStatus.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.amazon.com/merchants/merchant-interface/", "ArrayOfDocumentDownloadAckStatus"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentDownloadAckStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.amazon.com/merchants/merchant-interface/", "DocumentDownloadAckStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.amazon.com/merchants/merchant-interface/", "DocumentDownloadAckStatus"));
        elemField.setMinOccurs(0);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
