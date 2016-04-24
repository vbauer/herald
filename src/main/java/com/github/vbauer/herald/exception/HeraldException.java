package com.github.vbauer.herald.exception;

/**
 * @author Vladislav Bauer
 */

@SuppressWarnings("serial")
public abstract class HeraldException extends RuntimeException {

    @Override
    public String getMessage() {
        return "You shouldn't see this error message. Override it in the sub-class";
    }

}
