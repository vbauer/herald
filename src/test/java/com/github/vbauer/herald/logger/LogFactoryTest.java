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
    public void testLogFactories() {
        checkLogFactory(new JavaUtilLogFactory(), LOG_NAME, java.util.logging.Logger.class);
        checkLogFactory(new Log4j2LogFactory(), LOG_NAME, org.apache.logging.log4j.Logger.class);
        checkLogFactory(new Log4jLogFactory(), LOG_NAME, org.apache.log4j.Logger.class);
        checkLogFactory(new Slf4jLogFactory(), LOG_NAME, org.slf4j.Logger.class);
        checkLogFactory(new Slf4jLogFactory(), LOG_NAME, ch.qos.logback.classic.Logger.class);
        checkLogFactory(new Slf4jExtLogFactory(), LOG_NAME, org.slf4j.ext.XLogger.class);
        checkLogFactory(new CommonsLogFactory(), LOG_NAME, org.apache.commons.logging.Log.class);
        checkLogFactory(new JBossLogFactory(), LOG_NAME, org.jboss.logging.Logger.class);
        checkLogFactory(new FluentLogFactory(), LOG_NAME, org.fluentd.logger.FluentLogger.class);
        checkLogFactory(
            new Syslog4jLogFactory(),
            Syslog4jLogFactory.DEFAULT_PROTOCOL,
            org.productivity.java.syslog4j.SyslogIF.class
        );
        checkLogFactory(
            new Syslog4jGraylogLogFactory(),
            Syslog4jLogFactory.DEFAULT_PROTOCOL,
            org.graylog2.syslog4j.SyslogIF.class
        );
    }

    
    private void checkLogFactory(
        final LogFactory logFactory, final String loggerName, final Class<?> loggerClass
    ) {
        Assert.assertNotNull(logFactory.createLogger(getClass()));
        Assert.assertNotNull(logFactory.createLogger(loggerName));
        Assert.assertFalse(logFactory.isCompatible(null));
        Assert.assertTrue(logFactory.isCompatible(loggerClass));
    }
    
}
