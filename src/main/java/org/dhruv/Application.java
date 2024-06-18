package org.dhruv;

import org.dhruv.core.*;
import org.dhruv.core.entities.FileSystem;
import org.dhruv.exception.FileSystemExplorerException;

import java.util.Scanner;

public class Application {

    private final Scanner scanner;
    private final CommandParser parser;
    private final FileSystem fs;

    Application(String... args) {
        System.out.println("Welcome to the File System Explorer !");

        fs = FileSystem.buildOrGet();
        parser = new CommandParser();
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (parser.isActive()) {
            try {
                System.out.print(fs.getCurrentPath() + "$> ");
                String input = scanner.nextLine();
                parser.parse(input);
            } catch (FileSystemExplorerException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
