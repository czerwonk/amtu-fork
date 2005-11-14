/**
 * 
 */
package com.amazon.merchants.transport.adapter.impl;

import com.amazon.merchants.transport.adapter.MerchantsAtConnector;
import com.amazon.merchants.transport.adapter.MerchantsAtConnectorException;
import com.amazon.merchants.transport.model.BatchReferenceIdentifier;
import com.amazon.merchants.transport.model.DocumentIdentifier;
import com.amazon.merchants.transport.model.MerchantFeed;
import com.amazon.merchants.transport.model.MerchantReport;
import com.amazon.merchants.transport.model.ProcessingReport;
import com.amazon.merchants.transport.model.ReportTypeEnum;

/**
 * @author smarkle
 * This file is probably going to have to be the uber-handler for all AWS weirdness.  The rest
 * of the application shouldn't have to change.
 *
 */
public class MerchantsAtConnectorAWSImpl implements MerchantsAtConnector {

    /* (non-Javadoc)
     * @see com.amazon.merchants.transport.adapter.MerchantsAtConnector#postDocument(com.amazon.merchants.transport.model.MerchantFeed)
     */
    public BatchReferenceIdentifier postDocument(MerchantFeed document)
            throws MerchantsAtConnectorException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.amazon.merchants.transport.adapter.MerchantsAtConnector#postDocument(com.amazon.merchants.transport.model.MerchantFeed, boolean)
     */
    public BatchReferenceIdentifier postDocument(MerchantFeed document,
            boolean isDeadEnd) throws MerchantsAtConnectorException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.amazon.merchants.transport.adapter.MerchantsAtConnector#getDocument(com.amazon.merchants.transport.model.DocumentIdentifier)
     */
    public MerchantReport getDocument(DocumentIdentifier documentId)
            throws MerchantsAtConnectorException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.amazon.merchants.transport.adapter.MerchantsAtConnector#getProcessingReport(com.amazon.merchants.transport.model.BatchReferenceIdentifier, boolean)
     */
    public ProcessingReport getProcessingReport(
            BatchReferenceIdentifier referenceId, boolean isFlatFile)
            throws MerchantsAtConnectorException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.amazon.merchants.transport.adapter.MerchantsAtConnector#getAllPendingDocumentIds(com.amazon.merchants.transport.model.ReportTypeEnum, boolean)
     */
    public DocumentIdentifier[] getAllPendingDocumentIds(
            ReportTypeEnum messageType, boolean isFlatFile)
            throws MerchantsAtConnectorException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.amazon.merchants.transport.adapter.MerchantsAtConnector#acknowledgeDocumentDownload(com.amazon.merchants.transport.model.MerchantReport[])
     */
    public boolean acknowledgeDocumentDownload(MerchantReport[] reports)
            throws MerchantsAtConnectorException {
        // TODO Auto-generated method stub
        return false;
    }

}
