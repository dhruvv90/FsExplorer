package org.dhruv.core;

import org.dhruv.core.command.*;
import org.dhruv.exception.FileSystemExplorerException;
import org.dhruv.exception.InvalidCommandException;
import org.dhruv.exception.UnhandledCommandException;

import java.util.List;
import java.util.Stack;

public class CommandParser {

    private final Stack<String> commandHistory;
    private ParserStatus parserStatus;
    private final CommandFactory commandFactory;

    public CommandParser() {
        this.commandHistory = new Stack<>();
        this.parserStatus = ParserStatus.ACTIVE;
        this.commandFactory = new CommandFactory();
    }

    private List<String> tokenizeCommand(String rawCmd) {
        String[] tokens = rawCmd.trim().split("\\s+");
        return List.of(tokens);
    }

    public boolean isActive() {
        return parserStatus.equals(ParserStatus.ACTIVE);
    }

    private void printHistory(){
        for (String raw : commandHistory) {
            System.out.println(raw);
        }
    }

    public void parse(String rawCmd) throws FileSystemExplorerException {
        if (!isActive()) {
            throw new FileSystemExplorerException("Unable to process more commands");
        }

        if (rawCmd.isEmpty()) {
            return;
        }

        // extract command
        List<String> tokens = tokenizeCommand(rawCmd);
        CommandType cmdType = CommandType.fromString(tokens.getFirst());

        if (cmdType == CommandType.INVALID) {
            throw new InvalidCommandException(cmdType.getHelpText());
        }

        if(cmdType == CommandType.EXIT){
            this.parserStatus = ParserStatus.STOPPED;
            return;
        }

        if(cmdType == CommandType.HISTORY){
            printHistory();
            return;
        }

        Command command = commandFactory.getCommand(cmdType).orElseThrow(UnhandledCommandException::new);
        command.validateAndExecute(tokens);
        commandHistory.push(rawCmd);
    }

    private enum ParserStatus {
        ACTIVE,
        STOPPED
    }
}
