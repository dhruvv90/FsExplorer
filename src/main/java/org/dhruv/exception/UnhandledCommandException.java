package org.dhruv.exception;

public class UnhandledCommandException extends FileSystemExplorerException{
    public UnhandledCommandException() {
        super();
    }

    public UnhandledCommandException(String message) {
        super(message);
    }
}
