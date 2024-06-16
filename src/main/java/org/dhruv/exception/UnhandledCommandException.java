package org.dhruv.exception;

public class UnhandledCommandException extends FileSystemExplorerException{
    public UnhandledCommandException() {
        super("Unhandled Command!");
    }
}
