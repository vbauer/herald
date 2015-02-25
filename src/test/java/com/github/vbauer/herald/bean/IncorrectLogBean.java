package com.github.vbauer.herald.bean;

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

}
