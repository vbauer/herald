package com.github.vbauer.herald.bean;

import com.github.vbauer.herald.annotation.Log;
import org.springframework.stereotype.Component;

/**
 * @author Vladislav Bauer
 */

public class IncorrectLogBean {

    @Log
    private Object badLogger;


    public Object getBadLogger() {
        return badLogger;
    }

}
