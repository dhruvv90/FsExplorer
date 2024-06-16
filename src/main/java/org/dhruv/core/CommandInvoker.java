package org.dhruv.core;

import lombok.NoArgsConstructor;
import org.dhruv.core.command.Command;
import org.dhruv.exception.InvalidInputsException;


@NoArgsConstructor
public class CommandInvoker {

    public void invoke(Command command) throws InvalidInputsException {
        command.execute();
    }
}
