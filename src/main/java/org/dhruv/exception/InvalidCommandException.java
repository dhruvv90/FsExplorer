package org.dhruv.exception;

public class InvalidCommandException extends FileSystemExplorerException{

    public InvalidCommandException() {
        super();
    }

    public InvalidCommandException(String message){
        super(message);
    }
}
