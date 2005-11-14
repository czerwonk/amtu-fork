/**
 * HelpRequest_HelpType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.amazon.merchants.transport.wsclient;

public class HelpRequest_HelpType implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected HelpRequest_HelpType(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _Operation = "Operation";
    public static final java.lang.String _ResponseGroup = "ResponseGroup";
    public static final HelpRequest_HelpType Operation = new HelpRequest_HelpType(_Operation);
    public static final HelpRequest_HelpType ResponseGroup = new HelpRequest_HelpType(_ResponseGroup);
    public java.lang.String getValue() { return _value_;}
    public static HelpRequest_HelpType fromValue(java.lang.String value)
          throws java.lang.IllegalStateException {
        HelpRequest_HelpType enum = (HelpRequest_HelpType)
            _table_.get(value);
        if (enum==null) throw new java.lang.IllegalStateException();
        return enum;
    }
    public static HelpRequest_HelpType fromString(java.lang.String value)
          throws java.lang.IllegalStateException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
}
