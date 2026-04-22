package com.lavin.fileutility.command;

import com.lavin.fileutility.context.CurrentDirectory;
import com.lavin.fileutility.service.FindFilesService;

import java.io.IOException;

public class FindFilesCommand implements Command {
    @Override
    public void execute(String[] args) {
        // find filename

        if (args.length != 1) {
            System.out.println("Usage: find <filename>");
            return;
        }

        CurrentDirectory ctx = new CurrentDirectory();
        FindFilesService findFilesService = new FindFilesService();

        try {
            findFilesService.findFiles(ctx.getCurrentDir(), args[0]);
        } catch (IOException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }
    }
}
