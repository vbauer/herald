package com.github.vbauer.herald.ext.spring.bean;

import com.github.vbauer.herald.annotation.Log;

/**
 * @author Vladislav Bauer
 */

public class IncorrectLogBean {

    @Log
    private Object badLogger;


    public Object getBadLogger() {
        return badLogger;
    }


    /**
     * Fake class to check synthetic fields.
     *
     * @author Vladislav Bauer
     */

    public class SyntheticTestClass {
    }

    /**
     * Fake class to check logger injector in case of zero fields.
     *
     * @author Vladislav Bauer
     */
    @Log
    public static class EmptyTestClass {
    }

}
