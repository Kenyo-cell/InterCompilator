package ru.mirea.service;

import org.springframework.stereotype.Service;

import java.io.File;

@Service
public abstract class IExecutionService {
    protected abstract File execute(File executionFile, File inputFile);
}
