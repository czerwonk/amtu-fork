/**
 * DocumentProcessingInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.amazon.merchants.transport.soapclient;

public class DocumentProcessingInfo  implements java.io.Serializable {
    private java.lang.String documentProcessingStatus;
    private com.amazon.merchants.transport.soapclient.MerchantDocumentInfo processingReport;

    public DocumentProcessingInfo() {
    }

    public java.lang.String getDocumentProcessingStatus() {
        return documentProcessingStatus;
    }

    public void setDocumentProcessingStatus(java.lang.String documentProcessingStatus) {
        this.documentProcessingStatus = documentProcessingStatus;
    }

    public com.amazon.merchants.transport.soapclient.MerchantDocumentInfo getProcessingReport() {
        return processingReport;
    }

    public void setProcessingReport(com.amazon.merchants.transport.soapclient.MerchantDocumentInfo processingReport) {
        this.processingReport = processingReport;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DocumentProcessingInfo)) return false;
        DocumentProcessingInfo other = (DocumentProcessingInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.documentProcessingStatus==null && other.getDocumentProcessingStatus()==null) || 
             (this.documentProcessingStatus!=null &&
              this.documentProcessingStatus.equals(other.getDocumentProcessingStatus()))) &&
            ((this.processingReport==null && other.getProcessingReport()==null) || 
             (this.processingReport!=null &&
              this.processingReport.equals(other.getProcessingReport())));
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
        if (getDocumentProcessingStatus() != null) {
            _hashCode += getDocumentProcessingStatus().hashCode();
        }
        if (getProcessingReport() != null) {
            _hashCode += getProcessingReport().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DocumentProcessingInfo.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.amazon.com/merchants/merchant-interface/", "DocumentProcessingInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentProcessingStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.amazon.com/merchants/merchant-interface/", "documentProcessingStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("processingReport");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.amazon.com/merchants/merchant-interface/", "processingReport"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.amazon.com/merchants/merchant-interface/", "MerchantDocumentInfo"));
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
