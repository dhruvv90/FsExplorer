package org.dhruv.core.command;

import org.dhruv.exception.InvalidInputsException;

import java.util.List;

public interface Command {

    void validateAndExecute(List<String> tokens) throws InvalidInputsException;

}
