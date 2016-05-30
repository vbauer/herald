package com.github.vbauer.herald.exception;

/**
 * Basic class for hierarchy of Herald exceptions.
 *
 * @author Vladislav Bauer
 */

@SuppressWarnings("serial")
public abstract class HeraldException extends RuntimeException {

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMessage() {
        return "You shouldn't see this error message. Override it in the sub-class";
    }

}
