package com.lavin.fileutility.command;

import com.lavin.fileutility.customexceptions.InvalidFlagException;
import com.lavin.fileutility.context.CurrentDirectory;
import com.lavin.fileutility.service.SortService;

import java.io.IOException;

public class SortCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length > 2) {
            System.out.println("Usage: sort <-flag>");
            return;
        }

//        String flag= args[0];

        CurrentDirectory ctx = new CurrentDirectory();
        SortService sortService = new SortService();

        try {
            sortService.sort(ctx.getCurrentDir(), args);
        } catch (InvalidFlagException | IOException exception) {
            System.out.println("EXCEPTION: " + exception.getMessage());
        }
    }
}
