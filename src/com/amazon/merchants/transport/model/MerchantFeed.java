/*
 * Created on Apr 17, 2004
 *
 */
package com.amazon.merchants.transport.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.EqualsBuilder;

import com.amazon.merchants.transport.TransportConstants;
import com.amazon.merchants.util.RandomGUID;
import com.amazon.merchants.util.file.FileUtil;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class MerchantFeed extends MerchantDocument implements Comparable, Statusable
{
	String feedId;			// Unique key for db only
	BatchReferenceIdentifier batchReference;
	FeedStatusEnum status;
	Date creationDate;
	Date timeSubmitted;
	String failureReason;
	
	public MerchantFeed(){}

	public MerchantFeed(File file, DocumentTypeEnum documentType) throws FileNotFoundException
	{
		setDocument(file,documentType);
		generateFeedId();
	}

	private void setDocument(File file, DocumentTypeEnum documentType) throws FileNotFoundException
	{
		setDocument(file);
		this.documentType = documentType;
		this.flatFile = FileUtil.getExtension(file.getName()).equals(TransportConstants.FLAT_FILE_SUFFIX);
		this.creationDate = new Date(file.lastModified());
	}

	/**
	 * Overrides the file listed. Note, this does NOT change the
	 * document type, flat file boolean or creation date. Mainly to
	 * be used if files are preprocessed.
	 * 
	 * @param file
	 * @throws FileNotFoundException
	 */
	public void setDocument(File file) throws FileNotFoundException
	{
		Validate.notNull(file,"File must not be null");
		if (!file.canRead())
		{
			throw new FileNotFoundException("File "+file.getAbsolutePath()+" could not be found or is inaccessible.");
		}
		document = new DataHandler(new FileDataSource(file));
		savedFileName = file.getAbsolutePath();		
	}

	/**
	 * @return
	 */
	public BatchReferenceIdentifier getBatchReference()
	{
		return batchReference;
	}

	/**
	 * @param identifier
	 */
	public void setBatchReference(BatchReferenceIdentifier identifier)
	{
		batchReference = identifier;
	}

	/**
	 * @return
	 */
	public Date getCreationDate()
	{
		return creationDate;
	}

	/**
	 * @param date
	 */
	public void setCreationDate(Date date)
	{
		creationDate = date;
	}

	/*
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object arg0)
	{
		MerchantFeed arg = (MerchantFeed)arg0;
		int compare = getDocumentType().compareTo(arg.getDocumentType());
		
		if (compare==0)
		{
			compare = (int)(getCreationDate().getTime() - arg.getCreationDate().getTime());
			
			if (compare==0)
			{
				compare = getDocumentName().compareTo(arg.getDocumentName());
			}
		}
		return compare;
	}
	/**
	 * @return
	 */
	public FeedStatusEnum getStatus()
	{
		return status;
	}

	/**
	 * @param status
	 */
	public void setStatus(FeedStatusEnum status)
	{
		this.status = status;
	}

	/**
	 * @return
	 */
	public String getFailureReason()
	{
		return failureReason;
	}

	/**
	 * @param string
	 */
	public void setFailureReason(String string)
	{
		failureReason = string;
	}

	private void generateFeedId()
	{
		//feedId = Long.toString(new Date().getTime())+Integer.toHexString(getDocumentName().hashCode());
		feedId = new RandomGUID().toString();
	}
	/**
	 * @return
	 */
	public String getFeedId()
	{
		return feedId;
	}

	/**
	 * @param string
	 */
	public void setFeedId(String string)
	{
		feedId = string;
	}
	/**
	 * @return
	 */
	public Date getTimeSubmitted()
	{
		return timeSubmitted;
	}

	/**
	 * @param date
	 */
	public void setTimeSubmitted(Date date)
	{
		timeSubmitted = date;
	}
	
	

	/*
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object arg0)
	{
		if (arg0==null) return false;
		if (super.equals(arg0)) return true;
		MerchantFeed other = (MerchantFeed)arg0;
		return new EqualsBuilder().
			append(feedId,other.getFeedId()).
			append(batchReference,other.getBatchReference()).
			append(creationDate,other.getCreationDate()).
			append(failureReason,other.getFailureReason()).
			append(status,other.getStatus()).
			append(timeSubmitted,other.getTimeSubmitted()).
			append(documentType,other.getDocumentType()).
			append(flatFile,other.isFlatFile()).
			append(getDocumentName(),other.getDocumentName()).isEquals();		
	}

}
