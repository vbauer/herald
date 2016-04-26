package com.github.vbauer.herald.logger;

import com.github.vbauer.herald.core.BasicTest;
import com.github.vbauer.herald.exception.LoggerInstantiationException;
import com.github.vbauer.herald.ext.spring.bean.NullLoggerBean;
import com.github.vbauer.herald.logger.impl.CommonsLogFactory;
import com.github.vbauer.herald.logger.impl.FluentLogFactory;
import com.github.vbauer.herald.logger.impl.JBossLogFactory;
import com.github.vbauer.herald.logger.impl.JavaUtilLogFactory;
import com.github.vbauer.herald.logger.impl.Log4j2LogFactory;
import com.github.vbauer.herald.logger.impl.Log4jLogFactory;
import com.github.vbauer.herald.logger.impl.Slf4jExtLogFactory;
import com.github.vbauer.herald.logger.impl.Slf4jLogFactory;
import com.github.vbauer.herald.logger.impl.Syslog4jGraylogLogFactory;
import com.github.vbauer.herald.logger.impl.Syslog4jLogFactory;
import com.github.vbauer.herald.util.LoggerInjector;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * @author Vladislav Bauer
 */

public class LogFactoryTest extends BasicTest {
    
    private static final String LOG_NAME = "Logger Name";


    @Test(expected = LoggerInstantiationException.class)
    public void testWrongCustomLogFactory() {
        final NullLoggerBean bean = new NullLoggerBean();
        fail(LoggerInjector.inject(bean).toString());
    }

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
        assertThat(logFactory.createLogger(getClass()), notNullValue());
        assertThat(logFactory.createLogger(loggerName), notNullValue());
        assertThat(logFactory.isCompatible(null), equalTo(false));
        assertThat(logFactory.isCompatible(loggerClass), equalTo(true));
    }
    
}
