package com.github.vbauer.herald.bean;

import com.github.vbauer.herald.annotation.Log;
import com.github.vbauer.herald.logger.impl.Syslog4jGraylogLogFactory;
import com.github.vbauer.herald.logger.impl.Syslog4jLogFactory;
import org.springframework.stereotype.Component;

/**
 * @author Vladislav Bauer
 */

@Component
public class NamedLogBean {

    private static final String LOGGER_NAME = "logger";


    @Log(LOGGER_NAME)
    private static java.util.logging.Logger staticJavaUtilLogger;

    @Log(LOGGER_NAME)
    private java.util.logging.Logger javaUtilLogger;

    @Log(LOGGER_NAME)
    private org.apache.commons.logging.Log commonsLoggingLogger;

    @Log(LOGGER_NAME)
    private ch.qos.logback.classic.Logger logbackLogger;

    @Log(LOGGER_NAME)
    private org.slf4j.Logger slf4jLogger;

    @Log(LOGGER_NAME)
    private org.apache.log4j.Logger log4jLogger;

    @Log(LOGGER_NAME)
    private org.slf4j.ext.XLogger slf4jExtLogger;

    @Log(LOGGER_NAME)
    private org.apache.logging.log4j.Logger log4j2Logger;

    @Log(LOGGER_NAME)
    private org.jboss.logging.Logger jbossLogger;;

    @Log(Syslog4jLogFactory.DEFAULT_PROTOCOL)
    private org.productivity.java.syslog4j.SyslogIF syslog4jLogger;

    @Log(Syslog4jGraylogLogFactory.DEFAULT_PROTOCOL)
    private org.graylog2.syslog4j.SyslogIF syslog4jGraylogLogger;

    @Log(LOGGER_NAME)
    private org.fluentd.logger.FluentLogger fluentLogger;

    
    public static java.util.logging.Logger getStaticJavaUtilLogger() {
        return staticJavaUtilLogger;
    }

    public java.util.logging.Logger getJavaUtilLogger() {
        return javaUtilLogger;
    }

    public org.apache.commons.logging.Log getCommonsLoggingLogger() {
        return commonsLoggingLogger;
    }

    public ch.qos.logback.classic.Logger getLogbackLogger() {
        return logbackLogger;
    }

    public org.slf4j.Logger getSlf4jLogger() {
        return slf4jLogger;
    }

    public org.slf4j.ext.XLogger getSlf4jExtLogger() {
        return slf4jExtLogger;
    }

    public org.apache.log4j.Logger getLog4jLogger() {
        return log4jLogger;
    }

    public org.apache.logging.log4j.Logger getLog4j2Logger() {
        return log4j2Logger;
    }

    public org.jboss.logging.Logger getJBossLogger() {
        return jbossLogger;
    }

    public org.productivity.java.syslog4j.SyslogIF getSyslog4jLogger() {
        return syslog4jLogger;
    }

    public org.graylog2.syslog4j.SyslogIF getSyslog4jGraylogLogger() {
        return syslog4jGraylogLogger;
    }

    public org.fluentd.logger.FluentLogger getFluentLogger() {
        return fluentLogger;
    }
    
}
