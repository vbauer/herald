package com.github.vbauer.herald.logger.impl;

/**
 * <b>IMPORTANT:</b>
 * This is a repackaged fork used in Graylog2, as the original package has no recent versions
 * published to Maven Central.
 *
 * @author Vladislav Bauer
 */

public class Syslog4jGraylogLogFactory extends SimpleLogFactory {

    public static final String LOGGER_CLASS_NAME = "org.graylog2.syslog4j.SyslogIF";
    public static final String FACTORY_CLASS_NAME = "org.graylog2.syslog4j.Syslog";
    public static final String FACTORY_METHOD_NAME = "getInstance";

    public static final String DEFAULT_PROTOCOL = "udp";


    public Syslog4jGraylogLogFactory() {
        super(LOGGER_CLASS_NAME, FACTORY_CLASS_NAME, FACTORY_METHOD_NAME);
    }


    /**
     * Create SyslogIF client using {@value #DEFAULT_PROTOCOL}.
     *
     * @param clazz parameters is not used
     * @return logger
     */
    @Override
    public Object createLogger(final Class<?> clazz) {
        return createLogger(DEFAULT_PROTOCOL);
    }

}
