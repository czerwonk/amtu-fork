/**
 * ArrayOfSummaryInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.amazon.merchants.transport.soapclient;

public class ArrayOfSummaryInfo  implements java.io.Serializable {
    private com.amazon.merchants.transport.soapclient.SummaryInfo[] summaryInfo;

    public ArrayOfSummaryInfo() {
    }

    public com.amazon.merchants.transport.soapclient.SummaryInfo[] getSummaryInfo() {
        return summaryInfo;
    }

    public void setSummaryInfo(com.amazon.merchants.transport.soapclient.SummaryInfo[] summaryInfo) {
        this.summaryInfo = summaryInfo;
    }

    public com.amazon.merchants.transport.soapclient.SummaryInfo getSummaryInfo(int i) {
        return summaryInfo[i];
    }

    public void setSummaryInfo(int i, com.amazon.merchants.transport.soapclient.SummaryInfo value) {
        this.summaryInfo[i] = value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArrayOfSummaryInfo)) return false;
        ArrayOfSummaryInfo other = (ArrayOfSummaryInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.summaryInfo==null && other.getSummaryInfo()==null) || 
             (this.summaryInfo!=null &&
              java.util.Arrays.equals(this.summaryInfo, other.getSummaryInfo())));
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
        if (getSummaryInfo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSummaryInfo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSummaryInfo(), i);
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
        new org.apache.axis.description.TypeDesc(ArrayOfSummaryInfo.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.amazon.com/merchants/merchant-interface/", "ArrayOfSummaryInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("summaryInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.amazon.com/merchants/merchant-interface/", "SummaryInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.amazon.com/merchants/merchant-interface/", "SummaryInfo"));
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
