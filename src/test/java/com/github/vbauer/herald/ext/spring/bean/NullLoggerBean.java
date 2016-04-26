package com.github.vbauer.herald.ext.spring.bean;

import com.github.vbauer.herald.annotation.Log;
import com.github.vbauer.herald.logger.empty.NullLogger;

/**
 * @author Vladislav Bauer
 */
public class NullLoggerBean {

    @Log
    private NullLogger logger;

    public NullLogger getLogger() {
        return logger;
    }

}
