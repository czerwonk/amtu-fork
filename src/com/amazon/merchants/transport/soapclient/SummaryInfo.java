/**
 * SummaryInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.amazon.merchants.transport.soapclient;

public class SummaryInfo  implements java.io.Serializable {
    private long batchID;
    private java.lang.String batchStatus;
    private int numberOfProcessed;
    private int numberOfRecordsWithErrors;
    private int numberOfRecordsWithWarnings;
    private int numberOfSuccessful;
    private java.lang.String summaryLogFile;
    private java.util.Calendar uploadDateTime;

    public SummaryInfo() {
    }

    public long getBatchID() {
        return batchID;
    }

    public void setBatchID(long batchID) {
        this.batchID = batchID;
    }

    public java.lang.String getBatchStatus() {
        return batchStatus;
    }

    public void setBatchStatus(java.lang.String batchStatus) {
        this.batchStatus = batchStatus;
    }

    public int getNumberOfProcessed() {
        return numberOfProcessed;
    }

    public void setNumberOfProcessed(int numberOfProcessed) {
        this.numberOfProcessed = numberOfProcessed;
    }

    public int getNumberOfRecordsWithErrors() {
        return numberOfRecordsWithErrors;
    }

    public void setNumberOfRecordsWithErrors(int numberOfRecordsWithErrors) {
        this.numberOfRecordsWithErrors = numberOfRecordsWithErrors;
    }

    public int getNumberOfRecordsWithWarnings() {
        return numberOfRecordsWithWarnings;
    }

    public void setNumberOfRecordsWithWarnings(int numberOfRecordsWithWarnings) {
        this.numberOfRecordsWithWarnings = numberOfRecordsWithWarnings;
    }

    public int getNumberOfSuccessful() {
        return numberOfSuccessful;
    }

    public void setNumberOfSuccessful(int numberOfSuccessful) {
        this.numberOfSuccessful = numberOfSuccessful;
    }

    public java.lang.String getSummaryLogFile() {
        return summaryLogFile;
    }

    public void setSummaryLogFile(java.lang.String summaryLogFile) {
        this.summaryLogFile = summaryLogFile;
    }

    public java.util.Calendar getUploadDateTime() {
        return uploadDateTime;
    }

    public void setUploadDateTime(java.util.Calendar uploadDateTime) {
        this.uploadDateTime = uploadDateTime;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SummaryInfo)) return false;
        SummaryInfo other = (SummaryInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.batchID == other.getBatchID() &&
            ((this.batchStatus==null && other.getBatchStatus()==null) || 
             (this.batchStatus!=null &&
              this.batchStatus.equals(other.getBatchStatus()))) &&
            this.numberOfProcessed == other.getNumberOfProcessed() &&
            this.numberOfRecordsWithErrors == other.getNumberOfRecordsWithErrors() &&
            this.numberOfRecordsWithWarnings == other.getNumberOfRecordsWithWarnings() &&
            this.numberOfSuccessful == other.getNumberOfSuccessful() &&
            ((this.summaryLogFile==null && other.getSummaryLogFile()==null) || 
             (this.summaryLogFile!=null &&
              this.summaryLogFile.equals(other.getSummaryLogFile()))) &&
            ((this.uploadDateTime==null && other.getUploadDateTime()==null) || 
             (this.uploadDateTime!=null &&
              this.uploadDateTime.equals(other.getUploadDateTime())));
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
        _hashCode += new Long(getBatchID()).hashCode();
        if (getBatchStatus() != null) {
            _hashCode += getBatchStatus().hashCode();
        }
        _hashCode += getNumberOfProcessed();
        _hashCode += getNumberOfRecordsWithErrors();
        _hashCode += getNumberOfRecordsWithWarnings();
        _hashCode += getNumberOfSuccessful();
        if (getSummaryLogFile() != null) {
            _hashCode += getSummaryLogFile().hashCode();
        }
        if (getUploadDateTime() != null) {
            _hashCode += getUploadDateTime().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SummaryInfo.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.amazon.com/merchants/merchant-interface/", "SummaryInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("batchID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.amazon.com/merchants/merchant-interface/", "batchID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("batchStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.amazon.com/merchants/merchant-interface/", "batchStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberOfProcessed");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.amazon.com/merchants/merchant-interface/", "numberOfProcessed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberOfRecordsWithErrors");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.amazon.com/merchants/merchant-interface/", "numberOfRecordsWithErrors"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberOfRecordsWithWarnings");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.amazon.com/merchants/merchant-interface/", "numberOfRecordsWithWarnings"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberOfSuccessful");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.amazon.com/merchants/merchant-interface/", "numberOfSuccessful"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("summaryLogFile");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.amazon.com/merchants/merchant-interface/", "summaryLogFile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("uploadDateTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.amazon.com/merchants/merchant-interface/", "uploadDateTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
