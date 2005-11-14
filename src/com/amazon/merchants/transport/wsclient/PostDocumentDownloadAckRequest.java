/**
 * PostDocumentDownloadAckRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.amazon.merchants.transport.wsclient;

public class PostDocumentDownloadAckRequest  implements java.io.Serializable {
    private com.amazon.merchants.transport.wsclient.Merchant merchant;
    private com.amazon.merchants.transport.wsclient.DocumentIDArray documentIdentifierArray;

    public PostDocumentDownloadAckRequest() {
    }

    public com.amazon.merchants.transport.wsclient.Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(com.amazon.merchants.transport.wsclient.Merchant merchant) {
        this.merchant = merchant;
    }

    public com.amazon.merchants.transport.wsclient.DocumentIDArray getDocumentIdentifierArray() {
        return documentIdentifierArray;
    }

    public void setDocumentIdentifierArray(com.amazon.merchants.transport.wsclient.DocumentIDArray documentIdentifierArray) {
        this.documentIdentifierArray = documentIdentifierArray;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PostDocumentDownloadAckRequest)) return false;
        PostDocumentDownloadAckRequest other = (PostDocumentDownloadAckRequest) obj;
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
            ((this.documentIdentifierArray==null && other.getDocumentIdentifierArray()==null) || 
             (this.documentIdentifierArray!=null &&
              this.documentIdentifierArray.equals(other.getDocumentIdentifierArray())));
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
        if (getDocumentIdentifierArray() != null) {
            _hashCode += getDocumentIdentifierArray().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PostDocumentDownloadAckRequest.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "postDocumentDownloadAckRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("merchant");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "merchant"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "Merchant"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentIdentifierArray");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "documentIdentifierArray"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "DocumentIDArray"));
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
