/**
 * AWSMerchantServiceBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.amazon.merchants.transport.wsclient;

public class AWSMerchantServiceBindingStub extends org.apache.axis.client.Stub implements com.amazon.merchants.transport.wsclient.AWSMerchantServicePortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[21];
        org.apache.axis.description.OperationDesc oper;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getMerchantInfoFromCustomerID");
        oper.addParameter(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "getMerchantInfoFromCustomerID"), new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getMerchantInfoFromCustomerID"), com.amazon.merchants.transport.wsclient._getMerchantInfoFromCustomerID.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getMerchantInfoFromCustomerIDResponse"));
        oper.setReturnClass(com.amazon.merchants.transport.wsclient._getMerchantInfoFromCustomerIDResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "getMerchantInfoFromCustomerIDResponse"));
        oper.setStyle(org.apache.axis.enum.Style.DOCUMENT);
        oper.setUse(org.apache.axis.enum.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("postDocument");
        oper.addParameter(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "postDocument"), new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">postDocument"), com.amazon.merchants.transport.wsclient._postDocument.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "document"), new javax.xml.namespace.QName("http://xml.apache.org/xml-soap", "Multipart"), javax.mail.internet.MimeMultipart.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">postDocumentResponse"));
        oper.setReturnClass(com.amazon.merchants.transport.wsclient._postDocumentResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "postDocumentResponse"));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getDocument");
        oper.addParameter(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "getDocument"), new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getDocument"), com.amazon.merchants.transport.wsclient._getDocument.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "getDocumentResponse"), new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getDocumentResponse"), com.amazon.merchants.transport.wsclient._getDocumentResponse.class, org.apache.axis.description.ParameterDesc.OUT, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "document"), new javax.xml.namespace.QName("http://xml.apache.org/xml-soap", "Multipart"), javax.mail.internet.MimeMultipart.class, org.apache.axis.description.ParameterDesc.OUT, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("generateReport");
        oper.addParameter(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "generateReport"), new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">generateReport"), com.amazon.merchants.transport.wsclient._generateReport.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">generateReportResponse"));
        oper.setReturnClass(com.amazon.merchants.transport.wsclient._generateReportResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "generateReportResponse"));
        oper.setStyle(org.apache.axis.enum.Style.DOCUMENT);
        oper.setUse(org.apache.axis.enum.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getLastNDocumentInfo");
        oper.addParameter(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "getLastNDocumentInfo"), new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getLastNDocumentInfo"), com.amazon.merchants.transport.wsclient._getLastNDocumentInfo.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getLastNDocumentInfoResponse"));
        oper.setReturnClass(com.amazon.merchants.transport.wsclient._getLastNDocumentInfoResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "getLastNDocumentInfoResponse"));
        oper.setStyle(org.apache.axis.enum.Style.DOCUMENT);
        oper.setUse(org.apache.axis.enum.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getDocumentInterfaceConformance");
        oper.addParameter(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "getDocumentInterfaceConformance"), new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getDocumentInterfaceConformance"), com.amazon.merchants.transport.wsclient._getDocumentInterfaceConformance.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "getDocumentInterfaceConformanceResponse"), new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getDocumentInterfaceConformanceResponse"), com.amazon.merchants.transport.wsclient._getDocumentInterfaceConformanceResponse.class, org.apache.axis.description.ParameterDesc.OUT, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "document"), new javax.xml.namespace.QName("http://xml.apache.org/xml-soap", "Multipart"), javax.mail.internet.MimeMultipart.class, org.apache.axis.description.ParameterDesc.OUT, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getLastNReportInfo");
        oper.addParameter(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "getLastNReportInfo"), new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getLastNReportInfo"), com.amazon.merchants.transport.wsclient._getLastNReportInfo.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getLastNReportInfoResponse"));
        oper.setReturnClass(com.amazon.merchants.transport.wsclient._getLastNReportInfoResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "getLastNReportInfoResponse"));
        oper.setStyle(org.apache.axis.enum.Style.DOCUMENT);
        oper.setUse(org.apache.axis.enum.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getLastNDocumentProcessingStatuses");
        oper.addParameter(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "getLastNDocumentProcessingStatuses"), new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getLastNDocumentProcessingStatuses"), com.amazon.merchants.transport.wsclient._getLastNDocumentProcessingStatuses.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getLastNDocumentProcessingStatusesResponse"));
        oper.setReturnClass(com.amazon.merchants.transport.wsclient._getLastNDocumentProcessingStatusesResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "getLastNDocumentProcessingStatusesResponse"));
        oper.setStyle(org.apache.axis.enum.Style.DOCUMENT);
        oper.setUse(org.apache.axis.enum.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getAllPendingDocumentInfo");
        oper.addParameter(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "getAllPendingDocumentInfo"), new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getAllPendingDocumentInfo"), com.amazon.merchants.transport.wsclient._getAllPendingDocumentInfo.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getAllPendingDocumentInfoResponse"));
        oper.setReturnClass(com.amazon.merchants.transport.wsclient._getAllPendingDocumentInfoResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "getAllPendingDocumentInfoResponse"));
        oper.setStyle(org.apache.axis.enum.Style.DOCUMENT);
        oper.setUse(org.apache.axis.enum.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getDocumentInfoListGivenTimeWindow");
        oper.addParameter(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "getDocumentInfoListGivenTimeWindow"), new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getDocumentInfoListGivenTimeWindow"), com.amazon.merchants.transport.wsclient._getDocumentInfoListGivenTimeWindow.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getDocumentInfoListGivenTimeWindowResponse"));
        oper.setReturnClass(com.amazon.merchants.transport.wsclient._getDocumentInfoListGivenTimeWindowResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "getDocumentInfoListGivenTimeWindowResponse"));
        oper.setStyle(org.apache.axis.enum.Style.DOCUMENT);
        oper.setUse(org.apache.axis.enum.Use.LITERAL);
        _operations[9] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getLastNPendingDocumentInfo");
        oper.addParameter(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "getLastNPendingDocumentInfo"), new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getLastNPendingDocumentInfo"), com.amazon.merchants.transport.wsclient._getLastNPendingDocumentInfo.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getLastNPendingDocumentInfoResponse"));
        oper.setReturnClass(com.amazon.merchants.transport.wsclient._getLastNPendingDocumentInfoResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "getLastNPendingDocumentInfoResponse"));
        oper.setStyle(org.apache.axis.enum.Style.DOCUMENT);
        oper.setUse(org.apache.axis.enum.Use.LITERAL);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("postDocumentDownloadAck");
        oper.addParameter(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "postDocumentDownloadAck"), new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">postDocumentDownloadAck"), com.amazon.merchants.transport.wsclient._postDocumentDownloadAck.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">postDocumentDownloadAckResponse"));
        oper.setReturnClass(com.amazon.merchants.transport.wsclient._postDocumentDownloadAckResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "postDocumentDownloadAckResponse"));
        oper.setStyle(org.apache.axis.enum.Style.DOCUMENT);
        oper.setUse(org.apache.axis.enum.Use.LITERAL);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getDocumentProcessingStatus");
        oper.addParameter(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "getDocumentProcessingStatus"), new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getDocumentProcessingStatus"), com.amazon.merchants.transport.wsclient._getDocumentProcessingStatus.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getDocumentProcessingStatusResponse"));
        oper.setReturnClass(com.amazon.merchants.transport.wsclient._getDocumentProcessingStatusResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "getDocumentProcessingStatusResponse"));
        oper.setStyle(org.apache.axis.enum.Style.DOCUMENT);
        oper.setUse(org.apache.axis.enum.Use.LITERAL);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("postReport");
        oper.addParameter(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "postReport"), new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">postReport"), com.amazon.merchants.transport.wsclient._postReport.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "document"), new javax.xml.namespace.QName("http://xml.apache.org/xml-soap", "Multipart"), javax.mail.internet.MimeMultipart.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">postReportResponse"));
        oper.setReturnClass(com.amazon.merchants.transport.wsclient._postReportResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "postReportResponse"));
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("scheduleReports");
        oper.addParameter(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "scheduleReports"), new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">scheduleReports"), com.amazon.merchants.transport.wsclient._scheduleReports.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">scheduleReportsResponse"));
        oper.setReturnClass(com.amazon.merchants.transport.wsclient._scheduleReportsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "scheduleReportsResponse"));
        oper.setStyle(org.apache.axis.enum.Style.DOCUMENT);
        oper.setUse(org.apache.axis.enum.Use.LITERAL);
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("postDocumentConfirmation");
        oper.addParameter(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "postDocumentConfirmation"), new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">postDocumentConfirmation"), com.amazon.merchants.transport.wsclient._postDocumentConfirmation.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">postDocumentConfirmationResponse"));
        oper.setReturnClass(com.amazon.merchants.transport.wsclient._postDocumentConfirmationResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "postDocumentConfirmationResponse"));
        oper.setStyle(org.apache.axis.enum.Style.DOCUMENT);
        oper.setUse(org.apache.axis.enum.Use.LITERAL);
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("postDocumentInterfaceConformance");
        oper.addParameter(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "postDocumentInterfaceConformance"), new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">postDocumentInterfaceConformance"), com.amazon.merchants.transport.wsclient._postDocumentInterfaceConformance.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "document"), new javax.xml.namespace.QName("http://xml.apache.org/xml-soap", "Multipart"), javax.mail.internet.MimeMultipart.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">postDocumentInterfaceConformanceResponse"));
        oper.setReturnClass(com.amazon.merchants.transport.wsclient._postDocumentInterfaceConformanceResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "postDocumentInterfaceConformanceResponse"));
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("postDocumentUnconfirmed");
        oper.addParameter(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "postDocumentUnconfirmed"), new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">postDocumentUnconfirmed"), com.amazon.merchants.transport.wsclient._postDocumentUnconfirmed.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "document"), new javax.xml.namespace.QName("http://xml.apache.org/xml-soap", "Multipart"), javax.mail.internet.MimeMultipart.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">postDocumentUnconfirmedResponse"));
        oper.setReturnClass(com.amazon.merchants.transport.wsclient._postDocumentUnconfirmedResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "postDocumentUnconfirmedResponse"));
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("postDocumentUnconfirmedInterfaceConformance");
        oper.addParameter(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "postDocumentUnconfirmedInterfaceConformance"), new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">postDocumentUnconfirmedInterfaceConformance"), com.amazon.merchants.transport.wsclient._postDocumentUnconfirmedInterfaceConformance.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "document"), new javax.xml.namespace.QName("http://xml.apache.org/xml-soap", "Multipart"), javax.mail.internet.MimeMultipart.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">postDocumentUnconfirmedInterfaceConformanceResponse"));
        oper.setReturnClass(com.amazon.merchants.transport.wsclient._postDocumentUnconfirmedInterfaceConformanceResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "postDocumentUnconfirmedInterfaceConformanceResponse"));
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPendingDocumentInfoListGivenTimeWindow");
        oper.addParameter(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "getPendingDocumentInfoListGivenTimeWindow"), new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getPendingDocumentInfoListGivenTimeWindow"), com.amazon.merchants.transport.wsclient._getPendingDocumentInfoListGivenTimeWindow.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getPendingDocumentInfoListGivenTimeWindowResponse"));
        oper.setReturnClass(com.amazon.merchants.transport.wsclient._getPendingDocumentInfoListGivenTimeWindowResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "getPendingDocumentInfoListGivenTimeWindowResponse"));
        oper.setStyle(org.apache.axis.enum.Style.DOCUMENT);
        oper.setUse(org.apache.axis.enum.Use.LITERAL);
        _operations[19] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getDocumentInfoInterfaceConformance");
        oper.addParameter(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "getDocumentInfoInterfaceConformance"), new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getDocumentInfoInterfaceConformance"), com.amazon.merchants.transport.wsclient._getDocumentInfoInterfaceConformance.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getDocumentInfoInterfaceConformanceResponse"));
        oper.setReturnClass(com.amazon.merchants.transport.wsclient._getDocumentInfoInterfaceConformanceResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "getDocumentInfoInterfaceConformanceResponse"));
        oper.setStyle(org.apache.axis.enum.Style.DOCUMENT);
        oper.setUse(org.apache.axis.enum.Use.LITERAL);
        _operations[20] = oper;

    }

    public AWSMerchantServiceBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public AWSMerchantServiceBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public AWSMerchantServiceBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class mimesf = org.apache.axis.encoding.ser.JAFDataHandlerSerializerFactory.class;
            java.lang.Class mimedf = org.apache.axis.encoding.ser.JAFDataHandlerDeserializerFactory.class;

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "DataHandler");
            cachedSerQNames.add(qName);
            cls = javax.activation.DataHandler.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(mimesf);
            cachedDeserFactories.add(mimedf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "scheduleReportsRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient.ScheduleReportsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "HelpRequest>HelpType");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient.HelpRequest_HelpType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "postDocumentConfirmationRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient.PostDocumentConfirmationRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "postDocumentInterfaceConformanceRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient.PostDocumentInterfaceConformanceRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">scheduleReportsResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._scheduleReportsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">postDocumentUnconfirmedResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._postDocumentUnconfirmedResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getDocument");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._getDocument.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">Errors");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._Errors.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getLastNReportInfoResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._getLastNReportInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getLastNDocumentInfo");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._getLastNDocumentInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getDocumentInfoInterfaceConformanceResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._getDocumentInfoInterfaceConformanceResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "getAllPendingDocumentInfoRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient.GetAllPendingDocumentInfoRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getLastNDocumentProcessingStatusesResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._getLastNDocumentProcessingStatusesResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "Merchant");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient.Merchant.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">postDocumentUnconfirmed");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._postDocumentUnconfirmed.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "getDocumentInfoListGivenTimeWindowRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient.GetDocumentInfoListGivenTimeWindowRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">generateReport");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._generateReport.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "GetDocumentResult");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient.GetDocumentResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">postDocumentDownloadAckResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._postDocumentDownloadAckResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">postReportResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._postReportResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "GetDocumentInterfaceConformanceResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient.GetDocumentInterfaceConformanceResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "generateReportRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient.GenerateReportRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "getMerchantInfoFromCustomerIDRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient.GetMerchantInfoFromCustomerIDRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "SummaryInfo");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient.SummaryInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">postReport");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._postReport.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "getLastNDocumentInfoRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient.GetLastNDocumentInfoRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "postDocumentUnconfirmedInterfaceConformanceRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient.PostDocumentUnconfirmedInterfaceConformanceRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "DocumentIDArray");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient.DocumentIDArray.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getDocumentInfoInterfaceConformance");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._getDocumentInfoInterfaceConformance.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "getDocumentRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient.GetDocumentRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">Arguments");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._Arguments.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "getDocumentInterfaceConformanceRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient.GetDocumentInterfaceConformanceRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "MerchantInfo");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient.MerchantInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getDocumentInterfaceConformanceResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._getDocumentInterfaceConformanceResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "DocumentInfo");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient.DocumentInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getDocumentInfoListGivenTimeWindow");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._getDocumentInfoListGivenTimeWindow.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "postDocumentRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient.PostDocumentRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getLastNDocumentInfoResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._getLastNDocumentInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "ReportInfoArray");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient.ReportInfoArray.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "getDocumentProcessingStatusRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient.GetDocumentProcessingStatusRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "getLastNDocumentProcessingStatusesRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient.GetLastNDocumentProcessingStatusesRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "DocumentDownloadAckStatus");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient.DocumentDownloadAckStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">HTTPHeaders");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._HTTPHeaders.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">postDocumentUnconfirmedInterfaceConformance");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._postDocumentUnconfirmedInterfaceConformance.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">Errors>Error");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._Errors_Error.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getDocumentInterfaceConformance");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._getDocumentInterfaceConformance.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">Arguments>Argument");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._Arguments_Argument.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "FrequencyType");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient.FrequencyType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getMerchantInfoFromCustomerIDResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._getMerchantInfoFromCustomerIDResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "postDocumentUnconfirmedRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient.PostDocumentUnconfirmedRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getDocumentProcessingStatusResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._getDocumentProcessingStatusResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">postDocumentConfirmation");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._postDocumentConfirmation.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">postDocumentResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._postDocumentResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getAllPendingDocumentInfo");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._getAllPendingDocumentInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getDocumentProcessingStatus");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._getDocumentProcessingStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">postDocumentUnconfirmedInterfaceConformanceResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._postDocumentUnconfirmedInterfaceConformanceResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "getDocumentInfoInterfaceConformanceRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient.GetDocumentInfoInterfaceConformanceRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getLastNPendingDocumentInfo");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._getLastNPendingDocumentInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">OperationRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._OperationRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">postDocument");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._postDocument.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "DocumentDownloadAckStatusArray");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient.DocumentDownloadAckStatusArray.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getDocumentInfoListGivenTimeWindowResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._getDocumentInfoListGivenTimeWindowResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">scheduleReports");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._scheduleReports.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "GenerateReportResult");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient.GenerateReportResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "postReportRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient.PostReportRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getAllPendingDocumentInfoResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._getAllPendingDocumentInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">postDocumentConfirmationResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._postDocumentConfirmationResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">postDocumentDownloadAck");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._postDocumentDownloadAck.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getLastNReportInfo");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._getLastNReportInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getLastNDocumentProcessingStatuses");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._getLastNDocumentProcessingStatuses.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "HelpRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient.HelpRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getMerchantInfoFromCustomerID");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._getMerchantInfoFromCustomerID.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "getPendingDocumentInfoListGivenTimeWindowRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient.GetPendingDocumentInfoListGivenTimeWindowRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">postDocumentInterfaceConformanceResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._postDocumentInterfaceConformanceResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "getLastNPendingDocumentInfoRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient.GetLastNPendingDocumentInfoRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "ReportGenerationResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient.ReportGenerationResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">Request");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._Request.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getDocumentResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._getDocumentResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "DocumentSubmissionResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient.DocumentSubmissionResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">HTTPHeaders>Header");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._HTTPHeaders_Header.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getPendingDocumentInfoListGivenTimeWindowResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._getPendingDocumentInfoListGivenTimeWindowResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getLastNPendingDocumentInfoResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._getLastNPendingDocumentInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "postDocumentDownloadAckRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient.PostDocumentDownloadAckRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">postDocumentInterfaceConformance");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._postDocumentInterfaceConformance.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "getLastNReportInfoRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient.GetLastNReportInfoRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">getPendingDocumentInfoListGivenTimeWindow");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._getPendingDocumentInfoListGivenTimeWindow.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", ">generateReportResponse");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient._generateReportResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "DocumentProcessingInfo");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient.DocumentProcessingInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "SummaryInfoArray");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient.SummaryInfoArray.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "ReportInfo");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient.ReportInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "DocumentInfoArray");
            cachedSerQNames.add(qName);
            cls = com.amazon.merchants.transport.wsclient.DocumentInfoArray.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    private org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call =
                    (org.apache.axis.client.Call) super.service.createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                        java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                        _call.registerTypeMapping(cls, qName, sf, df, false);
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", t);
        }
    }

    public com.amazon.merchants.transport.wsclient._getMerchantInfoFromCustomerIDResponse getMerchantInfoFromCustomerID(com.amazon.merchants.transport.wsclient._getMerchantInfoFromCustomerID body) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getMerchantInfoFromCustomerID"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.merchants.transport.wsclient._getMerchantInfoFromCustomerIDResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.merchants.transport.wsclient._getMerchantInfoFromCustomerIDResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.merchants.transport.wsclient._getMerchantInfoFromCustomerIDResponse.class);
            }
        }
    }

    public com.amazon.merchants.transport.wsclient._postDocumentResponse postDocument(com.amazon.merchants.transport.wsclient._postDocument body, javax.mail.internet.MimeMultipart document) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "postDocument"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, document});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.merchants.transport.wsclient._postDocumentResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.merchants.transport.wsclient._postDocumentResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.merchants.transport.wsclient._postDocumentResponse.class);
            }
        }
    }

    public void getDocument(com.amazon.merchants.transport.wsclient._getDocument body, com.amazon.merchants.transport.wsclient.holders._getDocumentResponseHolder body2, org.apache.axis.holders.MimeMultipartHolder document) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getDocument"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                body2.value = (com.amazon.merchants.transport.wsclient._getDocumentResponse) _output.get(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "getDocumentResponse"));
            } catch (java.lang.Exception _exception) {
                body2.value = (com.amazon.merchants.transport.wsclient._getDocumentResponse) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "getDocumentResponse")), com.amazon.merchants.transport.wsclient._getDocumentResponse.class);
            }
            try {
                document.value = (javax.mail.internet.MimeMultipart) _output.get(new javax.xml.namespace.QName("", "document"));
            } catch (java.lang.Exception _exception) {
                document.value = (javax.mail.internet.MimeMultipart) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "document")), byte[].class);
            }
        }
    }

    public com.amazon.merchants.transport.wsclient._generateReportResponse generateReport(com.amazon.merchants.transport.wsclient._generateReport body) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "generateReport"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.merchants.transport.wsclient._generateReportResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.merchants.transport.wsclient._generateReportResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.merchants.transport.wsclient._generateReportResponse.class);
            }
        }
    }

    public com.amazon.merchants.transport.wsclient._getLastNDocumentInfoResponse getLastNDocumentInfo(com.amazon.merchants.transport.wsclient._getLastNDocumentInfo body) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getLastNDocumentInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.merchants.transport.wsclient._getLastNDocumentInfoResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.merchants.transport.wsclient._getLastNDocumentInfoResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.merchants.transport.wsclient._getLastNDocumentInfoResponse.class);
            }
        }
    }

    public void getDocumentInterfaceConformance(com.amazon.merchants.transport.wsclient._getDocumentInterfaceConformance body, com.amazon.merchants.transport.wsclient.holders._getDocumentInterfaceConformanceResponseHolder body2, org.apache.axis.holders.MimeMultipartHolder document) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getDocumentInterfaceConformance"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                body2.value = (com.amazon.merchants.transport.wsclient._getDocumentInterfaceConformanceResponse) _output.get(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "getDocumentInterfaceConformanceResponse"));
            } catch (java.lang.Exception _exception) {
                body2.value = (com.amazon.merchants.transport.wsclient._getDocumentInterfaceConformanceResponse) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("http://xml.amazon.com/AWSMerchantService/2005-08-15", "getDocumentInterfaceConformanceResponse")), com.amazon.merchants.transport.wsclient._getDocumentInterfaceConformanceResponse.class);
            }
            try {
                document.value = (javax.mail.internet.MimeMultipart) _output.get(new javax.xml.namespace.QName("", "document"));
            } catch (java.lang.Exception _exception) {
                document.value = (javax.mail.internet.MimeMultipart) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "document")), byte[].class);
            }
        }
    }

    public com.amazon.merchants.transport.wsclient._getLastNReportInfoResponse getLastNReportInfo(com.amazon.merchants.transport.wsclient._getLastNReportInfo body) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getLastNReportInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.merchants.transport.wsclient._getLastNReportInfoResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.merchants.transport.wsclient._getLastNReportInfoResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.merchants.transport.wsclient._getLastNReportInfoResponse.class);
            }
        }
    }

    public com.amazon.merchants.transport.wsclient._getLastNDocumentProcessingStatusesResponse getLastNDocumentProcessingStatuses(com.amazon.merchants.transport.wsclient._getLastNDocumentProcessingStatuses body) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getLastNDocumentProcessingStatuses"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.merchants.transport.wsclient._getLastNDocumentProcessingStatusesResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.merchants.transport.wsclient._getLastNDocumentProcessingStatusesResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.merchants.transport.wsclient._getLastNDocumentProcessingStatusesResponse.class);
            }
        }
    }

    public com.amazon.merchants.transport.wsclient._getAllPendingDocumentInfoResponse getAllPendingDocumentInfo(com.amazon.merchants.transport.wsclient._getAllPendingDocumentInfo body) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getAllPendingDocumentInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.merchants.transport.wsclient._getAllPendingDocumentInfoResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.merchants.transport.wsclient._getAllPendingDocumentInfoResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.merchants.transport.wsclient._getAllPendingDocumentInfoResponse.class);
            }
        }
    }

    public com.amazon.merchants.transport.wsclient._getDocumentInfoListGivenTimeWindowResponse getDocumentInfoListGivenTimeWindow(com.amazon.merchants.transport.wsclient._getDocumentInfoListGivenTimeWindow body) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getDocumentInfoListGivenTimeWindow"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.merchants.transport.wsclient._getDocumentInfoListGivenTimeWindowResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.merchants.transport.wsclient._getDocumentInfoListGivenTimeWindowResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.merchants.transport.wsclient._getDocumentInfoListGivenTimeWindowResponse.class);
            }
        }
    }

    public com.amazon.merchants.transport.wsclient._getLastNPendingDocumentInfoResponse getLastNPendingDocumentInfo(com.amazon.merchants.transport.wsclient._getLastNPendingDocumentInfo body) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getLastNPendingDocumentInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.merchants.transport.wsclient._getLastNPendingDocumentInfoResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.merchants.transport.wsclient._getLastNPendingDocumentInfoResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.merchants.transport.wsclient._getLastNPendingDocumentInfoResponse.class);
            }
        }
    }

    public com.amazon.merchants.transport.wsclient._postDocumentDownloadAckResponse postDocumentDownloadAck(com.amazon.merchants.transport.wsclient._postDocumentDownloadAck body) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "postDocumentDownloadAck"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.merchants.transport.wsclient._postDocumentDownloadAckResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.merchants.transport.wsclient._postDocumentDownloadAckResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.merchants.transport.wsclient._postDocumentDownloadAckResponse.class);
            }
        }
    }

    public com.amazon.merchants.transport.wsclient._getDocumentProcessingStatusResponse getDocumentProcessingStatus(com.amazon.merchants.transport.wsclient._getDocumentProcessingStatus body) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getDocumentProcessingStatus"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.merchants.transport.wsclient._getDocumentProcessingStatusResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.merchants.transport.wsclient._getDocumentProcessingStatusResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.merchants.transport.wsclient._getDocumentProcessingStatusResponse.class);
            }
        }
    }

    public com.amazon.merchants.transport.wsclient._postReportResponse postReport(com.amazon.merchants.transport.wsclient._postReport body, javax.mail.internet.MimeMultipart document) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "postReport"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, document});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.merchants.transport.wsclient._postReportResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.merchants.transport.wsclient._postReportResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.merchants.transport.wsclient._postReportResponse.class);
            }
        }
    }

    public com.amazon.merchants.transport.wsclient._scheduleReportsResponse scheduleReports(com.amazon.merchants.transport.wsclient._scheduleReports body) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "scheduleReports"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.merchants.transport.wsclient._scheduleReportsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.merchants.transport.wsclient._scheduleReportsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.merchants.transport.wsclient._scheduleReportsResponse.class);
            }
        }
    }

    public com.amazon.merchants.transport.wsclient._postDocumentConfirmationResponse postDocumentConfirmation(com.amazon.merchants.transport.wsclient._postDocumentConfirmation body) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "postDocumentConfirmation"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.merchants.transport.wsclient._postDocumentConfirmationResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.merchants.transport.wsclient._postDocumentConfirmationResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.merchants.transport.wsclient._postDocumentConfirmationResponse.class);
            }
        }
    }

    public com.amazon.merchants.transport.wsclient._postDocumentInterfaceConformanceResponse postDocumentInterfaceConformance(com.amazon.merchants.transport.wsclient._postDocumentInterfaceConformance body, javax.mail.internet.MimeMultipart document) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "postDocumentInterfaceConformance"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, document});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.merchants.transport.wsclient._postDocumentInterfaceConformanceResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.merchants.transport.wsclient._postDocumentInterfaceConformanceResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.merchants.transport.wsclient._postDocumentInterfaceConformanceResponse.class);
            }
        }
    }

    public com.amazon.merchants.transport.wsclient._postDocumentUnconfirmedResponse postDocumentUnconfirmed(com.amazon.merchants.transport.wsclient._postDocumentUnconfirmed body, javax.mail.internet.MimeMultipart document) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "postDocumentUnconfirmed"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, document});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.merchants.transport.wsclient._postDocumentUnconfirmedResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.merchants.transport.wsclient._postDocumentUnconfirmedResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.merchants.transport.wsclient._postDocumentUnconfirmedResponse.class);
            }
        }
    }

    public com.amazon.merchants.transport.wsclient._postDocumentUnconfirmedInterfaceConformanceResponse postDocumentUnconfirmedInterfaceConformance(com.amazon.merchants.transport.wsclient._postDocumentUnconfirmedInterfaceConformance body, javax.mail.internet.MimeMultipart document) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "postDocumentUnconfirmedInterfaceConformance"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body, document});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.merchants.transport.wsclient._postDocumentUnconfirmedInterfaceConformanceResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.merchants.transport.wsclient._postDocumentUnconfirmedInterfaceConformanceResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.merchants.transport.wsclient._postDocumentUnconfirmedInterfaceConformanceResponse.class);
            }
        }
    }

    public com.amazon.merchants.transport.wsclient._getPendingDocumentInfoListGivenTimeWindowResponse getPendingDocumentInfoListGivenTimeWindow(com.amazon.merchants.transport.wsclient._getPendingDocumentInfoListGivenTimeWindow body) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getPendingDocumentInfoListGivenTimeWindow"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.merchants.transport.wsclient._getPendingDocumentInfoListGivenTimeWindowResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.merchants.transport.wsclient._getPendingDocumentInfoListGivenTimeWindowResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.merchants.transport.wsclient._getPendingDocumentInfoListGivenTimeWindowResponse.class);
            }
        }
    }

    public com.amazon.merchants.transport.wsclient._getDocumentInfoInterfaceConformanceResponse getDocumentInfoInterfaceConformance(com.amazon.merchants.transport.wsclient._getDocumentInfoInterfaceConformance body) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getDocumentInfoInterfaceConformance"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.merchants.transport.wsclient._getDocumentInfoInterfaceConformanceResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.merchants.transport.wsclient._getDocumentInfoInterfaceConformanceResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.merchants.transport.wsclient._getDocumentInfoInterfaceConformanceResponse.class);
            }
        }
    }

}
