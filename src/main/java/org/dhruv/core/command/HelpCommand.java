package org.dhruv.core.command;

import org.dhruv.core.CommandType;

public class HelpCommand implements  Command{

    private final CommandType cmd;

    public HelpCommand(CommandType cmd){
        this.cmd = cmd;
    }

    @Override
    public void execute() {
        System.out.println(CommandType.getHelpText(cmd));
    }

}
