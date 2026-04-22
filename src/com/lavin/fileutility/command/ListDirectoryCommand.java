package com.lavin.fileutility.command;

import com.lavin.fileutility.service.ListDirectoryService;

import java.io.FileNotFoundException;

public class ListDirectoryCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length > 1) {
            System.out.println("Usage: list [directoryName]");
            return;
        }

        ListDirectoryService listDirectoryService = new ListDirectoryService();

        try {
            if (args.length == 0) {
                listDirectoryService.listDirectory(".");
            } else {
                listDirectoryService.listDirectory(args[0]);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("EXCEPTION: " + fileNotFoundException.getMessage());
        }
    }
}
