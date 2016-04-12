package com.github.vbauer.herald.logger.checker;

import com.github.vbauer.herald.ext.spring.bean.LogBean;
import org.springframework.util.Assert;

/**
 * @author Vladislav Bauer
 */

public final class LogBeanChecker {

    private LogBeanChecker() {
        throw new UnsupportedOperationException();
    }


    public static void check(final LogBean bean) {
        Assert.notNull(LogBean.getStaticJavaUtilLogger());
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
    }

}
