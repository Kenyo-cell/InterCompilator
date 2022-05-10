package ru.mirea.service;

import ru.mirea.exception.ExecutionTransferException;

import java.io.InputStream;

public abstract class IExecutionService {
    protected final int TIMEOUT = 30;
    public abstract byte[] execute(String language, InputStream source, InputStream input) throws ExecutionTransferException;
}
