package com.lavin.fileutility.command;

import com.lavin.fileutility.service.EraseFolderService;

import java.io.FileNotFoundException;

public class EraseFolderCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: erdir <folderName>");
            return;
        }

        EraseFolderService eraseFolderService = new EraseFolderService();

        try {
            eraseFolderService.eraseFolder(args);
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("EXCEPTION: " + fileNotFoundException.getMessage());
        }
    }
}
