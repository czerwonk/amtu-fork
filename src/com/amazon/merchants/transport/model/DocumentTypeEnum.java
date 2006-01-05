/*
 * Created on Apr 8, 2004
 *
 */
package com.amazon.merchants.transport.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class DocumentTypeEnum extends MerchantDocumentEnum  implements Serializable, Comparable
{
	// Flat file and xml types
	public static final DocumentTypeEnum PRODUCT = new DocumentTypeEnum("PRODUCT","_POST_PRODUCT_DATA_","_POST_FLAT_FILE_LISTINGS_DATA_",10);
	public static final DocumentTypeEnum ADJUSTMENT = new DocumentTypeEnum("PAYMENT_ADJUSTMENT","_POST_PAYMENT_ADJUSTMENT_DATA_","_POST_FLAT_FILE_PAYMENT_ADJUSTMENT_DATA_",90);
	public static final DocumentTypeEnum FULFILLMENT = new DocumentTypeEnum("FULFILLMENT","_POST_ORDER_FULFILLMENT_DATA_","_POST_FLAT_FILE_FULFILLMENT_DATA_",80);
	public static final DocumentTypeEnum TEST_ORDER = new DocumentTypeEnum("TEST_ORDER","_POST_TEST_ORDERS_DATA_","_POST_FLAT_FILE_TEST_ORDER_DATA_",60);

	// XML only types
	public static final DocumentTypeEnum RELATIONSHIP = new DocumentTypeEnum("PRODUCT_RELATIONSHIP","_POST_PRODUCT_RELATIONSHIP_DATA_",30);
	public static final DocumentTypeEnum OVERRIDES = new DocumentTypeEnum("OVERRIDES","_POST_PRODUCT_OVERRIDES_DATA_",60);
	public static final DocumentTypeEnum IMAGE = new DocumentTypeEnum("IMAGE","_POST_PRODUCT_IMAGE_DATA_",40);
	public static final DocumentTypeEnum PRICING = new DocumentTypeEnum("PRICING","_POST_PRODUCT_PRICING_DATA_",20);
	public static final DocumentTypeEnum INVENTORY = new DocumentTypeEnum("INVENTORY","_POST_INVENTORY_AVAILABILITY_DATA_",50);
	public static final DocumentTypeEnum ORDER_ACKNOWLEDGEMENT = new DocumentTypeEnum("ORDER_ACKNOWLEDGEMENT","_POST_ORDER_ACKNOWLEDGEMENT_DATA_",70);
	public static final DocumentTypeEnum STORE = new DocumentTypeEnum("STORE","_POST_STORE_DATA_",200);
    public static final DocumentTypeEnum ACES = new DocumentTypeEnum("ACES","_POST_ACES_DATA_",300);
    public static final DocumentTypeEnum PIES = new DocumentTypeEnum("PIES","_POST_PIES_DATA_",400);
    public static final DocumentTypeEnum ITEM = new DocumentTypeEnum("ITEM","_POST_ITEM_DATA_",500);

	private int feedPrecedence;

	/**
	 * Enum made private - users should not create their own
	 */
	private DocumentTypeEnum(String name, String xmlCode, String flatFileCode, int precedence)
	{
		super(name);
		this.xmlCode = xmlCode;
		this.flatFileCode = flatFileCode;
		this.feedPrecedence = precedence;
	}

	private DocumentTypeEnum(String name, String xmlCode, int precedence)
	{
		this(name,xmlCode,null, precedence);
	}
	
	public static DocumentTypeEnum getEnum(String documentType) {
	  return (DocumentTypeEnum) getEnum(DocumentTypeEnum.class, documentType);
	}
 
	public static Map getEnumMap() {
	  return getEnumMap(DocumentTypeEnum.class);
	}
 
	public static List getEnumList() {
	  return getEnumList(DocumentTypeEnum.class);
	}
 
	public static Iterator iterator() {
	  return iterator(DocumentTypeEnum.class);
	}
	/*
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object arg0)
	{
		return feedPrecedence - ((DocumentTypeEnum)arg0).getFeedPrecedence(); 
	}

	/**
	 * @return
	 */
	int getFeedPrecedence()
	{
		return feedPrecedence;
	}

	/**
	 * @param s
	 */
	void setFeedPrecedence(int s)
	{
		feedPrecedence = s;
	}

}
