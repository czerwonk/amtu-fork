package com.amazon.merchants.transport.preferences;

import java.io.IOException;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;


/**
 * @author Daniel Czerwonk
 *
 */
public class PreferencesTransportConfigurationStore implements ITransportConfigurationStore {

    private final Preferences preferences;
    
    
    /**
     * Creates a new instance of PreferencesTransportConfigurationStore
     */
    public PreferencesTransportConfigurationStore() {
        super();
        
        this.preferences = Preferences.systemNodeForPackage(TransportPreferences.class);
    }
    

    /* (non-Javadoc)
     * @see com.amazon.merchants.transport.preferences.ITansportConfigurationStore#clear()
     */
    public void clear() throws IOException {
        try {
            String[] keys = this.preferences.keys();
            
            for (int i = 0; i < keys.length; i++) {
                this.preferences.remove(keys[i]);
            }   
        }
        catch (BackingStoreException ex) {
            throw new IOException(ex.getMessage(), ex);
        }
    }

    /* (non-Javadoc)
     * @see com.amazon.merchants.transport.preferences.ITansportConfigurationStore#getBoolean(java.lang.String)
     */
    public boolean getBoolean(String key, boolean defaultValue) {
        return this.preferences.getBoolean(key, defaultValue);
    }

    /* (non-Javadoc)
     * @see com.amazon.merchants.transport.preferences.ITansportConfigurationStore#getInt(java.lang.String)
     */
    public int getInt(String key, int defaultValue) {
        return this.preferences.getInt(key, defaultValue);
    }

    /* (non-Javadoc)
     * @see com.amazon.merchants.transport.preferences.ITansportConfigurationStore#getLong(java.lang.String)
     */
    public long getLong(String key, long defaultValue) {
        return this.preferences.getLong(key, defaultValue);
    }

    /* (non-Javadoc)
     * @see com.amazon.merchants.transport.preferences.ITansportConfigurationStore#getString(java.lang.String)
     */
    public String getString(String key, String defaultValue) {
        return this.preferences.get(key, defaultValue);
    }
    
    
    /* (non-Javadoc)
     * @see com.amazon.merchants.transport.preferences.ITansportConfigurationStore#getDouble(java.lang.String, double)
     */
    public double getDouble(String key, double defaultValue) {
        return this.preferences.getDouble(key, defaultValue);
    }

    /* (non-Javadoc)
     * @see com.amazon.merchants.transport.preferences.ITansportConfigurationStore#putBoolean(java.lang.String, boolean)
     */
    public void putBoolean(String key, boolean value) {
        this.preferences.putBoolean(key, value);
    }

    /* (non-Javadoc)
     * @see com.amazon.merchants.transport.preferences.ITansportConfigurationStore#putInt(java.lang.String, int)
     */
    public void putInt(String key, int value) {
        this.preferences.putInt(key, value);
    }

    /* (non-Javadoc)
     * @see com.amazon.merchants.transport.preferences.ITansportConfigurationStore#putLong(java.lang.String, long)
     */
    public void putLong(String key, long value) {
        this.preferences.putLong(key, value);
    }

    /* (non-Javadoc)
     * @see com.amazon.merchants.transport.preferences.ITansportConfigurationStore#putString(java.lang.String, java.lang.String)
     */
    public void putString(String key, String value) {
        this.preferences.put(key, value);
    }

    /* (non-Javadoc)
     * @see com.amazon.merchants.transport.preferences.ITansportConfigurationStore#putDouble(java.lang.String, double)
     */
    public void putDouble(String key, double value) {
        this.preferences.putDouble(key, value);
    }

    /* (non-Javadoc)
     * @see com.amazon.merchants.transport.preferences.ITansportConfigurationStore#reload()
     */
    public void reload() throws IOException {
        try {
            this.preferences.sync();
        }
        catch (BackingStoreException ex) {
            throw new IOException(ex.getMessage(), ex);
        }
    }

    /* (non-Javadoc)
     * @see com.amazon.merchants.transport.preferences.ITansportConfigurationStore#store()
     */
    public void store() throws IOException {
        try {
            this.preferences.sync();
        }
        catch (BackingStoreException ex) {
            throw new IOException(ex.getMessage(), ex);
        }
    }
}
