package com.github.vbauer.herald.logger.impl;

/**
 * @author Vladislav Bauer
 *
 * Additional information how to configure protocols: http://syslog4j.org/docs/examples/examples.html
 */

public class Syslog4jLogFactory extends SimpleLogFactory {

    public static final String LOGGER_CLASS_NAME = "org.productivity.java.syslog4j.SyslogIF";
    public static final String FACTORY_CLASS_NAME = "org.productivity.java.syslog4j.Syslog";
    public static final String FACTORY_METHOD_NAME = "getInstance";

    public static final String DEFAULT_PROTOCOL = "udp";


    public Syslog4jLogFactory() {
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
