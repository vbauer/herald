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
        final JavaUtilLogFactory javaUtilLogFactory = new JavaUtilLogFactory();
        Assert.assertNotNull(javaUtilLogFactory.createLogger(getClass()));
        Assert.assertNotNull(javaUtilLogFactory.createLogger(LOG_NAME));
        Assert.assertFalse(javaUtilLogFactory.isCompatible(null));
        Assert.assertTrue(javaUtilLogFactory.isCompatible(java.util.logging.Logger.class));
    }
    
    @Test
    public void testLog4j2LogFactory() {
        final Log4j2LogFactory log4j2LogFactory = new Log4j2LogFactory();
        Assert.assertNotNull(log4j2LogFactory.createLogger(getClass()));
        Assert.assertNotNull(log4j2LogFactory.createLogger(LOG_NAME));
        Assert.assertFalse(log4j2LogFactory.isCompatible(null));
        Assert.assertTrue(log4j2LogFactory.isCompatible(org.apache.logging.log4j.Logger.class));
    }
    
    @Test
    public void testLog4jLogFactory() {
        final Log4jLogFactory log4jLogFactory = new Log4jLogFactory();
        Assert.assertNotNull(log4jLogFactory.createLogger(getClass()));
        Assert.assertNotNull(log4jLogFactory.createLogger(LOG_NAME));
        Assert.assertFalse(log4jLogFactory.isCompatible(null));
        Assert.assertTrue(log4jLogFactory.isCompatible(org.apache.log4j.Logger.class));
    }
    
    @Test
    public void testSlf4jLogFactory() {
        final Slf4jLogFactory slf4jLogFactory = new Slf4jLogFactory();
        Assert.assertNotNull(slf4jLogFactory.createLogger(getClass()));
        Assert.assertNotNull(slf4jLogFactory.createLogger(LOG_NAME));
        Assert.assertFalse(slf4jLogFactory.isCompatible(null));
        Assert.assertTrue(slf4jLogFactory.isCompatible(org.slf4j.Logger.class));
        Assert.assertTrue(slf4jLogFactory.isCompatible(ch.qos.logback.classic.Logger.class));
    }
    
    @Test
    public void testSlf4jExtLogFactory() {
        final Slf4jExtLogFactory slf4jExtLogFactory = new Slf4jExtLogFactory();
        Assert.assertNotNull(slf4jExtLogFactory.createLogger(getClass()));
        Assert.assertNotNull(slf4jExtLogFactory.createLogger(LOG_NAME));
        Assert.assertFalse(slf4jExtLogFactory.isCompatible(null));
        Assert.assertTrue(slf4jExtLogFactory.isCompatible(org.slf4j.ext.XLogger.class));
    }

    @Test
    public void testCommonsLogFactory() {
        final CommonsLogFactory commonsLogFactory = new CommonsLogFactory();
        Assert.assertNotNull(commonsLogFactory.createLogger(getClass()));
        Assert.assertNotNull(commonsLogFactory.createLogger(LOG_NAME));
        Assert.assertFalse(commonsLogFactory.isCompatible(null));
        Assert.assertTrue(commonsLogFactory.isCompatible(org.apache.commons.logging.Log.class));
    }

}
