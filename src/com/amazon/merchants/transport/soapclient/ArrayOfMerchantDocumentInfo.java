/**
 * ArrayOfMerchantDocumentInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.amazon.merchants.transport.soapclient;

public class ArrayOfMerchantDocumentInfo  implements java.io.Serializable {
    private com.amazon.merchants.transport.soapclient.MerchantDocumentInfo[] merchantDocumentInfo;

    public ArrayOfMerchantDocumentInfo() {
    }

    public com.amazon.merchants.transport.soapclient.MerchantDocumentInfo[] getMerchantDocumentInfo() {
        return merchantDocumentInfo;
    }

    public void setMerchantDocumentInfo(com.amazon.merchants.transport.soapclient.MerchantDocumentInfo[] merchantDocumentInfo) {
        this.merchantDocumentInfo = merchantDocumentInfo;
    }

    public com.amazon.merchants.transport.soapclient.MerchantDocumentInfo getMerchantDocumentInfo(int i) {
        return merchantDocumentInfo[i];
    }

    public void setMerchantDocumentInfo(int i, com.amazon.merchants.transport.soapclient.MerchantDocumentInfo value) {
        this.merchantDocumentInfo[i] = value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArrayOfMerchantDocumentInfo)) return false;
        ArrayOfMerchantDocumentInfo other = (ArrayOfMerchantDocumentInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.merchantDocumentInfo==null && other.getMerchantDocumentInfo()==null) || 
             (this.merchantDocumentInfo!=null &&
              java.util.Arrays.equals(this.merchantDocumentInfo, other.getMerchantDocumentInfo())));
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
        if (getMerchantDocumentInfo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMerchantDocumentInfo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMerchantDocumentInfo(), i);
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
        new org.apache.axis.description.TypeDesc(ArrayOfMerchantDocumentInfo.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.amazon.com/merchants/merchant-interface/", "ArrayOfMerchantDocumentInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("merchantDocumentInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.amazon.com/merchants/merchant-interface/", "MerchantDocumentInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.amazon.com/merchants/merchant-interface/", "MerchantDocumentInfo"));
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
