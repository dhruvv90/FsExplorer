package org.dhruv.core.command;

import org.dhruv.core.entities.FileSystem;
import org.dhruv.exception.InvalidInputsException;

public class RmCommand implements Command{
    private final FileSystem fs;
    private final String itemName;

    public RmCommand(FileSystem fs, String itemName){
        this.fs = fs;
        this.itemName =itemName;
    }

    @Override
    public void execute() throws InvalidInputsException {
        this.fs.deleteItem(this.itemName);
    }

}
