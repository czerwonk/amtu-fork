/*
 * Created on Apr 8, 2004
 *
 */
package com.amazon.merchants.transport.adapter;

import com.amazon.merchants.transport.model.*;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public interface MerchantsAtConnector
{
	BatchReferenceIdentifier postDocument(MerchantFeed document) throws MerchantsAtConnectorException;
	BatchReferenceIdentifier postDocument(MerchantFeed document, boolean isDeadEnd) throws MerchantsAtConnectorException;
	MerchantReport getDocument(DocumentIdentifier documentId) throws MerchantsAtConnectorException;
	ProcessingReport getProcessingReport(BatchReferenceIdentifier referenceId, boolean isFlatFile) throws MerchantsAtConnectorException;
	DocumentIdentifier [] getAllPendingDocumentIds(ReportTypeEnum messageType, boolean isFlatFile) throws MerchantsAtConnectorException;
	boolean acknowledgeDocumentDownload(MerchantReport [] reports) throws MerchantsAtConnectorException;
}
