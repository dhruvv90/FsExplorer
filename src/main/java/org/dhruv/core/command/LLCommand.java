package org.dhruv.core.command;

import org.dhruv.core.entities.FsItem;
import org.dhruv.exception.InvalidInputsException;

import java.util.List;

public class LLCommand extends BaseCommand {

    @Override
    public void validateAndExecute(List<String> tokens) throws InvalidInputsException {
        if (tokens.size() != 1) {
            throw new InvalidInputsException(INVALID_INPUTS_EXCEPTION_MSG);
        }
        List<FsItem> items = fs.getContents();
        System.out.println("Total Items: " + items.size());
        for (FsItem i : items) {
            System.out.println(i.getName() + " " + i.getMetadata().getCreated() + " " + i.getMetadata().getModified());
        }
    }
}
