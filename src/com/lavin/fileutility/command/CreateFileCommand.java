package com.lavin.fileutility.command;

import com.lavin.fileutility.context.CurrentDirectory;
import com.lavin.fileutility.service.FileService;

import java.nio.file.FileAlreadyExistsException;

public class CreateFileCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: create <filename> \"content\"");
            return;
        }

        String fileName = args[0];
        String content = "";

        if (args.length > 1)
            content = args[1];

        CurrentDirectory ctx = new CurrentDirectory();
        FileService fileService = new FileService();

        try {
            fileService.createFile(ctx.getCurrentDir(), fileName, content);
        } catch (FileAlreadyExistsException fileAlreadyExistsException) {
            System.out.println("EXCEPTION : " + fileAlreadyExistsException.getMessage());
        }
    }
}
