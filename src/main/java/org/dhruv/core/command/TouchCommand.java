package org.dhruv.core.command;

import org.dhruv.core.entities.FileSystem;
import org.dhruv.exception.InvalidInputsException;

public class TouchCommand implements Command {
    private final FileSystem fs;
    private final String fileName;

    public TouchCommand(FileSystem fs, String fileName) throws InvalidInputsException {
        String[] tokens = fileName.split("\\.");
        if (tokens.length < 2) {
            throw new InvalidInputsException();
        }

        this.fs = fs;
        this.fileName = fileName;
    }

    @Override
    public void execute() throws InvalidInputsException {
        this.fs.createFile(this.fileName);
    }

}
