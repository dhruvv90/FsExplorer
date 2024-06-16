package org.dhruv.core.command;

import org.dhruv.core.entities.FileSystem;
import org.dhruv.exception.InvalidInputsException;

public class MkDirCommand implements Command {

    private final FileSystem fs;
    private final String name;

    public MkDirCommand(FileSystem fs, String name) {
        this.fs = fs;
        this.name = name;
    }

    @Override
    public void execute() throws InvalidInputsException {
        fs.createDirectory(name);
    }

}
