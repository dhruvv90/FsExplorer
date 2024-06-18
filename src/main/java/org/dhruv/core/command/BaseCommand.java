package org.dhruv.core.command;

import org.dhruv.core.entities.FileSystem;

public abstract class BaseCommand implements Command {

    protected final String INVALID_INPUTS_EXCEPTION_MSG;
    protected final FileSystem fs;

    BaseCommand() {
        this.fs = FileSystem.buildOrGet();
        INVALID_INPUTS_EXCEPTION_MSG = "Invalid command signature!";
    }
}
