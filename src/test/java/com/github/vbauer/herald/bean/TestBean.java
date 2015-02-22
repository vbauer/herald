package com.github.vbauer.herald.bean;

import com.github.vbauer.herald.annotation.Log;
import org.springframework.stereotype.Component;

/**
 * @author Vladislav Bauer
 */

@Component
public class TestBean {

    @Log
    private java.util.logging.Logger javaUtilLogger;

    @Log
    private org.apache.commons.logging.Log commonsLoggingLogger;


    public java.util.logging.Logger getJavaUtilLogger() {
        return javaUtilLogger;
    }

    public org.apache.commons.logging.Log getCommonsLoggingLogger() {
        return commonsLoggingLogger;
    }

}
