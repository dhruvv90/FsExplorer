package org.dhruv.core;

import org.dhruv.core.command.*;
import org.dhruv.core.entities.FileSystem;
import org.dhruv.exception.FileSystemExplorerException;
import org.dhruv.exception.InvalidCommandException;
import org.dhruv.exception.InvalidInputsException;
import org.dhruv.exception.UnhandledCommandException;

import java.util.Stack;

public class CommandParser {

    private final FileSystem fs;
    private final CommandInvoker commandInvoker;
    private final Stack<String> commandHistory;

    public CommandParser(FileSystem fs) {
        this.fs = fs;
        this.commandInvoker = new CommandInvoker();
        this.commandHistory = new Stack<>();
    }

    public boolean parse(String rawCmd) throws FileSystemExplorerException {
        if (rawCmd.isEmpty()) {
            return true;
        }

        // extract command
        String[] pieces = rawCmd.trim().split("\\s+");
        CommandType cmdType = CommandType.fromString(pieces[0]);
        Command command = null;

        boolean toContinue = true;

        switch (cmdType) {
            case null:
                throw new InvalidCommandException();

            case EXIT:
                toContinue = false;
                break;

            case HELP:
                if (pieces.length < 2) {
                    throw new InvalidInputsException("Invalid command signature!");
                }
                CommandType t = CommandType.fromString(pieces[1]);
                if (t == null) {
                    throw new InvalidCommandException();
                }
                command = new HelpCommand(t);
                break;

            case HISTORY:
                for (String raw : commandHistory) {
                    System.out.println(raw);
                }
                break;

            case MKDIR:
                if (pieces.length != 2) {
                    throw new InvalidInputsException("Invalid command signature!");
                }
                command = new MkDirCommand(fs, pieces[1]);
                break;

            case LS:
                if (pieces.length != 1) {
                    throw new InvalidInputsException("Invalid command signature!");
                }
                command = new LsCommand(fs);
                break;

            case LL:
                if (pieces.length != 1) {
                    throw new InvalidInputsException("Invalid command signature!");
                }
                command = new LLCommand(fs);
                break;

            case CD:
                if (pieces.length == 1) {
                    command = new CdCommand(fs);

                } else if (pieces.length == 2) {
                    command = new CdCommand(fs, pieces[1]);
                } else {
                    throw new InvalidInputsException("Invalid command signature!");
                }
                break;

            case TOUCH:
                if (pieces.length != 2) {
                    throw new InvalidInputsException("Invalid command signature!");
                }
                command = new TouchCommand(fs, pieces[1]);
                break;

            case RM:
                if (pieces.length != 2) {
                    throw new InvalidInputsException("Invalid command signature!");
                }
                command = new RmCommand(fs, pieces[1]);
                break;

            default:
                throw new UnhandledCommandException();

        }

        if (command != null) {
            commandInvoker.invoke(command);
            commandHistory.push(rawCmd);
        }

        return toContinue;
    }
}
