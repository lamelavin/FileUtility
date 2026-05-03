package com.lavin.fileutility.command;

import com.lavin.fileutility.customexceptions.InvalidFlagException;
import com.lavin.fileutility.service.ListDirectoryService;

import java.io.FileNotFoundException;

public class ListDirectoryCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length > 1) {
            if (!args[1].startsWith("-")) {
                System.out.println("Usage: list [directoryName]");
                return;
            }
        }

        ListDirectoryService listDirectoryService = new ListDirectoryService();

        String flag = "";
        String directoryName = ".";
        try {
            if (args.length == 0) {
                listDirectoryService.listDirectory(directoryName, flag);
            } else {
                if (args.length == 2)
                    flag = args[1];

                if (!args[0].startsWith("-"))
                    directoryName = args[0];
                else
                    flag = args[0];

                if (!"-h".equalsIgnoreCase(flag) && !flag.equalsIgnoreCase(""))
                    throw new InvalidFlagException("Invalid flag " + flag);

                listDirectoryService.listDirectory(directoryName, flag);
            }
        } catch (FileNotFoundException | InvalidFlagException exception) {
            System.out.println("EXCEPTION: " + exception.getMessage());
        }
    }
}
