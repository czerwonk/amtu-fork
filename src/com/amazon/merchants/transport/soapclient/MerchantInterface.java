/**
 * MerchantInterface.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */
package com.amazon.merchants.transport.soapclient;

public interface MerchantInterface extends java.rmi.Remote
{
	public String getDocument(
		Merchant merchant,
		String documentIdentifier,
		org.apache.axis.holders.OctetStreamHolder doc)
		throws
			java.rmi.RemoteException,
			MerchantInterface_getDocument_orgIdooxWaspSoapFaultException_Fault;
			
	public String getDocumentInterfaceConformance(
		Merchant merchant,
		String documentIdentifier,
		org.apache.axis.holders.OctetStreamHolder doc)
		throws
			java.rmi.RemoteException,
			MerchantInterface_getDocumentInterfaceConformance_orgIdooxWaspSoapFaultException_Fault;
			
	public ArrayOfDocumentDownloadAckStatus postDocumentDownloadAck(
		Merchant merchant,
		ArrayOfstring documentIdentifierArray)
		throws
			java.rmi.RemoteException,
			MerchantInterface_postDocumentDownloadAck_orgIdooxWaspSoapFaultException_Fault;
			
	public DocumentSubmissionResponse postDocument(
		Merchant merchant,
		String messageType,
		org.apache.axis.attachments.OctetStream doc)
		throws
			java.rmi.RemoteException,
			MerchantInterface_postDocument_orgIdooxWaspSoapFaultException_Fault;
			
	public DocumentSubmissionResponse postDocumentInterfaceConformance(
		Merchant merchant,
		String messageType,
		org.apache.axis.attachments.OctetStream doc)
		throws
			java.rmi.RemoteException,
			MerchantInterface_postDocumentInterfaceConformance_orgIdooxWaspSoapFaultException_Fault;
			
	public ArrayOfMerchantDocumentInfo getLastNDocumentInfo(
		Merchant merchant,
		String messageType,
		int howMany)
		throws
			java.rmi.RemoteException,
			MerchantInterface_getLastNDocumentInfo_orgIdooxWaspSoapFaultException_Fault;
			
	public ArrayOfMerchantDocumentInfo getLastNPendingDocumentInfo(
		Merchant merchant,
		String messageType,
		int howMany)
		throws
			java.rmi.RemoteException,
			MerchantInterface_getLastNPendingDocumentInfo_orgIdooxWaspSoapFaultException_Fault;
			
	public DocumentProcessingInfo getDocumentProcessingStatus(
		Merchant merchant,
		long documentTransactionIdentifier)
		throws
			java.rmi.RemoteException,
			MerchantInterface_getDocumentProcessingStatus_orgIdooxWaspSoapFaultException_Fault;
			
	public ArrayOfMerchantDocumentInfo getAllPendingDocumentInfo(
		Merchant merchant,
		String messageType)
		throws
			java.rmi.RemoteException,
			MerchantInterface_getAllPendingDocumentInfo_orgIdooxWaspSoapFaultException_Fault;
			
	public ArrayOfReportInfo getLastNReportInfo(
		Merchant merchant,
		String messageType,
		int numberOfReports)
		throws
			java.rmi.RemoteException,
			MerchantInterface_getLastNReportInfo_orgIdooxWaspSoapFaultException_Fault;
			
	public ArrayOfSummaryInfo getLastNDocumentProcessingStatuses(
		Merchant merchant,
		int numberOfStatuses,
		String uploadType)
		throws
			java.rmi.RemoteException,
			MerchantInterface_getLastNDocumentProcessingStatuses_orgIdooxWaspSoapFaultException_Fault;
			
	public MerchantInfo getMerchantInfoFromCustomerID(String customerID)
		throws
			java.rmi.RemoteException,
			MerchantInterface_getMerchantInfoFromCustomerID_orgIdooxWaspSoapFaultException_Fault;
}
