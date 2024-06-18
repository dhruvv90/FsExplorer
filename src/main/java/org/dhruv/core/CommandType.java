package org.dhruv.core;

import lombok.Getter;

@Getter
public enum CommandType {
    MKDIR( "Create a directory"),
    CD( "Navigate to a directory"),
    RM( "Delete an item"),
    EXIT( "Exit file system"),
    LS("Show contents"),
    LL( "Show contents"),
    HELP( "get help"),
    TOUCH("create a text file"),
    HISTORY("See command history"),
    INVALID("Invalid Command !")
    ;

    private final String helpText;

    CommandType(String helpText) {
        this.helpText = helpText;
    }

    public static CommandType fromString(String cmd) {
        try {
            return CommandType.valueOf(cmd.toUpperCase());
        } catch (IllegalArgumentException e) {
            return CommandType.INVALID;
        }
    }
}
