package com.github.vbauer.herald.logger.checker;

import com.github.vbauer.herald.ext.spring.bean.NamedLogBean;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author Vladislav Bauer
 */

public final class NamedLogBeanChecker {

    private NamedLogBeanChecker() {
        throw new UnsupportedOperationException();
    }


    public static void check(final NamedLogBean bean) {
        assertThat(NamedLogBean.getStaticJavaUtilLogger(), notNullValue());
        assertThat(bean.getJavaUtilLogger(), notNullValue());
        assertThat(bean.getCommonsLoggingLogger(), notNullValue());
        assertThat(bean.getLogbackLogger(), notNullValue());
        assertThat(bean.getSlf4jLogger(), notNullValue());
        assertThat(bean.getSlf4jExtLogger(), notNullValue());
        assertThat(bean.getLog4jLogger(), notNullValue());
        assertThat(bean.getLog4j2Logger(), notNullValue());
        assertThat(bean.getJBossLogger(), notNullValue());
        assertThat(bean.getSyslog4jLogger(), notNullValue());
        assertThat(bean.getSyslog4jGraylogLogger(), notNullValue());
        assertThat(bean.getFluentLogger(), notNullValue());
    }

}
