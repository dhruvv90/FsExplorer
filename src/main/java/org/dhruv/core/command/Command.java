package org.dhruv.core.command;

import org.dhruv.exception.InvalidInputsException;

public interface Command {

    void execute() throws InvalidInputsException;

}
