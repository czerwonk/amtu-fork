/*
 * Created on May 8, 2004
 *
 */
package com.amazon.merchants.transport.preferences;

import java.io.IOException;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.amazon.merchants.DependencyInjectionManager;
import com.amazon.merchants.transport.logging.AuditLogger;


/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 * 
 */
public class TransportPreferences {

    private static final TransportPreferences _instance = new TransportPreferences();
    private final ITransportConfigurationStore configuration;
    private static final Log log = LogFactory.getLog(TransportPreferences.class);


    private TransportPreferences() {
        this.configuration = (ITransportConfigurationStore)DependencyInjectionManager.getInstance(ITransportConfigurationStore.class);
    }

    
    public static final TransportPreferences instance() {
        return _instance;
    }
    
    public void putPreference(TransportPreferenceEnum key, String value) {
        this.configuration.putString(key.getName(), value);
    }

    public void putPreferenceBoolean(TransportPreferenceEnum key, boolean value) {
        this.configuration.putBoolean(key.getName(), value);
    }

    public String getPreference(TransportPreferenceEnum key) {
        return this.configuration.getString(key.getName(), key.getDefaultValue());
    }

    public int getPreferenceInt(TransportPreferenceEnum key) {
        return this.configuration.getInt(key.getName(), Integer.parseInt(key.getDefaultValue()));
    }

    public long getPreferenceLong(TransportPreferenceEnum key) {
        return this.configuration.getLong(key.getName(), Long.parseLong(key.getDefaultValue()));
    }

    public double getPreferenceDouble(TransportPreferenceEnum key) {
        return this.configuration.getDouble(key.getName(), Double.parseDouble(key.getDefaultValue()));
    }

    public boolean getPreferenceBoolean(TransportPreferenceEnum key) {
        return this.configuration.getBoolean(key.getName(), Boolean.getBoolean(key.getDefaultValue()));
    }

    public void store(TransportConfiguration config) {
        this.configuration.putString(TransportPreferenceEnum.TRANSPORT_ROOT_FOLDER.getName(), config.getRootFolder());
        this.configuration.putInt(TransportPreferenceEnum.PROCESSING_REPORT_INTERVAL_MINUTES.getName(), config.getProcessingReportIntervalMinutes());
        this.configuration.putInt(TransportPreferenceEnum.SETTLEMENT_REPORT_INTERVAL_MINUTES.getName(), config.getSettlementReportIntervalMinutes());
        this.configuration.putInt(TransportPreferenceEnum.ORDER_REPORT_INTERVAL_MINUTES.getName(), config.getOrderReportIntervalMinutes());
        this.configuration.putInt(TransportPreferenceEnum.DISPATCH_INTERVAL_MINUTES.getName(), config.getDispatchIntervalMinutes());
        this.configuration.putInt(TransportPreferenceEnum.RETRIEVER_REPORT_TIMEOUT.getName(), config.getProcReportTimeoutMinutes());
        this.configuration.putInt(TransportPreferenceEnum.RETRIEVER_POST_TIMEOUT_POLL_INTERVAL.getName(), config.getProcReportPostTimeoutIntervalMinutes());
        this.configuration.putBoolean(TransportPreferenceEnum.IS_FLATFILE.getName(), config.isFlatFile());
        this.configuration.putString(TransportPreferenceEnum.SERVER_LOCATIONS.getName(), config.getServerLocations());
        this.configuration.putInt(TransportPreferenceEnum.MONITOR_SEND_PORT.getName(), config.getMonitorSendPort());
        this.configuration.putInt(TransportPreferenceEnum.MONITOR_RECEIVE_PORT.getName(), config.getMonitorReceivePort());
        this.configuration.putString(TransportPreferenceEnum.MONITOR_RECEIVE_HOST.getName(), config.getMonitorReceiveHost());
        this.configuration.putString(TransportPreferenceEnum.MONITOR_SMTP_SERVER.getName(), config.getMonitorSMTPServer());
        this.configuration.putString(TransportPreferenceEnum.MONITOR_NOTIFY_EMAIL.getName(), config.getMonitorNotifyEmail());

        this.saveChanges();
        
        UserAccountPreferences.instance().storeAll(config.getAccounts());
    }

    public TransportConfiguration getConfig() {
        TransportConfiguration config = new TransportConfiguration();
        
        config.setRootFolder(this.configuration.getString(TransportPreferenceEnum.TRANSPORT_ROOT_FOLDER.getName(), TransportPreferenceEnum.TRANSPORT_ROOT_FOLDER.getDefaultValue()));
        config.setProcessingReportIntervalMinutes(this.configuration.getInt(TransportPreferenceEnum.PROCESSING_REPORT_INTERVAL_MINUTES.getName(), Integer.parseInt(TransportPreferenceEnum.PROCESSING_REPORT_INTERVAL_MINUTES.getDefaultValue())));
        config.setSettlementReportIntervalMinutes(this.configuration.getInt(TransportPreferenceEnum.SETTLEMENT_REPORT_INTERVAL_MINUTES.getName(), Integer.parseInt(TransportPreferenceEnum.SETTLEMENT_REPORT_INTERVAL_MINUTES.getDefaultValue())));
        config.setOrderReportIntervalMinutes(this.configuration.getInt(TransportPreferenceEnum.ORDER_REPORT_INTERVAL_MINUTES.getName(), Integer.parseInt(TransportPreferenceEnum.ORDER_REPORT_INTERVAL_MINUTES.getDefaultValue())));
        config.setDispatchIntervalMinutes(this.configuration.getInt(TransportPreferenceEnum.DISPATCH_INTERVAL_MINUTES.getName(), Integer.parseInt(TransportPreferenceEnum.DISPATCH_INTERVAL_MINUTES.getDefaultValue())));
        config.setProcReportTimeoutMinutes(this.configuration.getInt(TransportPreferenceEnum.RETRIEVER_REPORT_TIMEOUT.getName(), Integer.parseInt(TransportPreferenceEnum.RETRIEVER_REPORT_TIMEOUT.getDefaultValue())));
        config.setProcReportPostTimeoutIntervalMinutes(this.configuration.getInt(TransportPreferenceEnum.RETRIEVER_POST_TIMEOUT_POLL_INTERVAL.getName(), Integer.parseInt(TransportPreferenceEnum.RETRIEVER_POST_TIMEOUT_POLL_INTERVAL.getDefaultValue())));
        config.setFlatFile(this.configuration.getBoolean(TransportPreferenceEnum.IS_FLATFILE.getName(), Boolean.getBoolean(TransportPreferenceEnum.IS_FLATFILE.getDefaultValue())));
        config.setServerLocations(this.configuration.getString(TransportPreferenceEnum.SERVER_LOCATIONS.getName(), TransportPreferenceEnum.SERVER_LOCATIONS.getDefaultValue()));
        config.setMonitorSendPort(this.configuration.getInt(TransportPreferenceEnum.MONITOR_SEND_PORT.getName(), Integer.parseInt(TransportPreferenceEnum.MONITOR_SEND_PORT.getDefaultValue())));
        config.setMonitorReceivePort(this.configuration.getInt(TransportPreferenceEnum.MONITOR_RECEIVE_PORT.getName(), Integer.parseInt(TransportPreferenceEnum.MONITOR_RECEIVE_PORT.getDefaultValue())));
        config.setMonitorReceiveHost(this.configuration.getString(TransportPreferenceEnum.MONITOR_RECEIVE_HOST.getName(), TransportPreferenceEnum.MONITOR_RECEIVE_HOST.getDefaultValue()));
        config.setMonitorSMTPServer(this.configuration.getString(TransportPreferenceEnum.MONITOR_SMTP_SERVER.getName(), TransportPreferenceEnum.MONITOR_SMTP_SERVER.getDefaultValue()));
        config.setMonitorNotifyEmail(this.configuration.getString(TransportPreferenceEnum.MONITOR_NOTIFY_EMAIL.getName(), TransportPreferenceEnum.MONITOR_NOTIFY_EMAIL.getDefaultValue()));
        
        return config;
    }

    private void saveChanges() {
        try {
            this.configuration.store();
        }
        catch (IOException ex) {
            log.debug(ExceptionUtils.getFullStackTrace(ex));
            AuditLogger.instance().logSeriousError("Could not save preferences.");
        }
    }
    
    public void reload() {
        try {
            this.configuration.reload();
        }
        catch (IOException ex) {
            log.debug(ExceptionUtils.getFullStackTrace(ex));
            AuditLogger.instance().logSeriousError("Could not load preferences.");
        }
    }

    public boolean preferencesExist() {
        return (this.configuration.getString(TransportPreferenceEnum.TRANSPORT_ROOT_FOLDER.getName(), null) != null);
    }

    public void removeAll() {
        try {
            this.configuration.clear();
        }
        catch (IOException ex) {
            // Do nothing - if backing store does not exist this is redundant
        }
    }
}