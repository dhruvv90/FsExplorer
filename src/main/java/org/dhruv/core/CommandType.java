package org.dhruv.core;

import lombok.AccessLevel;
import lombok.Getter;

public enum CommandType {
    MKDIR( "Create a directory"),
    CD( "Navigate to a directory"),
    RM( "Delete an item"),
    EXIT( "Exit file system"),
    LS("Show contents"),
    LL( "Show contents"),
    HELP( "get help"),
    TOUCH("create a text file"),
    HISTORY("See command history")

    ;

    @Getter(AccessLevel.PRIVATE)
    private final String helpText;

    CommandType(String helpText) {
        this.helpText = helpText;
    }

    public static CommandType fromString(String cmd) {
        try {
            return CommandType.valueOf(cmd.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public static String getHelpText(CommandType cmdType){
        return cmdType.getHelpText();
    }
}
