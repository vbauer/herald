package com.github.vbauer.herald.logger;

import com.github.vbauer.herald.core.BasicTest;
import com.github.vbauer.herald.logger.impl.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Vladislav Bauer
 */

public class LogFactoryTest extends BasicTest {
    
    private static final String LOG_NAME = "Logger Name";

    
    @Test
    public void testJavaUtilLogFactory() {
        final JavaUtilLogFactory logFactory = new JavaUtilLogFactory();
        Assert.assertNotNull(logFactory.createLogger(getClass()));
        Assert.assertNotNull(logFactory.createLogger(LOG_NAME));
        Assert.assertFalse(logFactory.isCompatible(null));
        Assert.assertTrue(logFactory.isCompatible(java.util.logging.Logger.class));
    }
    
    @Test
    public void testLog4j2LogFactory() {
        final Log4j2LogFactory logFactory = new Log4j2LogFactory();
        Assert.assertNotNull(logFactory.createLogger(getClass()));
        Assert.assertNotNull(logFactory.createLogger(LOG_NAME));
        Assert.assertFalse(logFactory.isCompatible(null));
        Assert.assertTrue(logFactory.isCompatible(org.apache.logging.log4j.Logger.class));
    }
    
    @Test
    public void testLog4jLogFactory() {
        final Log4jLogFactory logFactory = new Log4jLogFactory();
        Assert.assertNotNull(logFactory.createLogger(getClass()));
        Assert.assertNotNull(logFactory.createLogger(LOG_NAME));
        Assert.assertFalse(logFactory.isCompatible(null));
        Assert.assertTrue(logFactory.isCompatible(org.apache.log4j.Logger.class));
    }
    
    @Test
    public void testSlf4jLogFactory() {
        final Slf4jLogFactory logFactory = new Slf4jLogFactory();
        Assert.assertNotNull(logFactory.createLogger(getClass()));
        Assert.assertNotNull(logFactory.createLogger(LOG_NAME));
        Assert.assertFalse(logFactory.isCompatible(null));
        Assert.assertTrue(logFactory.isCompatible(org.slf4j.Logger.class));
        Assert.assertTrue(logFactory.isCompatible(ch.qos.logback.classic.Logger.class));
    }
    
    @Test
    public void testSlf4jExtLogFactory() {
        final Slf4jExtLogFactory logFactory = new Slf4jExtLogFactory();
        Assert.assertNotNull(logFactory.createLogger(getClass()));
        Assert.assertNotNull(logFactory.createLogger(LOG_NAME));
        Assert.assertFalse(logFactory.isCompatible(null));
        Assert.assertTrue(logFactory.isCompatible(org.slf4j.ext.XLogger.class));
    }

    @Test
    public void testCommonsLogFactory() {
        final CommonsLogFactory logFactory = new CommonsLogFactory();
        Assert.assertNotNull(logFactory.createLogger(getClass()));
        Assert.assertNotNull(logFactory.createLogger(LOG_NAME));
        Assert.assertFalse(logFactory.isCompatible(null));
        Assert.assertTrue(logFactory.isCompatible(org.apache.commons.logging.Log.class));
    }

    @Test
    public void testJBossLogFactory() {
        final JBossLogFactory logFactory = new JBossLogFactory();
        Assert.assertNotNull(logFactory.createLogger(getClass()));
        Assert.assertNotNull(logFactory.createLogger(LOG_NAME));
        Assert.assertFalse(logFactory.isCompatible(null));
        Assert.assertTrue(logFactory.isCompatible(org.jboss.logging.Logger.class));
    }

    @Test
    public void testSyslog4jLogFactory() {
        final Syslog4jLogFactory logFactory = new Syslog4jLogFactory();
        Assert.assertNotNull(logFactory.createLogger(getClass()));
        Assert.assertNotNull(logFactory.createLogger(Syslog4jLogFactory.DEFAULT_PROTOCOL));
        Assert.assertFalse(logFactory.isCompatible(null));
        Assert.assertTrue(logFactory.isCompatible(org.productivity.java.syslog4j.SyslogIF.class));
    }

    @Test
    public void testSyslog4jGraylogLogFactory() {
        final Syslog4jGraylogLogFactory logFactory = new Syslog4jGraylogLogFactory();
        Assert.assertNotNull(logFactory.createLogger(getClass()));
        Assert.assertNotNull(logFactory.createLogger(Syslog4jLogFactory.DEFAULT_PROTOCOL));
        Assert.assertFalse(logFactory.isCompatible(null));
        Assert.assertTrue(logFactory.isCompatible(org.graylog2.syslog4j.SyslogIF.class));
    }

}
