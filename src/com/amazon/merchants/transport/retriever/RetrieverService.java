/*
 * Created on May 6, 2004
 *
 */
package com.amazon.merchants.transport.retriever;

import java.io.File;

import com.amazon.merchants.transport.model.BatchReferenceIdentifier;
import com.amazon.merchants.transport.model.DocumentIdentifier;
import com.amazon.merchants.transport.model.MerchantAccount;
import com.amazon.merchants.transport.model.MerchantReport;
import com.amazon.merchants.transport.model.ProcessingReport;
import com.amazon.merchants.transport.model.ReportTypeEnum;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public interface RetrieverService
{
	MerchantReport [] getPendingReports(ReportTypeEnum reportType, MerchantAccount account, boolean flatFile) throws RetrieverException;
	ProcessingReport [] getProcessingReports(BatchReferenceIdentifier [] batchReferences, MerchantAccount account, boolean flatFile) throws RetrieverException;
	ProcessingReport getProcessingReport(BatchReferenceIdentifier batchReferences, MerchantAccount account, boolean flatFile) throws RetrieverException;
	MerchantReport getDocument(DocumentIdentifier documentID, MerchantAccount account, boolean flatFile) throws RetrieverException;
	void retrieveOutstandingProcessingReports(MerchantAccount account,File incomingDirectory, boolean flatFile) throws RetrieverException;
	void retrieveAllPendingReports(ReportTypeEnum reportType, MerchantAccount account,File incomingDirectory, boolean flatFile) throws RetrieverException;
}
