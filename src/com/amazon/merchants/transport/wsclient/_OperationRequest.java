/**
 * _OperationRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.amazon.merchants.transport.wsclient;

public class _OperationRequest  implements java.io.Serializable {
    private com.amazon.merchants.transport.wsclient._HTTPHeaders HTTPHeaders;
    private java.lang.String requestId;
    private com.amazon.merchants.transport.wsclient._Arguments arguments;
    private com.amazon.merchants.transport.wsclient._Errors errors;
    private java.lang.Float requestProcessingTime;

    public _OperationRequest() {
    }

    public com.amazon.merchants.transport.wsclient._HTTPHeaders getHTTPHeaders() {
        return HTTPHeaders;
    }

    public void setHTTPHeaders(com.amazon.merchants.transport.wsclient._HTTPHeaders HTTPHeaders) {
        this.HTTPHeaders = HTTPHeaders;
    }

    public java.lang.String getRequestId() {
        return requestId;
    }

    public void setRequestId(java.lang.String requestId) {
        this.requestId = requestId;
    }

    public com.amazon.merchants.transport.wsclient._Arguments getArguments() {
        return arguments;
    }

    public void setArguments(com.amazon.merchants.transport.wsclient._Arguments arguments) {
        this.arguments = arguments;
    }

    public com.amazon.merchants.transport.wsclient._Errors getErrors() {
        return errors;
    }

    public void setErrors(com.amazon.merchants.transport.wsclient._Errors errors) {
        this.errors = errors;
    }

    public java.lang.Float getRequestProcessingTime() {
        return requestProcessingTime;
    }

    public void setRequestProcessingTime(java.lang.Float requestProcessingTime) {
        this.requestProcessingTime = requestProcessingTime;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof _OperationRequest)) return false;
        _OperationRequest other = (_OperationRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.HTTPHeaders==null && other.getHTTPHeaders()==null) || 
             (this.HTTPHeaders!=null &&
              this.HTTPHeaders.equals(other.getHTTPHeaders()))) &&
            ((this.requestId==null && other.getRequestId()==null) || 
             (this.requestId!=null &&
              this.requestId.equals(other.getRequestId()))) &&
            ((this.arguments==null && other.getArguments()==null) || 
             (this.arguments!=null &&
              this.arguments.equals(other.getArguments()))) &&
            ((this.errors==null && other.getErrors()==null) || 
             (this.errors!=null &&
              this.errors.equals(other.getErrors()))) &&
            ((this.requestProcessingTime==null && other.getRequestProcessingTime()==null) || 
             (this.requestProcessingTime!=null &&
              this.requestProcessingTime.equals(other.getRequestProcessingTime())));
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
        if (getHTTPHeaders() != null) {
            _hashCode += getHTTPHeaders().hashCode();
        }
        if (getRequestId() != null) {
            _hashCode += getRequestId().hashCode();
        }
        if (getArguments() != null) {
            _hashCode += getArguments().hashCode();
        }
        if (getErrors() != null) {
            _hashCode += getErrors().hashCode();
        }
        if (getRequestProcessingTime() != null) {
            _hashCode += getRequestProcessingTime().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(_OperationRequest.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">OperationRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("HTTPHeaders");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "HTTPHeaders"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">HTTPHeaders"));
        elemField.setMinOccurs(0);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "RequestId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arguments");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "Arguments"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">Arguments"));
        elemField.setMinOccurs(0);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errors");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "Errors"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">Errors"));
        elemField.setMinOccurs(0);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestProcessingTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "RequestProcessingTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "float"));
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
