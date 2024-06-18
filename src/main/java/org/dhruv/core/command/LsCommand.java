package org.dhruv.core.command;

import org.dhruv.core.entities.FsItem;
import org.dhruv.exception.InvalidInputsException;

import java.util.List;

public class LsCommand extends BaseCommand {

    @Override
    public void validateAndExecute(List<String> tokens) throws InvalidInputsException {
        if (tokens.size() != 1) {
            throw new InvalidInputsException(INVALID_INPUTS_EXCEPTION_MSG);
        }
        for(FsItem i: fs.getContents()){
            System.out.println(i.getName());
        }
    }
}
