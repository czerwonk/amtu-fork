/**
 * AWSMerchantServicePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.amazon.merchants.transport.wsclient;

public interface AWSMerchantServicePortType extends java.rmi.Remote {
    public com.amazon.merchants.transport.wsclient._getMerchantInfoFromCustomerIDResponse getMerchantInfoFromCustomerID(com.amazon.merchants.transport.wsclient._getMerchantInfoFromCustomerID body) throws java.rmi.RemoteException;
    public com.amazon.merchants.transport.wsclient._postDocumentResponse postDocument(com.amazon.merchants.transport.wsclient._postDocument body, javax.mail.internet.MimeMultipart document) throws java.rmi.RemoteException;
    public void getDocument(com.amazon.merchants.transport.wsclient._getDocument body, com.amazon.merchants.transport.wsclient.holders._getDocumentResponseHolder body2, org.apache.axis.holders.MimeMultipartHolder document) throws java.rmi.RemoteException;
    public com.amazon.merchants.transport.wsclient._generateReportResponse generateReport(com.amazon.merchants.transport.wsclient._generateReport body) throws java.rmi.RemoteException;
    public com.amazon.merchants.transport.wsclient._getLastNDocumentInfoResponse getLastNDocumentInfo(com.amazon.merchants.transport.wsclient._getLastNDocumentInfo body) throws java.rmi.RemoteException;
    public void getDocumentInterfaceConformance(com.amazon.merchants.transport.wsclient._getDocumentInterfaceConformance body, com.amazon.merchants.transport.wsclient.holders._getDocumentInterfaceConformanceResponseHolder body2, org.apache.axis.holders.MimeMultipartHolder document) throws java.rmi.RemoteException;
    public com.amazon.merchants.transport.wsclient._getLastNReportInfoResponse getLastNReportInfo(com.amazon.merchants.transport.wsclient._getLastNReportInfo body) throws java.rmi.RemoteException;
    public com.amazon.merchants.transport.wsclient._getLastNDocumentProcessingStatusesResponse getLastNDocumentProcessingStatuses(com.amazon.merchants.transport.wsclient._getLastNDocumentProcessingStatuses body) throws java.rmi.RemoteException;
    public com.amazon.merchants.transport.wsclient._getAllPendingDocumentInfoResponse getAllPendingDocumentInfo(com.amazon.merchants.transport.wsclient._getAllPendingDocumentInfo body) throws java.rmi.RemoteException;
    public com.amazon.merchants.transport.wsclient._getDocumentInfoListGivenTimeWindowResponse getDocumentInfoListGivenTimeWindow(com.amazon.merchants.transport.wsclient._getDocumentInfoListGivenTimeWindow body) throws java.rmi.RemoteException;
    public com.amazon.merchants.transport.wsclient._getLastNPendingDocumentInfoResponse getLastNPendingDocumentInfo(com.amazon.merchants.transport.wsclient._getLastNPendingDocumentInfo body) throws java.rmi.RemoteException;
    public com.amazon.merchants.transport.wsclient._postDocumentDownloadAckResponse postDocumentDownloadAck(com.amazon.merchants.transport.wsclient._postDocumentDownloadAck body) throws java.rmi.RemoteException;
    public com.amazon.merchants.transport.wsclient._getDocumentProcessingStatusResponse getDocumentProcessingStatus(com.amazon.merchants.transport.wsclient._getDocumentProcessingStatus body) throws java.rmi.RemoteException;
    public com.amazon.merchants.transport.wsclient._postReportResponse postReport(com.amazon.merchants.transport.wsclient._postReport body, javax.mail.internet.MimeMultipart document) throws java.rmi.RemoteException;
    public com.amazon.merchants.transport.wsclient._scheduleReportsResponse scheduleReports(com.amazon.merchants.transport.wsclient._scheduleReports body) throws java.rmi.RemoteException;
    public com.amazon.merchants.transport.wsclient._postDocumentConfirmationResponse postDocumentConfirmation(com.amazon.merchants.transport.wsclient._postDocumentConfirmation body) throws java.rmi.RemoteException;
    public com.amazon.merchants.transport.wsclient._postDocumentInterfaceConformanceResponse postDocumentInterfaceConformance(com.amazon.merchants.transport.wsclient._postDocumentInterfaceConformance body, javax.mail.internet.MimeMultipart document) throws java.rmi.RemoteException;
    public com.amazon.merchants.transport.wsclient._postDocumentUnconfirmedResponse postDocumentUnconfirmed(com.amazon.merchants.transport.wsclient._postDocumentUnconfirmed body, javax.mail.internet.MimeMultipart document) throws java.rmi.RemoteException;
    public com.amazon.merchants.transport.wsclient._postDocumentUnconfirmedInterfaceConformanceResponse postDocumentUnconfirmedInterfaceConformance(com.amazon.merchants.transport.wsclient._postDocumentUnconfirmedInterfaceConformance body, javax.mail.internet.MimeMultipart document) throws java.rmi.RemoteException;
    public com.amazon.merchants.transport.wsclient._getPendingDocumentInfoListGivenTimeWindowResponse getPendingDocumentInfoListGivenTimeWindow(com.amazon.merchants.transport.wsclient._getPendingDocumentInfoListGivenTimeWindow body) throws java.rmi.RemoteException;
    public com.amazon.merchants.transport.wsclient._getDocumentInfoInterfaceConformanceResponse getDocumentInfoInterfaceConformance(com.amazon.merchants.transport.wsclient._getDocumentInfoInterfaceConformance body) throws java.rmi.RemoteException;
}
