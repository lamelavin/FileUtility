package com.lavin.fileutility.command;

import com.lavin.fileutility.service.ClearService;

public class ClearCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length != 0) {
            System.out.println("Usage: clear");
            return;
        }

        ClearService clearService = new ClearService();
        clearService.clear();
    }
}
