package com.lavin.fileutility.command;

import com.lavin.fileutility.context.CurrentDirectory;
import com.lavin.fileutility.service.PrintWorkingDirectoryService;

public class PrintWorkingDirectoryCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length > 1) {
            System.out.println("Usage: pwd");
            return;
        }

        CurrentDirectory ctx = new CurrentDirectory();
        PrintWorkingDirectoryService printWorkingDirectoryService = new PrintWorkingDirectoryService();

        printWorkingDirectoryService.printWorkingDirectory(ctx.getCurrentDir());
    }
}
