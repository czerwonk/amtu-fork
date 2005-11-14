/**
 * _Arguments.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.amazon.merchants.transport.wsclient;

public class _Arguments  implements java.io.Serializable {
    private com.amazon.merchants.transport.wsclient._Arguments_Argument[] argument;

    public _Arguments() {
    }

    public com.amazon.merchants.transport.wsclient._Arguments_Argument[] getArgument() {
        return argument;
    }

    public void setArgument(com.amazon.merchants.transport.wsclient._Arguments_Argument[] argument) {
        this.argument = argument;
    }

    public com.amazon.merchants.transport.wsclient._Arguments_Argument getArgument(int i) {
        return argument[i];
    }

    public void setArgument(int i, com.amazon.merchants.transport.wsclient._Arguments_Argument value) {
        this.argument[i] = value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof _Arguments)) return false;
        _Arguments other = (_Arguments) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.argument==null && other.getArgument()==null) || 
             (this.argument!=null &&
              java.util.Arrays.equals(this.argument, other.getArgument())));
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
        if (getArgument() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArgument());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArgument(), i);
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
        new org.apache.axis.description.TypeDesc(_Arguments.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">Arguments"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("argument");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "Argument"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">Arguments>Argument"));
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
