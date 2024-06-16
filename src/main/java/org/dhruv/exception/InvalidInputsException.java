package org.dhruv.exception;

import lombok.NoArgsConstructor;

public class InvalidInputsException extends FileSystemExplorerException{
    public InvalidInputsException() {
        super("Invalid Input parameters");
    }

    public InvalidInputsException(String message) {
        super(message);
    }
}
