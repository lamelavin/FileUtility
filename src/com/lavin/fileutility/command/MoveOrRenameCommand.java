package com.lavin.fileutility.command;

import com.lavin.fileutility.service.MoveOrRenameService;

import java.io.IOException;

public class MoveOrRenameCommand implements Command {
    @Override
    public void execute(String[] args) {
        /*
        two cases :
        rename -
        mv /home/lavin/fileutility /home/lavin/FileUtility

        move -
        mv /home/lavin/fileutility/main.java /home/lavin/fileutility/src/main.java
         */

        if (args.length != 2) {
            System.out.println("Usage: mv <sourcePath> <destinationPath>");
            return;
        }

        String source = args[0];
        String destination = args[1];

        MoveOrRenameService moveOrRenameService = new MoveOrRenameService();

        try {
            moveOrRenameService.moveOrRename(source, destination);
        } catch (IOException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }

    }
}
