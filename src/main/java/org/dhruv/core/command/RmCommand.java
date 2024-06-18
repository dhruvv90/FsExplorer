package org.dhruv.core.command;

import org.dhruv.exception.InvalidInputsException;

import java.util.List;

public class RmCommand extends BaseCommand {

    @Override
    public void validateAndExecute(List<String> tokens) throws InvalidInputsException {
        if (tokens.size() != 2) {
            throw new InvalidInputsException(INVALID_INPUTS_EXCEPTION_MSG);
        }
        this.fs.deleteItem(tokens.get(1));
    }

}
