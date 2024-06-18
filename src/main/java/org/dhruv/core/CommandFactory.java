package org.dhruv.core;

import org.dhruv.core.command.*;

import java.util.Map;
import java.util.Optional;

import static java.util.Map.entry;

public class CommandFactory {

    private final Map<CommandType, Command> cmdMap;

    public CommandFactory(){
        this.cmdMap = Map.ofEntries(
                entry(CommandType.CD, new CdCommand()),
                entry(CommandType.MKDIR, new MkDirCommand()),
                entry(CommandType.LL, new LLCommand()),
                entry(CommandType.RM, new RmCommand()),
                entry(CommandType.TOUCH, new TouchCommand()),
                entry(CommandType.HELP, new HelpCommand()),
                entry(CommandType.LS, new LsCommand())
        );
    }

    public Optional<Command> getCommand(CommandType cmdType){
        if(cmdMap.containsKey(cmdType)){
            return Optional.of(cmdMap.get(cmdType));
        }
        return Optional.empty();
    }
}
