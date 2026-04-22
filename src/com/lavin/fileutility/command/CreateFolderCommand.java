package com.lavin.fileutility.command;

import com.lavin.fileutility.service.FolderService;

import java.nio.file.FileAlreadyExistsException;

public class CreateFolderCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: crdir <foldername>");
            return;
        }
        FolderService folderService = new FolderService();

        try {
            folderService.createFolder(args);
        } catch (FileAlreadyExistsException fileAlreadyExistsException) {
            System.out.println("Failed to create directories: " + fileAlreadyExistsException.getMessage());
        }
    }
}
