package com.github.vbauer.herald.bean;

import com.github.vbauer.herald.annotation.Log;
import org.springframework.stereotype.Component;

/**
 * @author Vladislav Bauer
 */

@Log
@Component
public class ClassLogBean {

    public static final int DEF_NOT_LOGGER_VALUE = 5;


    private static java.util.logging.Logger staticJavaUtilLogger;

    private java.util.logging.Logger javaUtilLogger;

    private org.apache.commons.logging.Log commonsLoggingLogger;

    private ch.qos.logback.classic.Logger logbackLogger;

    private org.slf4j.Logger slf4jLogger;

    private org.slf4j.ext.XLogger slf4jExtLogger;

    private org.apache.log4j.Logger log4jLogger;

    private org.apache.logging.log4j.Logger log4j2Logger;

    private org.jboss.logging.Logger jbossLogger;;

    private int notLogger = DEF_NOT_LOGGER_VALUE;


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

    public int getNotLogger() {
        return notLogger;
    }

    public void setNotLogger(final int value) {
        notLogger = value;
    }

}
