/**
 * GetLastNReportInfoRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.amazon.merchants.transport.wsclient;

public class GetLastNReportInfoRequest  implements java.io.Serializable {
    private com.amazon.merchants.transport.wsclient.Merchant merchant;
    private java.lang.String messageType;
    private int numberOfReports;

    public GetLastNReportInfoRequest() {
    }

    public com.amazon.merchants.transport.wsclient.Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(com.amazon.merchants.transport.wsclient.Merchant merchant) {
        this.merchant = merchant;
    }

    public java.lang.String getMessageType() {
        return messageType;
    }

    public void setMessageType(java.lang.String messageType) {
        this.messageType = messageType;
    }

    public int getNumberOfReports() {
        return numberOfReports;
    }

    public void setNumberOfReports(int numberOfReports) {
        this.numberOfReports = numberOfReports;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetLastNReportInfoRequest)) return false;
        GetLastNReportInfoRequest other = (GetLastNReportInfoRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.merchant==null && other.getMerchant()==null) || 
             (this.merchant!=null &&
              this.merchant.equals(other.getMerchant()))) &&
            ((this.messageType==null && other.getMessageType()==null) || 
             (this.messageType!=null &&
              this.messageType.equals(other.getMessageType()))) &&
            this.numberOfReports == other.getNumberOfReports();
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
        if (getMerchant() != null) {
            _hashCode += getMerchant().hashCode();
        }
        if (getMessageType() != null) {
            _hashCode += getMessageType().hashCode();
        }
        _hashCode += getNumberOfReports();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetLastNReportInfoRequest.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "getLastNReportInfoRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("merchant");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "merchant"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "Merchant"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("messageType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "messageType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberOfReports");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "numberOfReports"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
