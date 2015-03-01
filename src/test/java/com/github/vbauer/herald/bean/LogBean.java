package com.github.vbauer.herald.bean;

import com.github.vbauer.herald.annotation.Log;
import org.springframework.stereotype.Component;

/**
 * @author Vladislav Bauer
 */

@Component
public class LogBean {

    @Log
    private static java.util.logging.Logger staticJavaUtilLogger;

    @Log
    private java.util.logging.Logger javaUtilLogger;

    @Log
    private org.apache.commons.logging.Log commonsLoggingLogger;

    @Log
    private ch.qos.logback.classic.Logger logbackLogger;

    @Log
    private org.slf4j.Logger slf4jLogger;

    @Log
    private org.slf4j.ext.XLogger slf4jExtLogger;

    @Log
    private org.apache.log4j.Logger log4jLogger;

    @Log
    private org.apache.logging.log4j.Logger log4j2Logger;

    @Log
    private org.jboss.logging.Logger jbossLogger;;

    @Log
    private org.productivity.java.syslog4j.SyslogIF syslog4jLogger;


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

}
