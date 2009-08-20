package com.amazon.merchants.transport.preferences;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;


/**
 * @author Daniel Czerwonk
 *
 */
public class PropertiesTransportConfigurationStore implements ITransportConfigurationStore {

    private final File file;
    private final Properties properties;
    
    
    /**
     * Creates a new instance of PropertiesTransportConfigurationStore
     */
    public PropertiesTransportConfigurationStore() {
        super();
        
        this.file = new File("config.xml");
        this.properties = new Properties();
    }
    
    
    /* (non-Javadoc)
     * @see com.amazon.merchants.transport.preferences.ITransportConfigurationStore#clear()
     */
    public void clear() throws IOException {
        this.properties.clear();
    }

    /* (non-Javadoc)
     * @see com.amazon.merchants.transport.preferences.ITransportConfigurationStore#getBoolean(java.lang.String, boolean)
     */
    public boolean getBoolean(String key, boolean defaultValue) {
        return Boolean.parseBoolean(this.properties.getProperty(key, Boolean.toString(defaultValue)));
    }

    /* (non-Javadoc)
     * @see com.amazon.merchants.transport.preferences.ITransportConfigurationStore#getDouble(java.lang.String, double)
     */
    public double getDouble(String key, double defaultValue) {
        return Double.parseDouble(this.properties.getProperty(key, Double.toString(defaultValue)));
    }

    /* (non-Javadoc)
     * @see com.amazon.merchants.transport.preferences.ITransportConfigurationStore#getInt(java.lang.String, int)
     */
    public int getInt(String key, int defaultValue) {
        return Integer.parseInt(this.properties.getProperty(key, Integer.toString(defaultValue)));
    }

    /* (non-Javadoc)
     * @see com.amazon.merchants.transport.preferences.ITransportConfigurationStore#getLong(java.lang.String, long)
     */
    public long getLong(String key, long defaultValue) {
        return Long.parseLong(this.properties.getProperty(key, Long.toString(defaultValue)));
    }

    /* (non-Javadoc)
     * @see com.amazon.merchants.transport.preferences.ITransportConfigurationStore#getString(java.lang.String, java.lang.String)
     */
    public String getString(String key, String defaultValue) {
        return this.properties.getProperty(key, defaultValue);
    }

    /* (non-Javadoc)
     * @see com.amazon.merchants.transport.preferences.ITransportConfigurationStore#putBoolean(java.lang.String, boolean)
     */
    public void putBoolean(String key, boolean value) {
        this.properties.put(key, Boolean.toString(value));
    }

    /* (non-Javadoc)
     * @see com.amazon.merchants.transport.preferences.ITransportConfigurationStore#putDouble(java.lang.String, double)
     */
    public void putDouble(String key, double value) {
        this.properties.put(key, Double.toString(value));
    }

    /* (non-Javadoc)
     * @see com.amazon.merchants.transport.preferences.ITransportConfigurationStore#putInt(java.lang.String, int)
     */
    public void putInt(String key, int value) {
        this.properties.put(key, Integer.toString(value));    
    }

    /* (non-Javadoc)
     * @see com.amazon.merchants.transport.preferences.ITransportConfigurationStore#putLong(java.lang.String, long)
     */
    public void putLong(String key, long value) {
        this.properties.put(key, Long.toString(value));
    }

    /* (non-Javadoc)
     * @see com.amazon.merchants.transport.preferences.ITransportConfigurationStore#putString(java.lang.String, java.lang.String)
     */
    public void putString(String key, String value) {
        this.properties.put(key, value);
    }

    /* (non-Javadoc)
     * @see com.amazon.merchants.transport.preferences.ITransportConfigurationStore#store()
     */
    public void store() throws IOException {
        OutputStream stream = null;
        
        try {
            stream = new FileOutputStream(this.file);
            
            this.properties.storeToXML(stream, "");
        }
        finally {
            if (stream != null) {
                try {
                    stream.close();    
                }
                catch (IOException ex) {
                    // not catching this exception would hide exceptions thrown in surrounding try block
                }
            }
        }
    }

    /* (non-Javadoc)
     * @see com.amazon.merchants.transport.preferences.ITransportConfigurationStore#reload()
     */
    public void reload() throws IOException {
        if (!this.file.exists()) {
            return;
        }
        
        InputStream stream = null;
        
        try {
            stream = new FileInputStream(this.file);
            
            this.properties.loadFromXML(stream);
        }
        finally {
            if (stream != null) {
                try {
                    stream.close();    
                }
                catch (IOException ex) {
                    // not catching this exception would hide exceptions thrown in surrounding try block
                }
            }
        }
    }
}