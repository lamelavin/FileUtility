package com.lavin.fileutility.command;

import com.lavin.fileutility.context.CurrentDirectory;
import com.lavin.fileutility.service.EraseFileService;

import java.io.FileNotFoundException;

public class EraseFileCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: erase <filename>");
            return;
        }

        String name = args[0];

        if (args.length > 1) {
            System.out.println("Usage: erase <filename>");
            return;
        }

        CurrentDirectory ctx = new CurrentDirectory();
        EraseFileService eraseFileService = new EraseFileService();

        try {
            eraseFileService.eraseFile(ctx.getCurrentDir(), name);
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("EXCEPTION : " + fileNotFoundException.getMessage());
        }
    }
}
