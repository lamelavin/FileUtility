package com.lavin.fileutility.command;

import com.lavin.fileutility.context.CurrentDirectory;
import com.lavin.fileutility.service.ReadFileService;

import java.io.FileNotFoundException;

public class ReadFileCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: read <filename>");
            return;
        }

        String filename = args[0];

        CurrentDirectory ctx = new CurrentDirectory();
        ReadFileService readFileService = new ReadFileService();

        try {
            readFileService.readFile(ctx.getCurrentDir(), filename);
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("EXCEPTION: " + fileNotFoundException.getMessage());
        }
    }
}
