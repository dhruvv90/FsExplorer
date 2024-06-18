package org.dhruv.core.command;

import org.dhruv.exception.InvalidInputsException;

import java.util.List;

public class CdCommand extends BaseCommand {

    @Override
    public void validateAndExecute(List<String> tokens) throws InvalidInputsException {
        if (tokens.size() > 2) {
            throw new InvalidInputsException(INVALID_INPUTS_EXCEPTION_MSG);
        }

        if (tokens.size() == 1) {
            this.fs.navigateToRoot();
        } else if (tokens.get(1).equals("..")) {
            this.fs.navigateUp();
        } else {
            this.fs.navigateToNamedDirectory(tokens.get(1));
        }
    }

}
