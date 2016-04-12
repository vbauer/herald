package com.github.vbauer.herald.logger.checker;

import com.github.vbauer.herald.ext.spring.bean.ClassLogBean;
import org.springframework.util.Assert;

/**
 * @author Vladislav Bauer
 */

public final class ClassLogBeanChecker {

    private ClassLogBeanChecker() {
        throw new UnsupportedOperationException();
    }


    public static void check(final ClassLogBean bean) {
        Assert.notNull(ClassLogBean.getStaticJavaUtilLogger());
        Assert.notNull(bean.getJavaUtilLogger());
        Assert.notNull(bean.getCommonsLoggingLogger());
        Assert.notNull(bean.getLogbackLogger());
        Assert.notNull(bean.getSlf4jLogger());
        Assert.notNull(bean.getSlf4jExtLogger());
        Assert.notNull(bean.getLog4jLogger());
        Assert.notNull(bean.getLog4j2Logger());
        Assert.notNull(bean.getJBossLogger());
        Assert.notNull(bean.getSyslog4jLogger());
        Assert.notNull(bean.getSyslog4jGraylogLogger());
        Assert.notNull(bean.getFluentLogger());
        Assert.isTrue(bean.getNotLogger() == ClassLogBean.DEF_NOT_LOGGER_VALUE);
    }

}
