package com.lavin.fileutility.manager;

import com.lavin.fileutility.command.*;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private final Map<String, Command> commands = new HashMap<>();

    public CommandManager() {
        commands.put("create", new CreateFileCommand());
        commands.put("crdir", new CreateFolderCommand());
        commands.put("erase", new EraseFileCommand());
        commands.put("erdir", new EraseFolderCommand());
        commands.put("list", new ListDirectoryCommand());
        commands.put("empty", new EmptyFileCommand());
        commands.put("sd", new SwitchDirectoryCommand()); // naw hora
        commands.put("read", new ReadFileCommand());
        commands.put("sort", new SortCommand());
        commands.put("mv", new MoveOrRenameCommand());
        commands.put("find", new FindFilesCommand());
        // helpers
        commands.put("pwd", new PrintWorkingDirectoryCommand()); // for debugging
        commands.put("clear", new ClearCommand()); // to clear the screen
    }

    public void run(String commandName, String[] args) {
        Command cmd = commands.get(commandName);

        if (cmd == null) {
            System.out.println("Unknow command");
            return;
        }

        cmd.execute(args);
    }

}
