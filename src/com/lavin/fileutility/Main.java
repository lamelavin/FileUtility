package com.lavin.fileutility;

import com.lavin.fileutility.context.CurrentDirectory;
import com.lavin.fileutility.manager.CommandManager;
import com.lavin.fileutility.parser.InputParser;
import com.lavin.fileutility.parser.ParsedInput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        CurrentDirectory currentDirectory = new CurrentDirectory();

        while (!input.equalsIgnoreCase("exit")) {
            try {
                if (currentDirectory.getCurrentDir().getFileName() == null) {
                    System.out.print("\nFileMgr (/):> ");
                } else {
                    System.out.printf("\nFileMgr (%s):> ", currentDirectory.getCurrentDir().getFileName());
                }
                input = scanner.nextLine();

                if (input.equals("exit") || input.isEmpty()) continue;

                InputParser parser = new InputParser();
                ParsedInput parsedInput = parser.parse(input);

                CommandManager manager = new CommandManager();
                manager.run(parsedInput.command(), parsedInput.args());

            } catch (Exception e) {
                System.out.println("INVALID INPUT from Main : " + e.getMessage());
            }
        }
        scanner.close();
    }
}
