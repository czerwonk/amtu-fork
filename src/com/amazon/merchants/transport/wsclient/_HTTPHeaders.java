/**
 * _HTTPHeaders.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.amazon.merchants.transport.wsclient;

public class _HTTPHeaders  implements java.io.Serializable {
    private com.amazon.merchants.transport.wsclient._HTTPHeaders_Header[] header;

    public _HTTPHeaders() {
    }

    public com.amazon.merchants.transport.wsclient._HTTPHeaders_Header[] getHeader() {
        return header;
    }

    public void setHeader(com.amazon.merchants.transport.wsclient._HTTPHeaders_Header[] header) {
        this.header = header;
    }

    public com.amazon.merchants.transport.wsclient._HTTPHeaders_Header getHeader(int i) {
        return header[i];
    }

    public void setHeader(int i, com.amazon.merchants.transport.wsclient._HTTPHeaders_Header value) {
        this.header[i] = value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof _HTTPHeaders)) return false;
        _HTTPHeaders other = (_HTTPHeaders) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.header==null && other.getHeader()==null) || 
             (this.header!=null &&
              java.util.Arrays.equals(this.header, other.getHeader())));
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
        if (getHeader() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getHeader());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getHeader(), i);
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
        new org.apache.axis.description.TypeDesc(_HTTPHeaders.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">HTTPHeaders"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("header");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "Header"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">HTTPHeaders>Header"));
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
