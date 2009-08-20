package com.amazon.merchants.transport.preferences;

import java.io.IOException;


/**
 * @author Daniel Czerwonk
 *
 */
public interface ITransportConfigurationStore {

    String getString(String key, String defaultValue);
    
    int getInt(String key, int defaultValue);
    
    long getLong(String key, long defaultValue);
    
    boolean getBoolean(String key, boolean defaultValue);
    
    double getDouble(String key, double defaultValue);
    
    void putString(String key, String value);
    
    void putInt(String key, int value);
    
    void putLong(String key, long value);
    
    void putBoolean(String key, boolean value);
    
    void putDouble(String key, double value);
    
    void store() throws IOException;
    
    void reload() throws IOException;
    
    void clear() throws IOException;
}