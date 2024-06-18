package org.dhruv.core.command;

import org.dhruv.core.CommandType;
import org.dhruv.exception.InvalidInputsException;

import java.util.List;

public class HelpCommand extends BaseCommand{

    @Override
    public void validateAndExecute(List<String> tokens) throws InvalidInputsException {
        if (tokens.size() < 2) {
            throw new InvalidInputsException(INVALID_INPUTS_EXCEPTION_MSG);
        }
        CommandType cmdType = CommandType.fromString(tokens.get(1));
        if(cmdType == null){
            throw new InvalidInputsException();
        }
        System.out.println(cmdType.getHelpText());
    }

}


