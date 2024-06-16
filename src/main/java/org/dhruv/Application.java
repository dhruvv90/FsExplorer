package org.dhruv;

import org.dhruv.core.*;
import org.dhruv.core.entities.FileSystem;
import org.dhruv.exception.FileSystemExplorerException;

import java.util.Scanner;

public class Application {

    private final Scanner scanner;

    private final CommandParser cmdParser;
    private final FileSystem fs;

    Application(String... args) {
        System.out.println("Welcome to the File System Explorer !");

        this.fs = FileSystem.buildOrGet();
        cmdParser = new CommandParser(fs);
        scanner = new Scanner(System.in);
    }

    public void run() {
        boolean toContinue = true;
        while (toContinue) {
            try {
                System.out.print(fs.getCurrentPath() + "$> ");
                String input = scanner.nextLine();
                toContinue = cmdParser.parse(input);
            } catch (FileSystemExplorerException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
