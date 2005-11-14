/**
 * FrequencyType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.amazon.merchants.transport.wsclient;

public class FrequencyType implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected FrequencyType(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String __30_MINUTES_ = "_30_MINUTES_";
    public static final java.lang.String __1_HOUR_ = "_1_HOUR_";
    public static final java.lang.String __4_HOURS_ = "_4_HOURS_";
    public static final java.lang.String __8_HOURS_ = "_8_HOURS_";
    public static final java.lang.String __1_DAY_ = "_1_DAY_";
    public static final java.lang.String __15_DAYS_ = "_15_DAYS_";
    public static final java.lang.String __30_DAYS_ = "_30_DAYS_";
    public static final FrequencyType _30_MINUTES_ = new FrequencyType(__30_MINUTES_);
    public static final FrequencyType _1_HOUR_ = new FrequencyType(__1_HOUR_);
    public static final FrequencyType _4_HOURS_ = new FrequencyType(__4_HOURS_);
    public static final FrequencyType _8_HOURS_ = new FrequencyType(__8_HOURS_);
    public static final FrequencyType _1_DAY_ = new FrequencyType(__1_DAY_);
    public static final FrequencyType _15_DAYS_ = new FrequencyType(__15_DAYS_);
    public static final FrequencyType _30_DAYS_ = new FrequencyType(__30_DAYS_);
    public java.lang.String getValue() { return _value_;}
    public static FrequencyType fromValue(java.lang.String value)
          throws java.lang.IllegalStateException {
        FrequencyType enum = (FrequencyType)
            _table_.get(value);
        if (enum==null) throw new java.lang.IllegalStateException();
        return enum;
    }
    public static FrequencyType fromString(java.lang.String value)
          throws java.lang.IllegalStateException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
}
