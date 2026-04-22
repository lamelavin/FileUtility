package com.lavin.fileutility.command;

import com.lavin.fileutility.context.CurrentDirectory;
import com.lavin.fileutility.service.SwitchDirectoryService;

public class SwitchDirectoryCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: sd <directory>");
            return;
        }

        CurrentDirectory ctx = new CurrentDirectory();
        SwitchDirectoryService switchDirectoryService = new SwitchDirectoryService();

        try {
            switchDirectoryService.switchDirectory(ctx, args);
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }

    }
}
