package com.fit.core.exception;

public class CustomException {
    public static RuntimeException unchecked(Exception e) {
        return (e instanceof RuntimeException) ? (RuntimeException) e : new UncheckedException(e);
    }

    public static class UncheckedException extends RuntimeException {
        public UncheckedException(Exception e) {
            super(e);
        }
    }

    public static class MandatoryEnvException extends RuntimeException {
        public MandatoryEnvException(String message) {
            super(message);
        }
    }
}
