package org.dhruv.exception;

public class InvalidCommandException extends FileSystemExplorerException{

    public InvalidCommandException() {
        super("Invalid Command!");
    }

    public InvalidCommandException(String message){
        super("Invalid Command!" + message);
    }
}
