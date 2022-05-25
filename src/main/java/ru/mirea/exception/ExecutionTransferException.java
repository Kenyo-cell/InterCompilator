package ru.mirea.exception;

public class ExecutionTransferException extends RuntimeException{
    public ExecutionTransferException() {
        super();
    }

    public ExecutionTransferException(String message) {
        super(message);
    }

    public ExecutionTransferException(String message, Throwable cause) {
        super(message, cause);
    }
}
