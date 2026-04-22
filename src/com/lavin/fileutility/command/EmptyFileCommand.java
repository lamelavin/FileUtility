package com.lavin.fileutility.command;

import com.lavin.fileutility.context.CurrentDirectory;
import com.lavin.fileutility.service.EmptyFileService;

import java.io.FileNotFoundException;

public class EmptyFileCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: empty <filename>");
            return;
        }

        CurrentDirectory ctx = new CurrentDirectory();
        EmptyFileService emptyFileService = new EmptyFileService();

        try {
            emptyFileService.emptyFile(ctx.getCurrentDir(), args);
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("EXCEPTION: " + fileNotFoundException.getMessage());
        }
    }
}
